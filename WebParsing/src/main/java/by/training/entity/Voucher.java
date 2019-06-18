package by.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Voucher {
    private VoucherType type;
    private Location location;
    private Duration duration;
    private List<Transport> transports = new ArrayList<>();
    private Hotel hotel;
    private Cost cost;

    public VoucherType getType() {
        return type;
    }

    public void setType(VoucherType type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return type == voucher.type &&
                Objects.equals(location, voucher.location) &&
                Objects.equals(duration, voucher.duration) &&
                Objects.equals(transports, voucher.transports) &&
                Objects.equals(hotel, voucher.hotel) &&
                Objects.equals(cost, voucher.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, location, duration, transports, hotel, cost);
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "type=" + type +
                ", location=" + location +
                ", duration=" + duration +
                ", transports=" + transports.toString() +
                ", hotel=" + hotel +
                ", cost=" + cost +
                "}\n";
    }
}
