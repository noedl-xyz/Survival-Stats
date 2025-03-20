package xyz.noedl.survivalStats.commands;

import xyz.noedl.survivalStats.managers.PlayerDataManager;
import xyz.noedl.survivalStats.utils.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SurvivalStatsCommand implements CommandExecutor  {

    private final PlayerDataManager playerDataManager = new PlayerDataManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            PlayerData playerData = playerDataManager.getPlayerData(player);

            player.sendMessage("You have survived for " + playerData.getDaysSurvived() + " Minecraft days.");
            player.sendMessage("You have died " + playerData.getDeathCount() + " times.");

            return true;
        } else {
            sender.sendMessage("Only players can use this command.");
            return false;
        }
    }

}
