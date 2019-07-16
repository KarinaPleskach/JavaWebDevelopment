package by.training.web_parsing.service.parser;

import by.training.web_parsing.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StAXParserTest {

    private static Parser parser;

    @Before
    public void before() throws ParserException {
        parser = ParserFabric.getINSTANSE().getParser("stax");
    }

    @Test
    public void parseNormTest() throws ParserException, URISyntaxException {
        List<Voucher> expected = new ArrayList<>();

        List<Transport> transports = new ArrayList<>();
        transports.add(new Transport(TransportType.TRAIN));
        transports.add(new Transport(TransportType.TAXI));

        List<Room> rooms = new ArrayList<>();
        List<RoomFacility> roomFacilities = new ArrayList<>();
        roomFacilities.add(RoomFacility.SHAMPOO);
        rooms.add(new Room(1, roomFacilities));

        Hotel hotel = new Hotel();
        hotel.setStars(5);
        hotel.setNutrition(NutritionType.HB);
        hotel.setName("Last journey");
        hotel.setRooms(rooms);

        List<Facility> facilities = new ArrayList<>();
        facilities.add(Facility.INSURANCE);
        Cost cost = new Cost();
        cost.setCost(300);
        cost.setFacilities(facilities);

        Voucher voucher = new Voucher();
        voucher.setCost(cost);
        voucher.setDuration(new Duration(5, 4));
        voucher.setHotel(hotel);
        voucher.setLocation(new Location("VA", "Vatican"));
        voucher.setTransports(transports);
        voucher.setType(VoucherType.PILGRIMAGE);

        expected.add(voucher);

        URL res = getClass().getClassLoader().getResource("norm.xml");
        File xml = null;
        xml = Paths.get(res.toURI()).toFile();

        List<Voucher> actual = parser.parse(xml);
        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }

    @Test
    public void parseIllegalTest() throws ParserException, URISyntaxException {
        List<Voucher> expected = new ArrayList<>();

        Voucher voucher = new Voucher();
        voucher.setDuration(new Duration(5, 4));
        voucher.setType(VoucherType.PILGRIMAGE);

        expected.add(voucher);

        URL res = getClass().getClassLoader().getResource("illegal.xml");
        File xml = null;
        xml = Paths.get(res.toURI()).toFile();
        List<Voucher> actual = parser.parse(xml);
        assertArrayEquals(expected.toString().toCharArray(), actual.toString().toCharArray());
    }

}