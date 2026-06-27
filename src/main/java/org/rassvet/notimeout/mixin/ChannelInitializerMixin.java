package org.rassvet.notimeout.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.rassvet.notimeout.config.NoTimeoutConfig;

@Mixin(targets = {
        "net/minecraft/network/Connection$1",
        "net/minecraft/server/network/ServerConnectionListener$1"
})
public final class ChannelInitializerMixin {
    @ModifyArg(
            method = "initChannel(Lio/netty/channel/Channel;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lio/netty/handler/timeout/ReadTimeoutHandler;<init>(I)V"
            )
    )
    private int timeoutFixes$getReadTimeout(int timeout) {
        return NoTimeoutConfig.GENERAL.timeoutInSeconds.get();
    }
}
