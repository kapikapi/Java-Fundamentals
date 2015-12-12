package task2.inheritance;

public class Ruler extends Item{
    private final int length;
    private final String material;

    Ruler(String company, String name, double cost, String material, int length) {
        super(company, name, cost);
        this.length = length;
        this.material = material;
    }

    public int getLength() {
        return length;
    }

    public String getMaterial() {
        return material;
    }
}
