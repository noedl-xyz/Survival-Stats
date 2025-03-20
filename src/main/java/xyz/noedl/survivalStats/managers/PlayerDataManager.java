package xyz.noedl.survivalStats.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import xyz.noedl.survivalStats.utils.PlayerData;

import org.bukkit.entity.Player;

import java.io.IOException;
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

    public void updateSurvivalDays(Player player) {
        PlayerData playerData = getPlayerData(player);
        playerData.incrementDaysSurvived();
        savePlayerData(player);
    }

    public void savePlayerData(Player player) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(dataFile);
        PlayerData playerData = playerDataMap.get(player.getName());

        if (playerData != null) {
            config.set(player.getName() + ".daysSurvived", playerData.getDaysSurvived());
            config.set(player.getName() + ".deathCount", playerData.getDeathCount());
        }

        try {
            config.save(dataFile);
        } catch (IOException e) {
            plugin.getLogger.warning("Error saving player data!");
        }
    }
}
