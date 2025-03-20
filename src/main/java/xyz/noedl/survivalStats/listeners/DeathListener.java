package xyz.noedl.survivalStats.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;

public class DeathListener implements Listener {

    private final PlayerDataManager playerDataManager = new PlayerDataManager();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        PlayerData playerData = playerDataManager.getPlayerData(player);

        playerData.IncrementDeathCount();
        playerDataManager.savePlayerData(player);

        player.sendMessage("You survived for " + playerData.getDaysSurvived() + " days before dying.");
        player.sendMessage("You have died " + playerData.getDeathCount() + " times.");
    }
}
