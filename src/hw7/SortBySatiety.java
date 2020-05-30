package hw7;

import java.util.Comparator;


public class SortBySatiety implements Comparator<hw7.Cat> {
    public int compare(hw7.Cat a, Cat b){

        return b.satiety - a.satiety;

    }
}

