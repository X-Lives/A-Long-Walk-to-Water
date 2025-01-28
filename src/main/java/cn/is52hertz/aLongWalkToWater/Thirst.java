package cn.is52hertz.aLongWalkToWater;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.HashMap;
import java.util.Map;

public class Thirst implements Listener {

    public Map<Player, Integer> playerThirst = new HashMap<>();

    // If a new player join , give him a thirst.
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!playerThirst.containsKey(player)) {
            playerThirst.put(player, 100);
        }
    }

    // If the player dies, reset.
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        setThirst(player, 100);
    }

    /**
     * Get thirst.
     * @param player see Player.java
     * @return The player's thirst.
     */
    public int getThirst(Player player) {
        return playerThirst.getOrDefault(player, 100);
    }

    /**
     * Set thirst.
     * @param player see Player.java
     * @param thirst the value which your want to set.
     */
    public void setThirst(Player player, int thirst) {
        playerThirst.put(player, thirst);
    }

    public void increaseThirst(Player player, int amount) {
        int currentThirst = getThirst(player);
        setThirst(player, currentThirst + amount);
    }

    public void decreaseThirst(Player player, int amount) {
        int currentThirst = getThirst(player);
        setThirst(player, currentThirst - amount);
    }
}
