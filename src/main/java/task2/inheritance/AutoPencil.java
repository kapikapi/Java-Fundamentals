package task2.inheritance;

public class AutoPencil extends Pencil {
    private final double width;
    public AutoPencil(String company, String name, double cost, int color, PencilHardness hardness, double width) {
        super(company, name, cost, color, hardness);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
