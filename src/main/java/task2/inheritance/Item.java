package task2.inheritance;

public class Item {
    private final String company;
    private final String name;
    private final double cost;

    Item(String company, String name, double cost) {
        this.company = company;
        this.name = name;
        this.cost = cost;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
