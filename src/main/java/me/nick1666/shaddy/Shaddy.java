package me.nick1666.shaddy;

import me.nick1666.shaddy.events.TestTubeNade;
import me.nick1666.shaddy.items.ItemManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Shaddy extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger log = getLogger();

        log.info("Plugin start complete");
        getServer().getPluginManager().registerEvents(new TestTubeNade(), this);
        log.info("Registered 2 event(s)");

        ItemManager.init();
        log.info("Registered custom items and recipes");
    }
}
