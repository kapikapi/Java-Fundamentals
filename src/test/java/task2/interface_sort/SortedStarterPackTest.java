package task2.interface_sort;

import org.junit.Before;
import org.junit.Test;
import task2.inheritance.*;

import static task2.inheritance.PaperFormat.A4;
import static task2.inheritance.PencilHardness.H;
import static task2.inheritance.PencilHardness.HB;
import static task2.inheritance.StarterPackSetter.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by Elizaveta Kapitonova on 10.12.15.
 */
public class SortedStarterPackTest {

    private ArrayList<Item> starterPack;
    SortedStarterPack sp;

    @Before
    public void setData() {
        starterPack = StarterPackSetter.setStarterPack();
        sp = new SortedStarterPack();
    }

    @Test
    public void testGetSPSortedByName() throws Exception {
        assertEquals(starterPack, sp.getSPSortedByName(starterPack));
    }

    @Test
    public void testGetSPSortedByCost() throws Exception {
        ArrayList<Item> stPack = new ArrayList<>();
        for (int i=0; i<PAPER_STARTER_PACK_AMOUNT; i++) {
            Paper paper= new Paper("SvetoCopy", "White paper", 0.01, A4);
            stPack.add(paper);
        }
        for (int i=0; i<PENCILS_STARTER_PACK_AMOUNT; i++) {
            Pencil pencil = new Pencil("Bic", "Black Brand New Pencil", 0.5, 9005, HB);
            stPack.add(pencil);
        }
        for (int i=0; i<PENS_STARTER_PACK_AMOUNT; i++) {
            Pen pen = new Pen("Pilot", "Black Brand New Pen", 1, 9005, 0.7);
            stPack.add(pen);
        }
        ArrayList<Item> l = sp.getSPSortedByCost(starterPack);
        for (int i=0; i< stPack.size(); i++) {
            assertEquals(stPack.get(i).getName(), l.get(i).getName());
            assertEquals(stPack.get(i).getCompany(), l.get(i).getCompany());
            assertEquals(stPack.get(i).getCost(), l.get(i).getCost(), 1e-9);
        }
    }

    private ArrayList<Item> setNewStarterPack() {
        ArrayList<Item> s = new ArrayList<>();
        s.add(new Pencil("Bic", "Super Pencil", 0.2, 9005, HB));
        s.add(new Pencil("Bic", "Mega Super Pencil", 0.1, 9005, HB));
        s.add(new Pencil("Pilot", "Super Ultra Pencil", 0.1, 9005, H));
        s.add(new Pen("Pilot", "Super Ultra Pen", 0.1, 9005, 0.5));
        s.add(new Pen("Pilot", "Super Ultra Pen", 0.2, 9005, 0.5));
        s.add(new Paper("SvetoCopy", "Simple White Paper", 0.01, A4));
        s.add(new Paper("SvetoCopy", "White Paper", 0.01, A4));
        return s;
    }

    private ArrayList<Item> setNewSortedStarterPack() {
        ArrayList<Item> s = new ArrayList<>();
        s.add(new Paper("SvetoCopy", "Simple White Paper", 0.01, A4));
        s.add(new Paper("SvetoCopy", "White Paper", 0.01, A4));
        s.add(new Pencil("Bic", "Mega Super Pencil", 0.1, 9005, HB));
        s.add(new Pen("Pilot", "Super Ultra Pen", 0.1, 9005, 0.5));
        s.add(new Pencil("Pilot", "Super Ultra Pencil", 0.1, 9005, H));
        s.add(new Pencil("Bic", "Super Pencil", 0.2, 9005, HB));
        s.add(new Pen("Pilot", "Super Ultra Pen", 0.2, 9005, 0.5));

        return s;
    }

    @Test
    public void testGetSPSortedByCostAndName() throws Exception {
        ArrayList<Item> l = sp.getSPSortedByCostAndName(setNewStarterPack());
        ArrayList<Item> ll = setNewSortedStarterPack();
        for (int i=0; i<l.size(); i++) {
            assertEquals(ll.get(i).getName(), l.get(i).getName());
            assertEquals(ll.get(i).getCompany(), l.get(i).getCompany());
            assertEquals(ll.get(i).getCost(), l.get(i).getCost(), 1e-9);
        }
    }
}