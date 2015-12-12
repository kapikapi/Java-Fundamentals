package task2.inheritance;

public class Pencil extends WritingItem {
    private final PencilHardness hardness;
    public Pencil(String company, String name, double cost, int color, PencilHardness hardness) {
        super(company, name, cost, color);
        this.hardness = hardness;
    }

    public PencilHardness getHardness() {
        return hardness;
    }
}
