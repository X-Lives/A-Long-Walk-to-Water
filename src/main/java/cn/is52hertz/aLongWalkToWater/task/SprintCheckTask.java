package cn.is52hertz.aLongWalkToWater.task;

import cn.is52hertz.aLongWalkToWater.Thirst;
import cn.is52hertz.aLongWalkToWater.manager.PlayerStateManager;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SprintCheckTask extends BukkitRunnable {
    private final PlayerStateManager stateManager;
    private final Thirst thirst;

    public SprintCheckTask(PlayerStateManager stateManager, Thirst thirst) {
        this.stateManager = stateManager;
        this.thirst = thirst;
    }

    @Override
    public void run() {
        // 遍历所有标记为疾跑的玩家
        for (Player player : stateManager.getSprintingPlayers()) {
            thirst.decreaseThirst(player, 1);
        }
    }
}
