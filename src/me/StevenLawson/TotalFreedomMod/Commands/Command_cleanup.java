package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_CONSOLE)
@CommandParameters(description = "Run's the system cleanup", usage = "/<command>")
public class Command_cleanup extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.bcastMsg(ChatColor.RED + "Atempting to start midnight cleanup");
        if (senderIsConsole)
        {
            server.dispatchCommand(sender, "opall -c");
            server.dispatchCommand(sender, "setl");
            server.dispatchCommand(sender, "purgeall");
            TFM_Util.bcastMsg(ChatColor.GREEN + "Midnightly Clean Up Completed. Reloading Server");
            server.dispatchCommand(sender, "fopm reload");
            server.dispatchCommand(sender, "cc");
            server.dispatchCommand(sender, "reload");
        }
        else
        {
            TFM_Util.bcastMsg(ChatColor.RED + "Cleanup failed");
        }

        return true;
    }
}
