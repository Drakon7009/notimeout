package org.rassvet.notimeout.mixin;

import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.rassvet.notimeout.config.NoTimeoutConfig;

@Mixin(ServerCommonPacketListenerImpl.class)
public final class ServerCommonPacketListenerKeepAliveMixin {
    @ModifyConstant(
            method = "keepConnectionAlive",
            constant = @Constant(longValue = 15000L)
    )
    private long timeoutFixes$getKeepAlivePacketInterval(long interval) {
        return NoTimeoutConfig.GENERAL.timeoutInSeconds.get() * 1000L;
    }
}
