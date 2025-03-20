package xyz.noedl.survivalStats.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.noedl.survivalStats.utils.PlayerData;

import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PlayerDataManager {

    private final JavaPlugin plugin;
    private final File dataFile;
    private final Map<String, PlayerData> playerDataMap;

    public PlayerDataManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.dataFile = new File(plugin.getDataFolder(), "player_data.yml");
        this.playerDataMap = new HashMap<>();
        loadPlayerData();
    }

    public void loadPlayerData(){
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().warning("Error creating data(player_data.yml) file");
                return;
            }
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(dataFile);

        for (String playerName : config.getKeys(false)) {
            int daysSurvived = config.getInt(playerName + ".daysSurvived");
            int deathCount = config.getInt(playerName + ".deathCount");
            PlayerData playerData = new PlayerData(daysSurvived, deathCount);
            playerDataMap.put(playerName, playerData);
        }
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
            plugin.getLogger().warning("Error saving player data!");
        }
    }

    public PlayerData getPlayerData(Player player) {
        return playerDataMap.computeIfAbsent(player.getName(), name -> new PlayerData());
    }

    public void updateSurvivalDays(Player player) {
        PlayerData playerData = getPlayerData(player);
        playerData.incrementDaysSurvived();
        savePlayerData(player);
    }
}
