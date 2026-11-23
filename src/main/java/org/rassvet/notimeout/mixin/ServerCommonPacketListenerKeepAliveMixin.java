package org.rassvet.notimeout.mixin;

import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import org.rassvet.notimeout.config.NoTimeoutConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerCommonPacketListenerImpl.class)
public final class ServerCommonPacketListenerKeepAliveMixin {
    @Shadow
    private boolean keepAlivePending;

    @ModifyConstant(
            method = "keepConnectionAlive",
            constant = @Constant(longValue = 15000L)
    )
    private long notimeout$getKeepAliveDelay(long vanillaInterval) {
        long timeoutMillis = NoTimeoutConfig.GENERAL.timeoutInSeconds.get() * 1000L;
        // Send the probe before the read timeout even when it is shorter than vanilla's interval.
        return keepAlivePending ? timeoutMillis : Math.min(vanillaInterval, timeoutMillis / 2);
    }
}
