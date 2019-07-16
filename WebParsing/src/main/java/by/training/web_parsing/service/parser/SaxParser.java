package by.training.web_parsing.service.parser;

import by.training.web_parsing.entity.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SaxParser implements Parser<Voucher> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Voucher> parse(File file) throws ParserException {
        LOGGER.info("start parse in SAXParser");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXHandler handler = new SAXHandler();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            parser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            String message = "Can not get SAXParser";
            LOGGER.error(message + " in parse(File xml)");
            throw new ParserException(message);
        }
        return handler.getData();
    }

    private class SAXHandler extends DefaultHandler {
        private List<Voucher> vouchers;
        private String element;
        private Voucher voucher = new Voucher();
        private Location location = new Location();
        private Duration duration = new Duration();
        private List<Transport> transports = new ArrayList<>();
        private Transport transport = new Transport();
        private Hotel hotel = new Hotel();
        private String name = "";
        private List<Room> rooms = new ArrayList<>();
        private Room room = new Room();
        private List<RoomFacility> roomFacilities = new ArrayList<>();
        private RoomFacility roomFacility = null;
        private Cost cost = new Cost();
        private List<Facility> facilities = new ArrayList<>();
        private Facility facility = null;

        @Override
        public void startDocument() throws SAXException {
            vouchers = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            element = qName;
            if (element.equals("Voucher")) {
                voucher.setType(VoucherType.valueOf(attributes.getValue("type").toUpperCase()));
            } else if (element.equals("Location")) {
                location.setCountry(attributes.getValue("countryCode").toUpperCase());
                location.setCity(attributes.getValue("city"));
            } else if (element.equals("Duration")) {
                duration.setDays(Integer.parseInt(attributes.getValue("days")));
                duration.setNights(Integer.parseInt(attributes.getValue("nights")));
            } else if (element.equals("Transport")) {
                transport.setType(TransportType.valueOf(attributes.getValue("type").toUpperCase()));
            } else if (element.equals("Hotel")) {
                hotel.setStars(Integer.parseInt(attributes.getValue("stars")));
                hotel.setNutrition(NutritionType.valueOf(attributes.getValue("eats").toUpperCase()));
            } else if (element.equals("Room")) {
                room.setBeds(Integer.parseInt(attributes.getValue("beds")));
            } else if (element.equals("RoomFacility")) {
                roomFacility = RoomFacility.valueOf(attributes.getValue("type").toUpperCase());
                if (attributes.getLength() == 2) {
                    roomFacility.setCost(Integer.parseInt(attributes.getValue("cost")));
                }
            } else if (element.equals("Cost")) {
                cost.setCost(Integer.parseInt(attributes.getValue("price")));
            } else if (element.equals("Facility")) {
                facility = Facility.valueOf(attributes.getValue("type").toUpperCase());
                if (attributes.getLength() == 2) {
                    facility.setCost(Integer.parseInt(attributes.getValue("cost")));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            element = "";
            if (qName.equals("Voucher")) {
                vouchers.add(voucher);
                voucher = new Voucher();
            } else if (qName.equals("Location")) {
                voucher.setLocation(location);
                location = new Location();
            } else if (qName.equals("Duration")) {
                voucher.setDuration(duration);
                duration = new Duration();
            } else if (qName.equals("Transport")) {
                transports.add(transport);
                transport = new Transport();
            } else if (qName.equals("Transports")) {
                voucher.setTransports(transports);
                transports = new ArrayList<>();
            } else if (qName.equals("Hotel")) {
                voucher.setHotel(hotel);
                hotel = new Hotel();
            } else if (qName.equals("Name")) {
                hotel.setName(name);
                name = "";
            } else if (qName.equals("Room")) {
                rooms.add(room);
                room = new Room();
            } else if (qName.equals("Rooms")) {
                hotel.setRooms(rooms);
                rooms = new ArrayList<>();
            } else if (qName.equals("RoomFacility")) {
                roomFacilities.add(roomFacility);
                roomFacility = null;
            } else if (qName.equals("RoomFacilities")) {
                room.setFacilities(roomFacilities);
                roomFacilities = new ArrayList<>();
            } else if (qName.equals("Cost")) {
                voucher.setCost(cost);
                cost = new Cost();
            } else if (qName.equals("Facility")) {
                facilities.add(facility);
                facility = null;
            } else if (qName.equals("Facilities")) {
                cost.setFacilities(facilities);
                facilities = new ArrayList<>();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (element.equals("Name")) {
                name = new String(ch, start, length);
            }
        }

        public List<Voucher> getData() {
            return vouchers;
        }
    }
}
