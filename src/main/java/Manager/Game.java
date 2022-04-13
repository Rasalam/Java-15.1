package Manager;

import Domain.NotRegisteredException;
import Domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private List<Player> players = new ArrayList<>();

    public Player findByName(String name) {
        for (Player player : players) {
            if (Objects.equals(player.getName(), name)) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int result = 0;
        if (checkRegistration(playerName1, playerName2)) {
            int firstStrength = findByName(playerName1).getStrength();
            int secondStrength = findByName(playerName2).getStrength();
            if (firstStrength - secondStrength > 0) {
                result = 1;
            } else {
                if (firstStrength - secondStrength < 0) {
                    result = 2;
                }
            }
        }
        return result;
    }

    public boolean checkRegistration(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }
        return true;
    }

}


