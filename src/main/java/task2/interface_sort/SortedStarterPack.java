package task2.interface_sort;

import task2.inheritance.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by kapikapi on 10.12.15.
 */
public class SortedStarterPack implements SortedStarterPackInterface{

    Comparator<Item> comparatorByName = new Comparator<Item>() {
        @Override
        public int compare(Item item, Item t1) {
            return item.getName().compareTo(t1.getName());
        }
    };

    Comparator<Item> comparatorByCost = new Comparator<Item>() {
        @Override
        public int compare(Item item, Item t1) {
            if (item.getCost() - t1.getCost()>0) {
                return 1;
            }
            if (item.getCost() - t1.getCost()<0) {
                return -1;
            }
            return 0;
        }
    };

    Comparator<Item> comparatorByCostAndName = new Comparator<Item>() {
        @Override
        public int compare(Item item, Item t1) {
            if (item.getCost() - t1.getCost() > 0) {
                return 1;
            }
            if (item.getCost() - t1.getCost() < 0) {
                return -1;
            }
            else {
                return item.getName().compareTo(t1.getName());
            }

        }
    };


    @Override
    public ArrayList<Item> getSPSortedByName(ArrayList<Item> stPack) {
        Collections.sort(stPack, comparatorByName);
        return stPack;
    }

    @Override
    public ArrayList<Item> getSPSortedByCost(ArrayList<Item> stPack) {
        Collections.sort(stPack, comparatorByCost);
        return stPack;
    }

    @Override
    public ArrayList<Item> getSPSortedByCostAndName(ArrayList<Item> stPack) {
        Collections.sort(stPack, comparatorByCostAndName);
        return stPack;
    }
}
