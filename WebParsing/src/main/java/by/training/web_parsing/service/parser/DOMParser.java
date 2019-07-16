package by.training.web_parsing.service.parser;

import by.training.web_parsing.entity.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class DOMParser implements Parser<Voucher> {
    private static final Logger LOGGER = LogManager.getLogger();
    private final List<Voucher> vouchers = new ArrayList<>();

    @Override
    public List<Voucher> parse(File xml) throws ParserException {
        LOGGER.info("start parse in DOMParser");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            String message = "Can not get Document Builder";
            LOGGER.error(message + " in parse(File xml)");
            throw new ParserException(message);
        }
        Document document;
        try {
            document = builder.parse(xml);
        } catch (SAXException e) {
            LOGGER.error("Illegal xml in parse(File xml)");
            throw new ParserException("Can not parse Document");
        } catch (IOException e) {
            LOGGER.error("Illegal xml in parse(File xml)");
            throw new ParserException("Can not parse Document");
        }
        NodeList nodeList = document.getDocumentElement().getElementsByTagName("Voucher");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element node = (Element) nodeList.item(i);
            Voucher voucher = new Voucher();

            NamedNodeMap attributes = node.getAttributes();
            voucher.setType(VoucherType.valueOf(attributes.getNamedItem("type").getNodeValue().toUpperCase()));

            Element childElement = (Element) node.getElementsByTagName("Location").item(0);
            attributes = childElement.getAttributes();
            voucher.setLocation(new Location(attributes.getNamedItem("countryCode").getNodeValue(), attributes.getNamedItem("city").getNodeName()));

            childElement = (Element) node.getElementsByTagName("Duration").item(0);
            attributes = childElement.getAttributes();
            int days = Integer.parseInt(attributes.getNamedItem("days").getNodeValue());
            int nights = Integer.parseInt(attributes.getNamedItem("nights").getNodeValue());
            voucher.setDuration(new Duration(Integer.parseInt(attributes.getNamedItem("days").getNodeValue()), Integer.parseInt(attributes.getNamedItem("nights").getNodeValue())));

            List<Transport> transports = new ArrayList<>();
            NodeList transportsList = ((Element) (node.getElementsByTagName("Transports").item(0))).getElementsByTagName("Transport");
            for (int j = 0; j < transportsList.getLength(); ++j) {
                childElement = (Element) transportsList.item(j);
                attributes = childElement.getAttributes();
                transports.add(new Transport(TransportType.valueOf(attributes.getNamedItem("type").getNodeValue().toUpperCase())));
            }
            voucher.setTransports(transports);

            Hotel hotel = new Hotel();

            List<Room> rooms = new ArrayList<>();
            NodeList roomsList = node.getElementsByTagName("Room");
            for (int j = 0; j < roomsList.getLength(); ++j) {
                childElement = (Element) roomsList.item(j);
                attributes = childElement.getAttributes();

                List<RoomFacility> roomFacilities = new ArrayList<>();
                NodeList roomsFacilitiesList = childElement.getElementsByTagName("RoomFacility");
                for (int k = 0; k < roomsFacilitiesList.getLength(); ++k) {
                    childElement = (Element) roomsFacilitiesList.item(k);
                    NamedNodeMap childAttributes = childElement.getAttributes();
                    RoomFacility facility = RoomFacility.valueOf(childAttributes.getNamedItem("type").getNodeValue().toUpperCase());
                    if (childElement.hasAttribute("cost")) {
                        facility.setCost(Integer.parseInt(childAttributes.getNamedItem("cost").getNodeValue()));
                    }
                    roomFacilities.add(facility);
                }
                int beds = Integer.parseInt(attributes.getNamedItem("beds").getNodeValue());
                Room newRoom = new Room(beds, roomFacilities);
                rooms.add(new Room(Integer.parseInt(attributes.getNamedItem("beds").getNodeValue()), roomFacilities));
            }

            childElement = (Element) node.getElementsByTagName("Hotel").item(0);
            attributes = childElement.getAttributes();
            hotel.setNutrition(NutritionType.valueOf(attributes.getNamedItem("eats").getNodeValue().toUpperCase()));
            hotel.setStars(Integer.parseInt(attributes.getNamedItem("stars").getNodeValue()));
            hotel.setRooms(rooms);
            hotel.setName(childElement.getElementsByTagName("Name").item(0).getTextContent());
            voucher.setHotel(hotel);

            Cost cost = new Cost();
            List<Facility> facilities = new ArrayList<>();
            NodeList facilitiesList = node.getElementsByTagName("Facility");
            for (int k = 0; k < facilitiesList.getLength(); ++k) {
                childElement = (Element) facilitiesList.item(k);
                NamedNodeMap childAttributes = childElement.getAttributes();
                Facility facility = Facility.valueOf(childAttributes.getNamedItem("type").getNodeValue().toUpperCase());
                if (childElement.hasAttribute("cost")) {
                    facility.setCost(Integer.parseInt(childAttributes.getNamedItem("cost").getNodeValue()));
                }
                facilities.add(facility);
            }
            cost.setFacilities(facilities);
            childElement = (Element) node.getElementsByTagName("Cost").item(0);
            attributes = childElement.getAttributes();
            cost.setCost(Integer.parseInt(attributes.getNamedItem("price").getNodeValue()));
            voucher.setCost(cost);

            vouchers.add(voucher);
        }
        return vouchers;
    }
}
