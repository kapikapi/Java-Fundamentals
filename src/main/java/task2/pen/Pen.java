package task2.pen;

/**
 * Created by Elizaveta Kapitonova on 30.11.15.
 */
public class Pen {
    public final String company;
    public final double width;
    public final int color;

    public Pen(String company, double width, int color) {
        this.company = company;
        this.width = width;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (Double.compare(pen.width, width) != 0) return false;
        if (color != pen.color) return false;
        return company == null ? pen.company == null : company.equals(pen.company);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        if (company != null){
            result = company.hashCode();
        }
        else {
            result = 0;
        }
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color;
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "company='" + company + '\'' +
                ", width=" + width +
                ", color=" + color +
                '}';
    }
}
