package com.example.fp.functional.chaining;

import com.example.fp.functional.tuple.Tuple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTriFunctionChaining {

    @Test
    public void testLetterChain(){
        Tuple<String, String> tuple =  TriFunctionPipeline.letterChain("Java", "Programming", "Language");
        String result = tuple._1() + tuple._2();
        assertEquals("JAVA PROGRAMMING LANGUAGE", result);
    }

    @Test
    public void testLetterNull(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            TriFunctionPipeline.letterChain(null, "PROGRAMMING", "Language");
        });
        assertTrue(exception.getMessage().contains("Input cannot be null"));
    }

}