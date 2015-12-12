package task2.inheritance;

public class Pen extends WritingItem {
    private final double width;
    public Pen(String company, String name, double cost, int color, double width) {
        super(company, name, cost, color);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
