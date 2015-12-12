package task2.inheritance;

import java.io.EOFException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static task2.inheritance.PencilHardness.*;
import static task2.inheritance.PaperFormat.*;

/**
 * Created by Elizaveta Kapitonova on 09.12.15.
 */
public class StarterPackSetter {
    public static final int PENS_STARTER_PACK_AMOUNT = 3;
    public static final int PENCILS_STARTER_PACK_AMOUNT = 3;
    public static final int PAPER_STARTER_PACK_AMOUNT = 100;

    public static ArrayList<Item> setStarterPack() {
        ArrayList<Item> starterPack = new ArrayList<>();
        for (int i=0; i<PENS_STARTER_PACK_AMOUNT; i++) {
            Pen pen = new Pen("Pilot", "Black Brand New Pen", 1, 9005, 0.7);
            starterPack.add(pen);
        }
        for (int i=0; i<PENCILS_STARTER_PACK_AMOUNT; i++) {
            Pencil pencil = new Pencil("Bic", "Black Brand New Pencil", 0.5, 9005, HB);
            starterPack.add(pencil);
        }
        for (int i=0; i<PAPER_STARTER_PACK_AMOUNT; i++) {
            Paper paper= new Paper("SvetoCopy", "White paper", 0.01, A4);
            starterPack.add(paper);
        }
        return starterPack;
    }
}