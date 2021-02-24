package se.lexicon.util;

import java.time.LocalDateTime;

public class TestGeneratorString {

    public static String testRandomString(){
        return "ABCD" + LocalDateTime.now() + "TEST";
    }
}
