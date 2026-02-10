package com.example.endka.service;

import com.example.endka.interfaces.CrudRepository;
import com.example.endka.model.Player;
import com.example.endka.model.Tournament;
import com.example.endka.repository.JdbcPlayerRepository;
import org.springframework.stereotype.Service;
import com.example.endka.patterns.AppLogger;


import java.util.Comparator;
import java.util.List;

@Service
public class TournamentService {

    private final CrudRepository<Player> playerRepository;

    public TournamentService(CrudRepository<Player> playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayersSortedByAge() {
        List<Player> players = playerRepository.findAll();
        players.sort(Comparator.comparingInt(Player::getAge));
        return players;
    }

    public void registerPlayer(Integer tournamentId, Player player) {
        player.validate();

        AppLogger.getInstance().log(
                "Registering player: " + player.getNickname()
        );

        playerRepository.save(player);
    }


    public void deletePlayer(int id) {
        AppLogger.getInstance().log(
                "Deleting player with id=" + id
        );

        playerRepository.delete(id);
    }

    public void updatePlayer(int id, Player player) {
        AppLogger.getInstance().log("Updating player id=" + id);
        playerRepository.update(id, player);
    }

}

