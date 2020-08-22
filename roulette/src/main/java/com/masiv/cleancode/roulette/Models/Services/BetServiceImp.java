package com.masiv.cleancode.roulette.Models.Services;

import com.masiv.cleancode.roulette.Models.Dao.BetDao;
import com.masiv.cleancode.roulette.Models.Entity.Bet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImp implements BetService {
    @Autowired
    private BetDao betDao;

    @Override
    public void save(Bet bet) {
        betDao.save(bet);
    }    
}