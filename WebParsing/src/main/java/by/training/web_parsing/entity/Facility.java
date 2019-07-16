package by.training.web_parsing.entity;

public enum Facility {
    EXCURSION(100), GUIDE(140), TRANSLATOR(200), INSURANCE(190);

    private int cost;

    Facility(int cost) { // конструктор класса перечисления
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
