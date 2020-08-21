package com.masiv.cleancode.roulette.utils;

public final class Play {
    private Play(){
    }
    public static int randomNumber(){  
        return (int)Math.random() * 36;
    }
}