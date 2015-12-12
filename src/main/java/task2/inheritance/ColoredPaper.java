package task2.inheritance;

public class ColoredPaper extends Paper{
    private final int color;

    public ColoredPaper(String company, String name, double cost, PaperFormat format, int color) {
        super(company, name, cost, format);
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
