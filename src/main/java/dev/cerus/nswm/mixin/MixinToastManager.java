package dev.cerus.nswm.mixin;

import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.Toast;
import net.minecraft.client.toast.ToastManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ToastManager.class)
public class MixinToastManager {

    @Inject(
            method = "add(Lnet/minecraft/client/toast/Toast;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    public void injectToastAdd(final Toast toast, final CallbackInfo ci) {
        if (toast instanceof SystemToast st && st.getType() == SystemToast.Type.UNSECURE_SERVER_WARNING) {
            ci.cancel();
        }
    }

}
