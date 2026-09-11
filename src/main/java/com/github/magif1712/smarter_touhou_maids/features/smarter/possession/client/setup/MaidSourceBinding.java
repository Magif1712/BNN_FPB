package com.github.magif1712.smarter_touhou_maids.features.smarter.possession.client.setup;

import com.github.magif1712.smarter_touhou_maids.SmarterTouhouMaids;
import com.github.magif1712.smarter_touhou_maids.features.smarter.agent.SmarterClientService;
import com.github.magif1712.smarter_touhou_maids.features.smarter.possession.core.PossessionManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SmarterTouhouMaids.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MaidSourceBinding {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        SmarterClientService.INSTANCE.addMaidSource(
                () -> PossessionManager.INSTANCE.getPossessedMaid());
    }
}