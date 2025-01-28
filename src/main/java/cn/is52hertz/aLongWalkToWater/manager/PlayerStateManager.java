package cn.is52hertz.aLongWalkToWater.manager;

import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.Set;

public class PlayerStateManager {
    private final Set<Player> sprintingPlayers = new HashSet<>();

    // 添加疾跑玩家
    public void addSprintingPlayer(Player player) {
        sprintingPlayers.add(player);
    }

    // 移除疾跑玩家
    public void removeSprintingPlayer(Player player) {
        sprintingPlayers.remove(player);
    }

    // 获取当前疾跑玩家集合
    public Set<Player> getSprintingPlayers() {
        return new HashSet<>(sprintingPlayers); // 返回副本避免并发问题
    }
}