package multitallented.redcastlemedia.bukkit.rpgen;

import java.util.logging.Logger;
import multitallented.redcastlemedia.bukkit.rpgen.commands.CommandManager;
import multitallented.redcastlemedia.bukkit.rpgen.configs.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Multi
 */
public class RPGen extends JavaPlugin {
    public static final String NAME = "RPGen";
    
    private CommandManager commandManager;
    
    @Override
    public void onDisable() {
        Logger log = Logger.getLogger("Minecraft");
        String message = "[" + RPGen.NAME + "] is disabled";
        log.info(message);
    }

    @Override
    public void onEnable() {
        
        //setup config.yml
        FileConfiguration config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        new ConfigManager(config, this);
        
        commandManager = new CommandManager(this);
        
        //TODO hook into Vault
        
        //TODO listen for HeroScoreboard
        
        //TODO load database
        
        //TODO load skill configs
        
        //TODO setup listeners
        
        Logger log = Logger.getLogger("Minecraft");
        String enableMessage = "[" + RPGen.NAME + "] is enabled";
        log.info(enableMessage);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return commandManager.executeCommand(sender, command, label, args);
    }
}