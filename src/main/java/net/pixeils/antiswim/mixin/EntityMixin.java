package net.pixeils.antiswim.mixin;

import net.minecraft.entity.Entity;
import net.pixeils.antiswim.client.AntiSwim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow public abstract boolean isSubmergedInWater();

    @Inject(method = "setSprinting",at = @At("HEAD"),cancellable = true)
    public void setSprinting(CallbackInfo ci) {
        if (!AntiSwim.antiswim && isSubmergedInWater())
            ci.cancel();

    }
}
/*
@Mixin(Entity.class)
public class EntityMixin {

    @Shadow public abstract boolean isSubmergedInWater();

    @Inject(method = "setSprinting",at = @At("HEAD"),cancellable = true)
    public void setSprinting(CallbackInfo ci) {
        if (!AntiSwim.antiswim && isSubmergedInWater())
            ci.cancel();

    }
}
*/