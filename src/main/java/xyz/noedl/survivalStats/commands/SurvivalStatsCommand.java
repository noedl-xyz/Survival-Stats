package xyz.noedl.survivalStats.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SurvivalStatsCommand implements CommandExecutor  {

    private final PlayerDataManager playerDataManager = new PlayerDataManager();

    @Override
    public boolean onCommand(CommandSender send, Command command, String label, String[], args) {
        if (sender instanceof Player) {
            Player player = (Player) send;
            PlayerData playerData = playerDataManager.getPlayerData(player);

            player.sendMessage("You have survived for " + playerData.getDaysSurvived() + " Minecraft days.");
            player.sendMessage("You have died " + playerData.getDeathCount() + " times.");
            return true;
        }

        return false;
    }

}
