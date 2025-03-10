package de.tmxx.abilities.util;

import com.comphenix.protocol.events.PacketContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;

/**
 * Project: abilities
 * 09.03.2025
 *
 * @author timmauersberger
 * @version 1.0
 */
public class PacketBroadcaster {
    public static void broadcast(PacketContainer packet) {
        Bukkit.broadcast(Component.text(packet.getType().name()));
        packet.getModifier().getFields().forEach(field -> Bukkit.broadcast(Component.text(field.getField().getName() + ": " + field.getField().getType().getName() + ": " + field.get(packet.getHandle()))));
    }
}
