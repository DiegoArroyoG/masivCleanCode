package com.masiv.cleancode.roulette.Utils;

import java.util.Arrays;
import java.util.List;

import com.masiv.cleancode.roulette.Models.Entity.Bet;

public final class ValidateBet {
    private static final Integer MAX_VALID_NUMBER = 36;
    private static final Integer MIN_VALID_NUMBER = 0;
    private static final Double MAX_BET = 10000.0;
    private static final List<String> VALID_COLORS = Arrays.asList("Rojo", "Negro");

    public static boolean isBetValid(Bet bet){
        if(ValidateNumber(bet) && ValidateMaxBet(bet) && ValidateColor(bet)){
            return true;
        }
        return false;
    }
    private static boolean ValidateNumber(Bet bet) {
        if (bet.getBetNumber() > MIN_VALID_NUMBER && bet.getBetNumber() < MAX_VALID_NUMBER) {
            return true;
        }
        return false;
    }
    private static boolean ValidateMaxBet(Bet bet) {
        if (bet.getBet() > 0 && bet.getBet() < MAX_BET) {
            return true;
        }
        return false;
    }
    private static boolean ValidateColor(Bet bet) {
        if (bet.getBetColor().equalsIgnoreCase(VALID_COLORS.get(0))
                || bet.getBetColor().equalsIgnoreCase(VALID_COLORS.get(1))) {
            return true;
        }
        return false;
    }
}