package xyz.noedl.survivalStats;

import xyz.noedl.survivalStats.commands.FartCommand;
import xyz.noedl.survivalStats.listeners.DeathListener;
import xyz.noedl.survivalStats.commands.SurvivalStatsCommand;

import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalStats extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getCommand("survivalstats").setExecutor(new SurvivalStatsCommand());
        getCommand("fart").setExecutor(new FartCommand());
        getLogger().info("SurvivalStats is enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("SurvivalStats is disabled!");

    }
}
