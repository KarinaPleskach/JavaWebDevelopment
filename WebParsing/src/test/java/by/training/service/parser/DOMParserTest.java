package by.training.service.parser;

import by.training.entity.*;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DOMParserTest {

    @Test
    public void parseNormTest() throws ParserException, URISyntaxException {
        List<Voucher> actual = new ArrayList<>();
        List<Transport> transports = new ArrayList<>();
        Hotel hotel = new Hotel();
        hotel.setStars(5);
        hotel.setNutrition(NutritionType.HB);
        hotel.setName("Last journey");
        List<Room> rooms = new ArrayList<>();
        List<RoomFacility> roomFacilities = new ArrayList<>();

        //roomFacilities.add(RoomFacility.SHAMPOO.setCost(5));
        transports.add(new Transport(TransportType.TRAIN));
        transports.add(new Transport(TransportType.TAXI));
//        actual.add(new Voucher(VoucherType.PILGRIMAGE,
//                new Location("Ватикан", "Vatican"),
//                new Duration(5, 4),
//                transports,
//                ));

        URL res = getClass().getClassLoader().getResource("norm.xml");
        File xml = null;
        xml = Paths.get(res.toURI()).toFile();
        System.out.println(ParserFabric.getINSTANSE().getParser("dom").parse(xml));
    }

    @Test(expected = NullPointerException.class)
    public void parseIllegalTest() throws ParserException, URISyntaxException {

        URL res = getClass().getClassLoader().getResource("illegal.xml");
        File xml = null;
        xml = Paths.get(res.toURI()).toFile();
        System.out.println(ParserFabric.getINSTANSE().getParser("dom").parse(xml));
    }
}