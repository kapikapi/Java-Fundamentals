package task2.inheritance;

public class WritingItem extends Item {
    // number of the color in RAL-scale
    private final int color;
    WritingItem(String company, String name, double cost, int color) {
        super(company, name, cost);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
