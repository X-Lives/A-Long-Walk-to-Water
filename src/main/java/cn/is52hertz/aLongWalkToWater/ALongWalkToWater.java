package cn.is52hertz.aLongWalkToWater;

import cn.is52hertz.aLongWalkToWater.command.ThirstCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ALongWalkToWater extends JavaPlugin {

    @Override
    public void onEnable() {
        // Initializing the Thirst Class
        // Adding instances of Thirst
        Thirst thirst = new Thirst();

        // Registering a command executor
        ThirstCommand thirstCommand = new ThirstCommand(thirst);
        Objects.requireNonNull(Bukkit.getPluginCommand("thirst")).setExecutor(thirstCommand);

        // Registering event listeners
        Bukkit.getPluginManager().registerEvents(thirst, this);

        getLogger().info("Thirst Plugin Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
