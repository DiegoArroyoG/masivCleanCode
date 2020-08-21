package com.masiv.cleancode.roulette.Models.Entity;

import java.io.Serializable;

import com.masiv.cleancode.roulette.utils.Play;
import com.masiv.cleancode.roulette.utils.Result;

public class Bet implements Serializable{
    private Long userId;
    private Integer betNumber;
    private String betColor;
    private Double bet;
    private Result result;

    public Bet(Long userId, Integer betNumber, String betColor, Double bet) {
        this.userId = userId;
        this.betNumber = betNumber;
        this.betColor = betColor;
        this.bet = bet;
        this.result = Play.randomNumber() == this.betNumber? Result.WIN : Result.LOSE;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Integer getBetNumber() {
        return this.betNumber;
    }
    public void setBetNumber(Integer betNumber) {
        this.betNumber = betNumber;
    }
    public String getBetColor() {
        return this.betColor;
    }
    public void setBetColor(String betColor) {
        this.betColor = betColor;
    }
    public Double getBet() {
        return this.bet;
    }
    public void setBet(Double bet) {
        this.bet = bet;
    }
    public Result getResult() {
        return this.result;
    }
    public void setResult(Result result) {
        this.result = result;
    }
    private static final long serialVersionUID = 3750480266729122349L;
}