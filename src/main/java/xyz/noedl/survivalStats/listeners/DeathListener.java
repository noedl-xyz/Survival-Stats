package xyz.noedl.survivalStats.listeners;

import org.bukkit.ChatColor;
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

        player.sendMessage("You survived for " + ChatColor.GREEN + playerData.getDaysSurvived() + ChatColor.RESET + " days before you died.");
        player.sendMessage("You have now died a total of " + ChatColor.RED + playerData.getDeathCount() + ChatColor.RESET + " times!");

        playerData.resetDaysSurvived();
        playerDataManager.savePlayerData(player);
    }
}
