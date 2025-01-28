package cn.is52hertz.aLongWalkToWater;

import cn.is52hertz.aLongWalkToWater.command.ThirstCommand;
import cn.is52hertz.aLongWalkToWater.listener.SprintListener;
import cn.is52hertz.aLongWalkToWater.manager.PlayerStateManager;
import cn.is52hertz.aLongWalkToWater.task.SprintCheckTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ALongWalkToWater extends JavaPlugin {

    private SprintCheckTask sprintCheckTask;

    @Override
    public void onEnable() {
        // Initializing the Thirst Class
        // Adding instances of Thirst
        Thirst thirst = new Thirst();
        PlayerStateManager stateManager = new PlayerStateManager();

        // Registering a command executor
        ThirstCommand thirstCommand = new ThirstCommand(thirst);
        Objects.requireNonNull(Bukkit.getPluginCommand("thirst")).setExecutor(thirstCommand);

        // Registering event listeners
        Bukkit.getPluginManager().registerEvents(thirst, this);

        // 注册事件监听器
        getServer().getPluginManager().registerEvents(
                new SprintListener(stateManager), this
        );

        // 启动定时任务（每秒执行）
        sprintCheckTask = new SprintCheckTask(stateManager, thirst);
        sprintCheckTask.runTaskTimer(this, 0, 20);

        getLogger().info("Thirst Plugin Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (sprintCheckTask != null) {
            sprintCheckTask.cancel();
        }
    }
}
