package com.masiv.cleancode.roulette.Models.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roulette")
public class Roulette implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bet_id")
    private List<Bet> bets;
    private boolean state;

    public Roulette(){
        this.bets = new ArrayList<Bet>();
        this.state = false;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public List<Bet> getBets(){
        return this.bets;
    }
    public void setBets(List<Bet> betResults){
        this.bets = betResults;
    }
    public void addBet(Bet betResults){
        this.bets.add(betResults);
    }
    public boolean getState(){
       return this.state;
    }
    public void setState(boolean state){
       this.state = state;
    }
    private static final long serialVersionUID = -1441599398844962813L;
}