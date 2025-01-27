package cn.is52hertz.aLongWalkToWater;

import cn.is52hertz.aLongWalkToWater.command.ThirstCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ALongWalkToWater extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginCommand("thirst").setExecutor(new ThirstCommand());
        Bukkit.getPluginManager().registerEvents(new Thirst(), this);
        getLogger().info("Thirst Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
