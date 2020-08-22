package com.masiv.cleancode.roulette.Models.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.masiv.cleancode.roulette.Utils.Play;
import com.masiv.cleancode.roulette.Utils.Result;

@Entity
@Table(name="bet")
public class Bet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "bet_number")
    private Integer betNumber;
    @Column(name = "result_number")
    private Integer resultNumber;
    @Column(name = "bet_color")
    private String betColor;
    @Column(name = "result_color")
    private String resultColor;
    private Double bet;
    private Result result;

    public Bet() {
    }
    public Bet(Integer betNumber, String betColor, Double bet) {
        this.betNumber = betNumber;
        this.betColor = betColor;
        this.bet = bet;
    }
    public Bet(Long userId, Integer betNumber, String betColor, Double bet) {
        this.userId = userId;
        this.betNumber = betNumber;
        this.betColor = betColor;
        this.bet = bet;
        this.resultNumber = Play.randomNumber();
        this.resultColor = Play.randomColor();
        if(this.resultNumber == this.betNumber && betColor.equalsIgnoreCase(resultColor)){
            this.result = Result.WIN;
        }else{
            this.result = Result.LOSE;
        }
    }
	public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Integer getResultNumber() {
        return this.resultNumber;
    }
    public void setResultNumber(Integer resultNumber) {
        this.resultNumber = resultNumber;
    }
    public String getBetColor() {
        return this.betColor;
    }
    public void setBetColor(String betColor) {
        this.betColor = betColor;
    }
    public String getResultColor() {
        return this.resultColor;
    }
    public void setResultColor(String resultColor) {
        this.resultColor = resultColor;
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
    public void calculateResult() {
        if(this.resultNumber == this.betNumber && betColor.equalsIgnoreCase(resultColor)){
            this.result = Result.WIN;
        }else{
            this.result = Result.LOSE;
        }
    }
    private static final long serialVersionUID = 3750480266729122349L;
}