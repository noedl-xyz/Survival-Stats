package xyz.noedl.survivalStats;

import org.bukkit.plugin.java.JavaPlugin;

public final class SurvivalStats extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getCommand("survivalstats").setExecutor(new SurvivalStatsCommand());
        getLogger().info("SurvivalStats is enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("SurvivalStats is disabled!");

    }
}
