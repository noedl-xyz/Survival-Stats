package xyz.noedl.survivalStats.managers;

import xyz.noedl.survivalStats.utils.PlayerData;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerDataManager {

    private final Map<Player, PlayerData> playerDataMap = new HashMap<>();

    public PlayerData getPlayerData(Player player) {
        if (!playerDataMap.containsKey(player)) {
            playerDataMap.put(player, new PlayerData());
        }
        return playerDataMap.get(player);
    }

    public void savePlayerData(Player player) {
    }
}
