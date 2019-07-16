package by.training.multithreading_matrix.service;

import by.training.multithreading_matrix.dao.DAO;
import by.training.multithreading_matrix.dao.DAOException;
import by.training.multithreading_matrix.dao.DAOFabric;
import by.training.multithreading_matrix.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MatrixService implements Service {

    private static final Logger LOGGER = LogManager.getLogger();
    private final DAO<Matrix> dao = DAOFabric.getDAO();

    @Override
    public Matrix show() {
        LOGGER.info("start show in Service");

        Matrix matrix = dao.get();
        return matrix;
    }

    @Override
    public void update(File file) throws ServiceException {
        LOGGER.info("start update in Service");

        int size;
        int[][] elements;
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
        } catch (IOException e) {
            throw new ServiceException("No such file!");
        }
        size = lines.size();
        if (size < 8 || size > 12) {
            LOGGER.warn("Unuseful information in file");
            throw new ServiceException();
        }
        elements = new int[size][size];
        String[][] values = new String[size][size];
        for (int i = 0; i < size; i++) {
            values[i] = lines.get(i).trim().split(" ");
            if (values[i].length < size) {
                LOGGER.warn("Unuseful information in file");
                throw new ServiceException();
            }
            for (int j = 0; j < size; j++) {
                elements[i][j] = Integer.valueOf(values[i][j]);
            }
        }
        for (int i = 0; i < size; ++i) {
            elements[i][i] = 0;
        }
        try {
            dao.update(elements);
        } catch (DAOException e) {
            LOGGER.warn("Unuseful information in file");
        }
    }

    @Override
    public void fill() throws ServiceException {
        LOGGER.info("start fill in Service");
        if (dao.get() == null) {
            throw new ServiceException();
        }
        Lock locker = new ReentrantLock();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; ++i) {
            threads[i] = new Thread(new FillThread(locker, i));
        }
        for (int i = 0; i < threads.length; ++i) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                LOGGER.error("Error in thread");
                throw new ServiceException();
            }
        }
    }

    private class FillThread implements Runnable {
        private final Lock locker;
        private final int id;

        public FillThread(Lock locker, int id) {
            this.locker = locker;
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < dao.get().getSize(); ++i) {
                locker.lock();
                if (dao.set(i, i, id)) {
                    locker.unlock();
                    try {
                        //Thread.sleep(1000);
                        TimeUnit.MILLISECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        LOGGER.error("Error in thread");
                    }
                } else {
                    locker.unlock();
                }
            }
        }
    }
}
