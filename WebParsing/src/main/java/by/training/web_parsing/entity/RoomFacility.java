package by.training.web_parsing.entity;

public enum RoomFacility {
    WI_FI(10), AIR_CONDITIONING(40), TV(10), HAIR_DRYER(5), SHAMPOO(5), TOWEL(10);

    private int cost;

    RoomFacility(int cost) { // конструктор класса перечисления
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%s : cost = %d", name(), cost);
    }

}
