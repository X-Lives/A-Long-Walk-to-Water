package cn.is52hertz.aLongWalkToWater;

import cn.is52hertz.aLongWalkToWater.command.ThirstCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ALongWalkToWater extends JavaPlugin {

    @Override
    public void onEnable() {
        // 初始化 Thirst 类
        // 添加 Thirst 的实例
        Thirst thirst = new Thirst();

        // 注册命令执行器
        ThirstCommand thirstCommand = new ThirstCommand(thirst);
        Objects.requireNonNull(Bukkit.getPluginCommand("thirst")).setExecutor(thirstCommand);

        // 注册事件监听器
        Bukkit.getPluginManager().registerEvents(thirst, this);

        getLogger().info("Thirst Plugin Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
