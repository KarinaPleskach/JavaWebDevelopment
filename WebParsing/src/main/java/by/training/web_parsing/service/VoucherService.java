package by.training.web_parsing.service;

import by.training.web_parsing.dao.*;
import by.training.web_parsing.entity.Voucher;
import by.training.web_parsing.service.parser.Parser;
import by.training.web_parsing.service.parser.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

class VoucherService implements Service {

    private static final Logger LOGGER = LogManager.getLogger();
    private final DAO<Voucher> dao = DAOFabric.getDAO();

    @Override
    public boolean checkXMLByXSD(File xml, File xsd) {
        LOGGER.info("start checkXMLByXSD in Service");
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (SAXException e) {
            LOGGER.warn("Illegal xml or xsd file");
            return false;
        } catch (IOException e) {
            LOGGER.warn("Illegal xml or xsd file");
            return false;
        }
        return true;
    }

    @Override
    public List<Voucher> show() throws ServiceException {
        LOGGER.info("start show in Service");

        List<Voucher> vouchers;
        try {
            vouchers = dao.get();
        } catch (DAOException e) {
            LOGGER.warn("unuseful result from DAO");
            throw new ServiceException();
        }
        return vouchers;
    }

    @Override
    public void update(File xml, Parser parser) throws ServiceException {
        LOGGER.info("start update in Service");

        try {
            dao.update(parser.parse(xml));
        } catch (DAOException e) {
            String message = "Empty response from DAO";
            LOGGER.info(message + " in update(File xml, Parser parser)");
            throw new ServiceException(message);
        } catch (ParserException e) {
            String message = "Illegal xml file";
            LOGGER.info(message + " in update(File xml, Parser parser)");
            throw new ServiceException(message);
        }
    }
}
