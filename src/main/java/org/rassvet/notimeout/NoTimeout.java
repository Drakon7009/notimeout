package org.rassvet.notimeout;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.rassvet.notimeout.config.NoTimeoutConfig;

@Mod(NoTimeout.MODID)
public final class NoTimeout {
    public static final String MODID = "notimeout";

    public NoTimeout(ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, NoTimeoutConfig.CONFIG);
    }
}
