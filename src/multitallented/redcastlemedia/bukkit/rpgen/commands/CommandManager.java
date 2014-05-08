package multitallented.redcastlemedia.bukkit.rpgen.commands;

import multitallented.redcastlemedia.bukkit.rpgen.RPGen;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Multi
 */
public class CommandManager {
    private RPGen plugin;
    
    public CommandManager(RPGen plugin) {
        this.plugin = plugin;
    }
    
    public boolean executeCommand(CommandSender sender, Command command, String label, String[] args) {
        //TODO fix this
        return false;
    }
}
