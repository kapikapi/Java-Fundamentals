package task2.work_place;

import java.util.ArrayList;

/**
 * Created by Elizaveta Kapitonova on 30.11.15.
 */
public class WorkingPlace {
    public String ownerName;
    private ArrayList<Pencil> pencils = new ArrayList<>();
    private ArrayList<Pen> pens = new ArrayList<>();
    private ArrayList<Paper> papers = new ArrayList<>();

    public WorkingPlace(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setPencils(String company, double width, double cost){
        pencils.add(new Pencil(company, width, cost));
    }

    public void setPens(String company, double width, int color, double cost){
        pens.add(new Pen(company, width, color, cost));
    }

    public void setPapers(String company, PaperFormat format, int color, double cost){
        papers.add(new Paper(company, format, color, cost));
    }

    public double getWorkingplaceCost() {
        double resultCost = 0;
        for (Pencil p : pencils) {
            resultCost += p.getCost();
        }
        for (Pen p : pens) {
            resultCost += p.getCost();
        }
        for (Paper p : papers) {
            resultCost += p.getCost();
        }
        return resultCost;
    }

}

class Pencil {
    private final String company;
    private final double width;
    private double cost;

    public Pencil(String company, double width, double cost) {
        this.company = company;
        this.width = width;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }


}

class Pen extends Pencil {
    private final int color;

    public Pen(String company, double width, int color, double cost) {
        super(company, width, cost);
        this.color = color;
    }
}
class Paper {
    private PaperFormat format;
    private final int color;
    private double cost;
    private String company;

    public Paper(String company, PaperFormat format, int color, double cost) {
        this.company = company;
        this.format = format;
        this.color = color;
        this.cost = cost;
    }
    public double getCost(){
        return cost;
    }
}


