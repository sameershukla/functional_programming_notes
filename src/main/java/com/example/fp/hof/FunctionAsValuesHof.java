package com.example.fp.hof;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * In this example, we created 2 HOF's multiply and add
 * then we chained them together to form a pipeline
 * during array iteration applied chained function on every integer.
 */
public class FunctionAsValuesHof {

    private static Function<Integer, Integer> multiply = n -> n * 2;

    private static Function<Integer, Integer> add = n -> n + 2;

    private static Function<Integer, Predicate<Integer>> isGreaterThan = threshold -> x -> x >= 10;

    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5};
        Function<Integer, Predicate<Integer>> pipeline = isGreaterThan
                                                            .compose(add)
                                                            .compose(multiply);
        for(int i=0; i < numbers.length; i++){
            int n = numbers[i];
            if(!pipeline.apply(n).test(n)){
                System.out.println(n);
            }
        }
    }
}
