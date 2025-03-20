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

        player.sendMessage(ChatColor.YELLOW + "Je hebt " + ChatColor.GREEN + playerData.getDaysSurvived() + ChatColor.YELLOW + " dagen overleefd voordat je stierf.");
        player.sendMessage(ChatColor.YELLOW + "Je bent nu in totaal " + ChatColor.RED + playerData.getDeathCount() + ChatColor.YELLOW + " keer dood gegaan!");

        playerData.resetDaysSurvived();
        playerDataManager.savePlayerData(player);
    }
}
