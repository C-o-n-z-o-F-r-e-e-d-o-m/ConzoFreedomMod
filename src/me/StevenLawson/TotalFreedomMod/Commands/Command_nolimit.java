package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditBridge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Sets everyone's Worldedit block modification limit to -1.", usage = "/<command>")
public class Command_nolimit extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.adminAction(sender.getName(), "Setting everyone's Worldedit block modification limit to -1.", true);
        TFM_WorldEditBridge web = TFM_WorldEditBridge.getInstance();
        for (final Player player : server.getOnlinePlayers())
        {
            web.setLimit(player, -1);
        }
        return true;
    }
}
