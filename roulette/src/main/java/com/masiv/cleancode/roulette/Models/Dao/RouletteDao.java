package com.masiv.cleancode.roulette.Models.Dao;

import com.masiv.cleancode.roulette.Models.Entity.Roulette;

import org.springframework.data.repository.CrudRepository;

public interface RouletteDao extends CrudRepository<Roulette, Long>{
}