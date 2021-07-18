package com.codeup.adlister.dao;

import com.codeup.adlister.models.Game;
import java.util.List;

public interface Games {
    List<Game> all();
    Long insert(Game game);
    List<Game> searchByTitle(String query);
    Game findByID(Long id);
    List<Game> findByGenre(String genre);
}
