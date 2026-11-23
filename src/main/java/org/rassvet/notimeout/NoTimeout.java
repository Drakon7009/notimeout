package org.rassvet.notimeout;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.rassvet.notimeout.config.NoTimeoutConfig;

@Mod(NoTimeout.MODID)
public final class NoTimeout {
    public static final String MODID = "notimeout";

    public NoTimeout(ModContainer modContainer) {
        modContainer.registerConfig(localConfigType(), NoTimeoutConfig.CONFIG, "notimeout-common.toml");
    }

    private static ModConfig.Type localConfigType() {
        // FancyModLoader renamed COMMON to LOCAL in Minecraft 26.3.
        try {
            return ModConfig.Type.valueOf("LOCAL");
        } catch (IllegalArgumentException ignored) {
            return ModConfig.Type.valueOf("COMMON");
        }
    }
}
