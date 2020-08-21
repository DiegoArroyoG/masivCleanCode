package com.masiv.cleancode.roulette.utils;

import java.util.Arrays;
import java.util.List;

import com.masiv.cleancode.roulette.Models.Entity.Bet;

public final class ValidateBet {
    private static final int MAX_VALID_NUMBER = 36;
    private static final int MIN_VALID_NUMBER = 0;
    private static final Double MAX_BET = 10000.0;
    private static final List<String> VALID_COLORS = Arrays.asList("Rojo", "Negro");

    private ValidateBet(){
    }
    public static boolean isBetValid(Bet bet){
        
        return true;
    }
}