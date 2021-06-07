package hw_03_2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class IntegerListCreator {
    private int minValue = 1;
    private int maxValue = 1000;
    private int listLength = 100;
    private List<Integer> numbersList;

    public IntegerListCreator() {
        this.numbersList = createRandomNumberList();
    }

    private List<Integer> createRandomNumberList() {
        return new Random().ints(this.listLength, this.minValue, this.maxValue)
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }
}
