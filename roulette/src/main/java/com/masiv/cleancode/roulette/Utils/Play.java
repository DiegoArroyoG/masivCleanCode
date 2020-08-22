package com.masiv.cleancode.roulette.Utils;

import java.util.Random;
import java.util.List;
import java.util.Arrays;

public final class Play {
    private static final Integer MAX_VALID_NUMBER = 36;
    private static final List<String> VALID_COLORS = Arrays.asList("Rojo", "Negro");

    private Play(){
    }
    public static Integer randomNumber(){ 
        return new Random().nextInt(MAX_VALID_NUMBER);
    }
    public static String randomColor(){ 
        return VALID_COLORS.get(new Random().nextInt(VALID_COLORS.size()));
    }
}