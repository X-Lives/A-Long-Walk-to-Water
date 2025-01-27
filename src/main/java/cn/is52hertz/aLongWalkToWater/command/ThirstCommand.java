package cn.is52hertz.aLongWalkToWater.command;

import cn.is52hertz.aLongWalkToWater.Thirst;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ThirstCommand implements CommandExecutor {
    private Thirst Thirst;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player player) {
            String playerName = player.getName();

            final TextComponent ThirstMessage = Component.text(playerName + ": ")
                            .color(TextColor.color(0x4E9DFF)).decoration(TextDecoration.BOLD, true)
                            .append(Component.text(Thirst.getThirst(player)));
            sender.sendMessage(ThirstMessage);
        } else {
            return false;
        }
        return true;
    }
}
