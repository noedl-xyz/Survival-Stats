package xyz.noedl.survivalStats.listeners;

import xyz.noedl.survivalStats.managers.PlayerDataManager;
import xyz.noedl.survivalStats.utils.PlayerData;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;

public class DeathListener implements Listener {

    private final PlayerDataManager playerDataManager;

    public DeathListener(PlayerDataManager playerDataManager) {
        this.playerDataManager = playerDataManager;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        PlayerData playerData = playerDataManager.getPlayerData(player);

        playerData.incrementDeathCount();

        player.sendMessage("You survived for " + playerData.getDaysSurvived() + " days before dying.");
        player.sendMessage("You have died " + playerData.getDeathCount() + " times.");

        playerData.resetDaysSurvived();
        playerDataManager.savePlayerData(player);
    }
}
