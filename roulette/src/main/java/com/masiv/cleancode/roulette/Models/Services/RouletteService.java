package com.masiv.cleancode.roulette.Models.Services;

import java.util.List;

import com.masiv.cleancode.roulette.Models.Entity.Roulette;

public interface RouletteService{
    public List<Roulette> findAll();
    public void save(Roulette roulette);
    public Roulette findById(Long id);
    public Roulette findOpenRoulette();	
    public void delete(Long id);
}