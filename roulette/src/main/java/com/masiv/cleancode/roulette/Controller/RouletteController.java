package com.masiv.cleancode.roulette.Controller;

import com.masiv.cleancode.roulette.Models.Entity.Roulette;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouletteController{
    @GetMapping(value="/")
    public Roulette newRoulette() {
        return new Roulette();
    }
}