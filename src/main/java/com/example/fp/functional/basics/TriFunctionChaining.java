package com.example.fp.functional.basics;

import com.example.fp.functional.tuple.Tuple;

public class TriFunctionChaining {

    /**
     * Method accepts 3 parameters, concatenate and return a Tuple
     * @param first
     * @param middle
     * @param last
     * @return
     */
    private static Tuple<String, String> concatenate(String first, String middle, String last){
        return new Tuple<>(first, " "+ middle + " " + last);
    }


    /**
     * Capitalization
     * @param first
     * @param middle
     * @param last
     * @return
     */
    private static Tuple<String, String> capitalize(String first, String middle, String last){
        String lastName = middle.toUpperCase() + " " + last.toUpperCase();
        return new Tuple<>(first.toUpperCase(), " "+ lastName);
    }


    /**
     * Letter Chaining
     * @param
     */
    public static Tuple<String, String> letterChain(String input1, String input2, String input3) {
        if(input1 == null || input2 == null || input3 == null)
            throw new IllegalArgumentException("Input cannot be null");

        TriFunction<String, String, String, Tuple<String, String>> pipeline = TriFunctionChaining :: concatenate;
        return pipeline
                .andThen(TriFunctionChaining :: capitalize)
                .apply(input1, input2, input3);
    }


}
