package by.training.web_parsing.controller;

import by.training.web_parsing.entity.Voucher;
import by.training.web_parsing.service.*;
import by.training.web_parsing.service.parser.ParserException;
import by.training.web_parsing.service.parser.ParserFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

class Parse implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final char paramDelimiter = ' ';

    public String execute(String request) {
        LOGGER.info("Open task: " + request);

        String response = "Error during opening file..";

        if (request.lastIndexOf(paramDelimiter) == -1) {
            LOGGER.error("Illegal request in execute(String request)");
            return response;
        }

        URL res = getClass().getClassLoader().getResource("tourist_vouchers.xsd");
        File xsd = null;
        try {
            xsd = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            LOGGER.error("Error during opening xsd file in execute(String request)");
            return response;
        }

        String pathXml = request.substring(request.lastIndexOf(paramDelimiter) + 1);
        File xml;
        if (pathXml.indexOf('/') != -1 || pathXml.indexOf('\\') != -1) {
            xml = new File(pathXml);
        } else {
            URL url = getClass().getClassLoader().getResource(pathXml);
            try {
                xml = Paths.get(url.toURI()).toFile();
            } catch (URISyntaxException e) {
                LOGGER.error("Error during opening xml file in execute(String request)");
                return response;
            }
        }
        if (!xml.exists()) {
            LOGGER.error("Error during opening xml file in execute(String request)");
            return response;
        }
        if (!xsd.exists()) {
            LOGGER.error("Error during opening xsd file in execute(String request)");
            return response;
        }

        Service<Voucher> service = ServiceFabric.getService();
        if (service.checkXMLByXSD(xml, xsd)) {
            String parserName = request.trim().substring(0, (request.indexOf(paramDelimiter) != -1) ? request.indexOf(paramDelimiter) : request.length());
            try {
                service.update(xml, ParserFabric.getINSTANSE().getParser(parserName));
            } catch (ParserException e) {
                LOGGER.error("Illegal request in execute(String request)");
                return response;
            } catch (ServiceException e) {
                LOGGER.error("Illegal xml file in execute(String request)");
                return response;
            }
            response = "Parsed!";
        } else {
            LOGGER.error("Illegal xml file in execute(String request)");
            return response;
        }

        return response;
    }
}
