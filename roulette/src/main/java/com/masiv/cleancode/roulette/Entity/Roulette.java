package com.masiv.cleancode.roulette.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.masiv.cleancode.roulette.Models.Bet;

@Entity
@Table(name="clientes")
public class Roulette implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bet_result")
    private List<Bet> betResults;
    private boolean state;

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public List<Bet> getResults(){
        return this.betResults;
    }
    public void setResults(List<Bet> betResults){
        this.betResults = betResults;
    }
    public boolean getState(){
       return this.state;
    }
    public void setState(boolean state){
       this.state = state;
    }

    private static final long serialVersionUID = -1441599398844962813L;
}