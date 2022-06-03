package ru.netology;

import ru.netology.data.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    public Game() {
    }

    private Collection<Player> players = new ArrayList<Player>();

    private Player getPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName)
                return player;
        }
        return null;
    }

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = getPlayer(playerName1);
        Player player2 = getPlayer(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else
            return 2;
    }
}