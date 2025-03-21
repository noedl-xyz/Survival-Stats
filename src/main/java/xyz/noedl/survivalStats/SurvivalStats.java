package xyz.noedl.survivalStats;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.noedl.survivalStats.commands.SurvivalStatsCommand;
import xyz.noedl.survivalStats.listeners.DeathListener;
import xyz.noedl.survivalStats.managers.PlayerDataManager;

public final class SurvivalStats extends JavaPlugin {

    private PlayerDataManager playerDataManager;

    @Override
    public void onEnable() {
        playerDataManager = new PlayerDataManager(this);

        getServer().getPluginManager().registerEvents(new DeathListener(playerDataManager), this);

        getCommand("survivalstats").setExecutor(new SurvivalStatsCommand(playerDataManager));

        new BukkitRunnable() {
            @Override
            public void run() {

                for (org.bukkit.entity.Player player : getServer().getOnlinePlayers()) {
                    playerDataManager.updateSurvivalDays(player);
                }
            }
        }.runTaskTimer(this, 0L, 20L); //  (1 seconden)
    }
}
