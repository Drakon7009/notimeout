package org.rassvet.notimeout.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class NoTimeoutConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final CategoryGeneral GENERAL = new CategoryGeneral();
    public static final ModConfigSpec CONFIG = BUILDER.build();

    private NoTimeoutConfig() {
    }

    public static final class CategoryGeneral {
        public final ModConfigSpec.IntValue timeoutInSeconds;

        private CategoryGeneral() {
            BUILDER.comment("General mod settings").push("general");
            timeoutInSeconds = BUILDER.defineInRange("timeoutInSeconds", 240, 1, 30000);
            BUILDER.pop();
        }
    }
}
