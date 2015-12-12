package task2.interface_sort;

import task2.inheritance.Item;

import java.util.ArrayList;

/**
 * Created by kapikapi on 10.12.15.
 */
public interface SortedStarterPackInterface {
    ArrayList<Item> getSPSortedByName(ArrayList<Item> stP);
    ArrayList<Item> getSPSortedByCost(ArrayList<Item> stP);
    ArrayList<Item> getSPSortedByCostAndName(ArrayList<Item> stP);
}
