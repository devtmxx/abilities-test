package de.tmxx.abilities;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import de.tmxx.abilities.ability.AbilityFactory;
import de.tmxx.abilities.ability.endershot.EnderShotProjectile;
import de.tmxx.abilities.ability.endershot.EnderShotProjectileImpl;
import de.tmxx.abilities.ability.waterbender.WaterQueue;
import de.tmxx.abilities.ability.waterbender.WaterQueueImpl;
import de.tmxx.abilities.entity.CustomEntityRegistry;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Project: abilities
 * 09.03.2025
 *
 * @author timmauersberger
 * @version 1.0
 */
public class AbilitiesModule extends AbstractModule {
    private final AbilitiesPlugin plugin;

    public AbilitiesModule(AbilitiesPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(JavaPlugin.class).toInstance(plugin);
        bind(CustomEntityRegistry.class);

        install(new FactoryModuleBuilder()
                .implement(WaterQueue.class, WaterQueueImpl.class)
                .implement(EnderShotProjectile.class, EnderShotProjectileImpl.class)
                .build(AbilityFactory.class));
    }
}
