package interviewprep;

import java.util.function.Function;



public class functionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> addTen   = x -> x + 10;

        Function<Integer, Integer> doubleThenAdd = doubleIt.andThen(addTen);
        Function<Integer, Integer> addThenDouble = addTen.andThen(doubleIt);

        System.out.println(doubleThenAdd.apply(5)); // ?
        System.out.println(addThenDouble.apply(5)); // ?
    }
}
