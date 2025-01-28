package cn.is52hertz.aLongWalkToWater.listener;

import cn.is52hertz.aLongWalkToWater.manager.PlayerStateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class SprintListener implements Listener {
    private final PlayerStateManager stateManager;

    public SprintListener(PlayerStateManager stateManager) {
        this.stateManager = stateManager;
    }

    @EventHandler
    public void onPlayerToggleSprint(PlayerToggleSprintEvent event) {
        Player player = event.getPlayer();
        if (event.isSprinting()) {
            // 玩家开始疾跑
            stateManager.addSprintingPlayer(player);
        } else {
            // 玩家停止疾跑
            stateManager.removeSprintingPlayer(player);
        }
    }
}
