package multitallented.redcastlemedia.bukkit.rpgen.configs;

import multitallented.redcastlemedia.bukkit.rpgen.RPGen;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author Multi
 */
public class ConfigManager {
    
    private static String DB_HOST;
    private static String DB_USERNAME;
    private static String DB_PASSWORD;
    private static String DB_NAME;
    private static String DB_TABLE_PREFIX;
    
    
    public ConfigManager(FileConfiguration config, RPGen plugin) {
        YamlConfiguration conf;
        try {
            conf = (YamlConfiguration) config;
            DB_HOST = conf.getString("database.host");
            DB_USERNAME = conf.getString("database.username");
            DB_PASSWORD = conf.getString("database.password");
            DB_NAME = conf.getString("database.db_name");
            DB_TABLE_PREFIX = conf.getString("database.table_prefix");
        } catch (Exception e) {
            
        }
    }
    
    public static String getDBHost() {
        return DB_HOST;
    }
    public static String getDBUsername() {
        return DB_USERNAME;
    }
    public static String getDBPassword() {
        return DB_PASSWORD;
    }
    public static String getDBName() {
        return DB_NAME;
    }
    public static String getDBTablePrefix() {
        return DB_TABLE_PREFIX;
    }
}