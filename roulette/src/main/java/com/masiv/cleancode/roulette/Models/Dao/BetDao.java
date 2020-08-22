package com.masiv.cleancode.roulette.Models.Dao;

import com.masiv.cleancode.roulette.Models.Entity.Bet;

import org.springframework.data.repository.CrudRepository;

public interface BetDao extends CrudRepository<Bet, Long>{   
}