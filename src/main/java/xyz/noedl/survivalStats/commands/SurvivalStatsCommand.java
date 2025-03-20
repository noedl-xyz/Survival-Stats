package xyz.noedl.survivalStats.commands;

import org.bukkit.ChatColor;
import xyz.noedl.survivalStats.managers.PlayerDataManager;
import xyz.noedl.survivalStats.utils.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SurvivalStatsCommand implements CommandExecutor  {

    private final PlayerDataManager playerDataManager;

    public SurvivalStatsCommand(PlayerDataManager playerDataManager) {
        this.playerDataManager = playerDataManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            PlayerData playerData = playerDataManager.getPlayerData(player);

            player.sendMessage(ChatColor.GREEN + "Survival Stats:");
            player.sendMessage(ChatColor.YELLOW + "Days Survived: " + ChatColor.GOLD + playerData.getDaysSurvived());
            player.sendMessage(ChatColor.YELLOW + "Total Deaths: " + ChatColor.RED + playerData.getDeathCount());

            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");

            return false;
        }
    }

}
