package multitallented.redcastlemedia.bukkit.rpgen.listeners;

import java.util.logging.Logger;
import multitallented.plugins.heroscoreboard.HeroScoreboard;
import multitallented.redcastlemedia.bukkit.rpgen.RPGen;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Multi
 */
public class PluginServerListener implements Listener {
    private RPGen plugin;
    private HeroScoreboard heroscoreboard;

    public PluginServerListener(RPGen p) {
        this.plugin = p;
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        Plugin currentPlugin = event.getPlugin();
        String name = currentPlugin.getDescription().getName();
        
        if (name.equals("Heroes")) {
            Logger log = Logger.getLogger("Minecraft");
            String message = "[HeroStronghold] " + name + " has been disabled!";
            log.info(message);
            RPGen.heroscoreboard = null;
        }
    }

    @EventHandler
    public void onPluginEnable(PluginEnableEvent event) {
        Plugin currentPlugin = event.getPlugin();
        String name = currentPlugin.getDescription().getName();
        
        if (name.equals("Heroes")) {
            RPGen.heroscoreboard = (HeroScoreboard) currentPlugin;
            Logger log = Logger.getLogger("Minecraft");
            log.info("[HeroStronghold] Successfully hooked Heroes.");
        }
    }
}

