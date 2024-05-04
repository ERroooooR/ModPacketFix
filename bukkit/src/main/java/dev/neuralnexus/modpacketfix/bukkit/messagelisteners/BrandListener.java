package dev.neuralnexus.modpacketfix.bukkit.messagelisteners;

import dev.neuralnexus.modpacketfix.bukkit.BukkitModPacketFixPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

public class BrandListener implements PluginMessageListener, Listener {
    private final BukkitModPacketFixPlugin plugin;

    public BrandListener(BukkitModPacketFixPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, @NotNull byte[] message) {
        // 这里可以保留原有的 onPluginMessageReceived 方法逻辑
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // 在玩家加入时将他们添加到 Forge 用户列表
        plugin.addForgeUser(player);
        plugin.getLogger().info("Registered " + player.getName() + " as a forge user");
    }
}
