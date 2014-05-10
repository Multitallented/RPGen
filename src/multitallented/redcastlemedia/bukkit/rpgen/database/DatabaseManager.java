package multitallented.redcastlemedia.bukkit.rpgen.database;

import multitallented.redcastlemedia.bukkit.rpgen.RPGen;

/**
 *
 * @author Multi
 */
public class DatabaseManager {
    private final RPGen plugin;
    
    public DatabaseManager(RPGen plugin) {
        this.plugin = plugin;
        //TODO connect to database and dump data if tables don't exist
    }
}
