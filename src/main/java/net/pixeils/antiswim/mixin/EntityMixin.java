package net.pixeils.antiswim.mixin;

import net.minecraft.entity.Entity;
import net.pixeils.antiswim.client.AntiSwim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "setSwimming",at = @At("HEAD"),cancellable = true)
    public void setSwimming(CallbackInfo ci) {
        if (!AntiSwim.antiswim)
            ci.cancel();

    }
}
