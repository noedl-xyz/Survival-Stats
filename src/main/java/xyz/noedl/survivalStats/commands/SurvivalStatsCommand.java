package xyz.noedl.survivalStats.commands;

import org.bukkit.Bukkit;
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

            if (args.length == 0) {
                PlayerData playerData = playerDataManager.getPlayerData(player);
                player.sendMessage(ChatColor.GRAY + "Overlevingsstatistieken:");
                player.sendMessage(ChatColor.GREEN + "Dagen Overleefd: " + ChatColor.WHITE + playerData.getDaysSurvived());
                player.sendMessage(ChatColor.RED + "Totaal Doden: " + ChatColor.WHITE + playerData.getDeathCount());
            } else {
                Player targetPlayer = Bukkit.getPlayer(args[0]);

                if (targetPlayer != null && targetPlayer.isOnline()) {
                    PlayerData targetPlayerData = playerDataManager.getPlayerData(targetPlayer);
                    player.sendMessage(ChatColor.GRAY + "Overlevingsstatistieken van " + ChatColor.GOLD + targetPlayer.getName() + ChatColor.GRAY + ":");
                    player.sendMessage(ChatColor.GREEN + "Dagen Overleefd: " + ChatColor.WHITE + targetPlayerData.getDaysSurvived());
                    player.sendMessage(ChatColor.RED + "Totaal Doden: " + ChatColor.WHITE + targetPlayerData.getDeathCount());
                } else {
                    player.sendMessage(ChatColor.RED + "Speler " + args[0] + " is niet online of bestaat niet.");
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Dit commando kan alleen gebruikt worden door spelers.");
        }
        return true;
    }

}
