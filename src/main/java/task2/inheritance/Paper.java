package task2.inheritance;

public class Paper extends Item{
    private final PaperFormat format;

    public Paper(String company, String name, double cost, PaperFormat format) {
        super(company, name, cost);
        this.format = format;
    }

    public PaperFormat getFormat() {
        return format;
    }
}
