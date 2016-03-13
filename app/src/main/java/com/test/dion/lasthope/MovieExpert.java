package com.test.dion.lasthope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 1/30/2016.
 */
public class MovieExpert{
    List<String> getMovie(String genre){
        List<String> movie = new ArrayList<String>();
        switch (genre){
            case "Action":
                movie.add("1--Mission Impossible");
                movie.add("2--James Bond : Spectre");
                movie.add("3--The Secret Service");
                break;
            case "Comedy":
                movie.add("1--Zoolander");
                movie.add("2--Shaun of the dead");
                movie.add("3--Borat: Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan");
                break;
            case "Romance":
                movie.add("1--Legend");
                movie.add("2--The Danish Girl");
                movie.add("3--Cinderella");
                break;
            case "Animation":
                movie.add("1--Minions");
                movie.add("2--Frozen");
                movie.add("3--Hotel Transylvania 2");
                break;
            default:
                movie.add("");
                break;
        }
        return movie;
    }
}
