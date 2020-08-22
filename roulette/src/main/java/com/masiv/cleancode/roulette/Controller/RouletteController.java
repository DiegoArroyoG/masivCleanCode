package com.masiv.cleancode.roulette.Controller;

import com.masiv.cleancode.roulette.Models.Entity.Bet;
import com.masiv.cleancode.roulette.Models.Entity.Roulette;
import com.masiv.cleancode.roulette.Models.Services.BetService;
import com.masiv.cleancode.roulette.Models.Services.RouletteService;
import com.masiv.cleancode.roulette.Utils.Play;
import com.masiv.cleancode.roulette.Utils.ValidateBet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RouletteController {
    @Autowired
    private RouletteService rouletteService;
    @Autowired
    private BetService betService;

    @PostMapping(value = "/crear")
    public Long newRoulette() {
        Roulette roulette = new Roulette();
        rouletteService.save(roulette);

        return roulette.getId();
    }
    @PutMapping(value = "/abrir/{id}")
    public boolean openRoulette(@PathVariable(value = "id") Long id) {
        Roulette roulette = null;
        roulette = rouletteService.findById(id);
        if (roulette != null) {
            roulette.setState(true);
            rouletteService.save(roulette);
        }

        return roulette != null ? true : false;
    }
    @PutMapping(value = "/cerrar/{id}")
    public List<Bet> closeRoulette(@PathVariable(value = "id") Long id) {
        Roulette roulette = null;
        roulette = rouletteService.findById(id);
        if (roulette != null) {
            roulette.setState(false);
            rouletteService.save(roulette);
        }

        return roulette != null? roulette.getBets() : null;
    }
    @GetMapping(value = "/apuesta")
    public String betRoulette(@RequestHeader("id") Long userId, @RequestParam Integer betNumber,
            @RequestParam String betColor, @RequestParam Double bet) {
        Roulette roulette = rouletteService.findOpenRoulette();
        Bet newBet = new Bet(betNumber, betColor, bet);
        if (roulette != null && ValidateBet.isBetValid(newBet)) {
            newBet.setUserId(userId);
            newBet.setResultColor(Play.randomColor());
            newBet.setResultNumber(Play.randomNumber());
            newBet.calculateResult();
            betService.save(newBet);
            roulette.addBet(newBet);
            rouletteService.save(roulette);

            return newBet.getResult().toString();
        }

        return roulette == null ? "No hay mesas" : "Apuesta invalida";
    }
    @GetMapping(value = "/listar")
    public List<Roulette> listRoulette(){
        return rouletteService.findAll();
    }
}