package by.training.service.parser;

import by.training.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class StAXParser implements Parser<Voucher> {
    private static final Logger LOGGER = LogManager.getLogger();

    private List<Voucher> vouchers = new ArrayList<>();
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
    public List<Voucher> parse(File file) throws ParserException {
        LOGGER.info("start parse in StAXParser");
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.START_DOCUMENT) {
                    vouchers = new ArrayList<>();
                } else if (event == XMLEvent.START_ELEMENT) {
                    String localName = reader.getLocalName();
                    if ("Voucher".equals(localName)) {
                        voucher.setType(VoucherType.valueOf(reader.getAttributeValue("", "type").toUpperCase()));
                    } else if ("Location".equals(localName)) {
                        location.setCountry(reader.getAttributeValue("","countryCode").toUpperCase());
                        location.setCity(reader.getAttributeValue("", "city"));
                    } else if ("Duration".equals(localName)) {
                        duration.setDays(Integer.parseInt(reader.getAttributeValue("", "days")));
                        duration.setNights(Integer.parseInt(reader.getAttributeValue("", "nights")));
                    } else if ("Transport".equals(localName)) {
                        transport.setType(TransportType.valueOf(reader.getAttributeValue("","type").toUpperCase()));
                    } else if ("Hotel".equals(localName)) {
                        hotel.setStars(Integer.parseInt(reader.getAttributeValue("","stars")));
                        hotel.setNutrition(NutritionType.valueOf(reader.getAttributeValue("","eats").toUpperCase()));
                    } else if ("Room".equals(localName)) {
                        room.setBeds(Integer.parseInt(reader.getAttributeValue("","beds")));
                    } else if ("RoomFacility".equals(localName)) {
                        roomFacility = RoomFacility.valueOf(reader.getAttributeValue("", "type").toUpperCase());
                        if (reader.getAttributeCount() == 2) {
                            roomFacility.setCost(Integer.parseInt(reader.getAttributeValue("", "cost")));
                        }
                    } else if ("Cost".equals(localName)) {
                        cost.setCost(Integer.parseInt(reader.getAttributeValue("", "price")));
                    } else if ("Facility".equals(localName)) {
                        facility = Facility.valueOf(reader.getAttributeValue("", "type").toUpperCase());
                        if (reader.getAttributeCount() == 2) {
                            facility.setCost(Integer.parseInt(reader.getAttributeValue("", "cost")));
                        }
                    } else if ("Name".equals(localName)) {
                        name = reader.getElementText();
                    }
                } else if (event == XMLEvent.END_ELEMENT) {
                    String localName = reader.getLocalName();
                    if (localName.equals("Voucher")) {
                        vouchers.add(voucher);
                        voucher = new Voucher();
                    } else if (localName.equals("Location")) {
                        voucher.setLocation(location);
                        location = new Location();
                    } else if (localName.equals("Duration")) {
                        voucher.setDuration(duration);
                        duration = new Duration();
                    } else if (localName.equals("Transport")) {
                        transports.add(transport);
                        transport = new Transport();
                    } else if (localName.equals("Transports")) {
                        voucher.setTransports(transports);
                        transports = new ArrayList<>();
                    } else if (localName.equals("Hotel")) {
                        hotel.setName(name);
                        name = "";
                        voucher.setHotel(hotel);
                        hotel = new Hotel();
                    } else if (localName.equals("Name")) {
                        hotel.setName(name);
                        name = "";
                    } else if (localName.equals("Room")) {
                        rooms.add(room);
                        room = new Room();
                    } else if (localName.equals("Rooms")) {
                        hotel.setRooms(rooms);
                        rooms = new ArrayList<>();
                    } else if (localName.equals("RoomFacility")) {
                        roomFacilities.add(roomFacility);
                        roomFacility = null;
                    } else if (localName.equals("RoomFacilities")) {
                        room.setFacilities(roomFacilities);
                        roomFacilities = new ArrayList<>();
                    } else if (localName.equals("Cost")) {
                        voucher.setCost(cost);
                        cost = new Cost();
                    } else if (localName.equals("Facility")) {
                        facilities.add(facility);
                        facility = null;
                    } else if (localName.equals("Facilities")) {
                        cost.setFacilities(facilities);
                        facilities = new ArrayList<>();
                    }
                }
            }

            reader.close();
        } catch (XMLStreamException | FileNotFoundException e) {
            String message = "Illegal xml parser";
            LOGGER.error(message + " in parse(File xml)");
            throw new ParserException(message);
        }
        return vouchers;
    }
}
