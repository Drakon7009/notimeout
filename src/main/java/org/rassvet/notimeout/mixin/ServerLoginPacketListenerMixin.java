package org.rassvet.notimeout.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.server.network.ServerLoginPacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.rassvet.notimeout.config.NoTimeoutConfig;

@Mixin(ServerLoginPacketListenerImpl.class)
public final class ServerLoginPacketListenerMixin {
    @Shadow
    private int tick;

    @Inject(method = "tick", at = @At("TAIL"))
    private void timeoutFixes$tick(CallbackInfo info) {
        if (tick >= NoTimeoutConfig.GENERAL.timeoutInSeconds.get() * 20) {
            ((ServerLoginPacketListenerImpl) (Object) this).disconnect(Component.translatable("multiplayer.disconnect.slow_login"));
        }
    }

    @Redirect(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/network/ServerLoginPacketListenerImpl;disconnect(Lnet/minecraft/network/chat/Component;)V"
            )
    )
    private void timeoutFixes$cancelVanillaLoginTimeout(ServerLoginPacketListenerImpl handler, Component reason) {
    }
}
