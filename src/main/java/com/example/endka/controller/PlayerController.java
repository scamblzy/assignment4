package com.example.endka.controller;

import com.example.endka.model.Player;
import com.example.endka.service.TournamentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.endka.patterns.AppLogger;


import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final TournamentService tournamentService;

    public PlayerController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return tournamentService.getAllPlayersSortedByAge();
    }

    @PostMapping
    public void createPlayer(@RequestBody Player player) {
        tournamentService.registerPlayer(null, player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        tournamentService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public void updatePlayer(
            @PathVariable int id,
            @RequestBody Player player
    ) {
        tournamentService.updatePlayer(id, player);
    }



}
