package multitallented.redcastlemedia.bukkit.rpgen;

import java.util.logging.Logger;
import multitallented.plugins.heroscoreboard.HeroScoreboard;
import multitallented.redcastlemedia.bukkit.rpgen.commands.CommandManager;
import multitallented.redcastlemedia.bukkit.rpgen.configs.ConfigManager;
import multitallented.redcastlemedia.bukkit.rpgen.database.DatabaseManager;
import multitallented.redcastlemedia.bukkit.rpgen.listeners.PluginServerListener;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Multi
 */
public class RPGen extends JavaPlugin {
    public static final String NAME = "RPGen";
    
    //Managers
    private CommandManager commandManager;
    private PluginServerListener serverListener;
    private DatabaseManager databaseManager;
    
    //Static Plugins
    public static Economy econ;
    public static Permission perms;
    public static HeroScoreboard heroscoreboard;
    
    
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
        
        //Init Managers
        new ConfigManager(config, this);
        //TODO load skill configs
        
        commandManager = new CommandManager(this);
        
        setupPermissions();
        setupEconomy();
        
        serverListener = new PluginServerListener(this);
        
        databaseManager = new DatabaseManager(this);
        
        //TODO setup listeners
        
        //TODO load modules and skill components
        
        Logger log = Logger.getLogger("Minecraft");
        String enableMessage = "[" + RPGen.NAME + "] is enabled";
        log.info(enableMessage);
    }
    
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp != null) {
            econ = rsp.getProvider();
            if (econ != null)
                System.out.println("[HeroStronghold] Hooked into " + econ.getName());
        }
        return econ != null;
    }
    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            perms = permissionProvider.getProvider();
            if (perms != null)
                System.out.println("[HeroStronghold] Hooked into " + perms.getName());
        }
        return (perms != null);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return commandManager.executeCommand(sender, command, label, args);
    }
}