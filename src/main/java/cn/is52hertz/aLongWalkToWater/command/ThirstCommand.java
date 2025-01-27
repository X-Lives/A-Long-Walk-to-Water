package cn.is52hertz.aLongWalkToWater.command;

import cn.is52hertz.aLongWalkToWater.Thirst;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ThirstCommand implements CommandExecutor {

    private final Thirst thirst;

    // Receiving a Thirst instance in a constructor
    public ThirstCommand(Thirst thirst) {
        this.thirst = thirst;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        if (sender instanceof Player player) {
            String playerName = player.getName();

            // Getting player thirst values using thirst instances
            TextComponent thirstMessage = Component.text(playerName + ": ")
                    .color(TextColor.color(0x4E9DFF))
                    .decoration(TextDecoration.BOLD, true)
                    .append(Component.text(thirst.getThirst(player))); // Get Thirst Value

            // Send a message to the player
            player.sendMessage(thirstMessage);
        } else {
            sender.sendMessage("Only players can use this command.");
        }
        return true;
    }
}
