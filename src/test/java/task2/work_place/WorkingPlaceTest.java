package task2.work_place;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Elizaveta Kapitonova on 30.11.15.
 */
public class WorkingPlaceTest {
    private WorkingPlace wp;
    private final int PENCIL_AMOUNT = 10;
    private final int PEN_AMOUNT = 5;
    private final int PAPER_AMOUNT = 100;

    @Before
    public void setWp() {
        wp = new WorkingPlace("Lisa");
        for (int i = 0; i<PENCIL_AMOUNT; i++) {
            wp.setPencils("BIC", 0.2, 0.5);
        }
        for (int i = 0; i<PEN_AMOUNT; i++) {
            wp.setPens("Pilot", 0.5, 100000, 1);
        }
        wp.setPens("Parker", 0.7, 1000000, 12);
        for (int i = 0; i<PAPER_AMOUNT; i++) {
            wp.setPapers("SvetoCopy", PaperFormat.A4, 10000, 0.01);
        }
    }

    @Test
    public void testGetWorkingplaceCost() throws Exception {
        assertEquals(23, wp.getWorkingplaceCost(), 1e-9);
    }
}