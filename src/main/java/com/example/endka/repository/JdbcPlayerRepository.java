package com.example.endka.repository;

import com.example.endka.interfaces.CrudRepository;
import com.example.endka.model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;


import java.util.List;

@Repository
public class JdbcPlayerRepository implements CrudRepository<Player> {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Player player) {
        jdbcTemplate.update(
                "INSERT INTO players (id, nickname, age) VALUES (?, ?, ?)",
                player.getId(),
                player.getNickname(),
                player.getAge()
        );
    }


    @Override
    public Player findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM players WHERE id = ?",
                (rs, rowNum) -> new Player  (
                        rs.getInt("id"),
                        rs.getString("nickname"),
                        rs.getInt("age")
                ),
                id
        );
    }



    @Override
    public List<Player> findAll() {
        List<Player> players = jdbcTemplate.query(
                "SELECT * FROM players",
                (rs, rowNum) -> new Player(
                        rs.getInt("id"),
                        rs.getString("nickname"),
                        rs.getInt("age")
                )
        );

        System.out.println("FROM DB SIZE = " + players.size());
        return players;
    }




    @Override
    public void update(int id, Player player) {
        jdbcTemplate.update(
                "UPDATE players SET nickname = ?, age = ? WHERE id = ?",
                player.getNickname(),
                player.getAge(),
                id
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(
                "DELETE FROM players WHERE id = ?",
                id
        );
    }

}
