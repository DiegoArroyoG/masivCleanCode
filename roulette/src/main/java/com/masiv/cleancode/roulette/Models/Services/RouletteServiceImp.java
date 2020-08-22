package com.masiv.cleancode.roulette.Models.Services;

import java.util.List;

import com.masiv.cleancode.roulette.Models.Dao.RouletteDao;
import com.masiv.cleancode.roulette.Models.Entity.Roulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouletteServiceImp implements RouletteService {
    @Autowired
    private RouletteDao rouletteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Roulette> findAll() {
        return (List<Roulette>) rouletteDao.findAll();
    }
    @Override
    @Transactional
    public void save(Roulette roulette) {
        rouletteDao.save(roulette);
    }
    @Override
    @Transactional(readOnly = true)
    public Roulette findById(Long id) {
        return rouletteDao.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public Roulette findOpenRoulette() {
        Roulette roulette = null;
        for(Roulette r : rouletteDao.findAll()){
            if(r.getState()){
                roulette = r;
            }
        }
        
        return roulette;
    }
    @Override
    @Transactional
    public void delete(Long id) {
        rouletteDao.deleteById(id);
    }
}