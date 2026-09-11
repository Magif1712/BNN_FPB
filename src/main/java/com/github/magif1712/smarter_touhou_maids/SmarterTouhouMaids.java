package com.github.magif1712.smarter_touhou_maids;

import com.github.magif1712.smarter_touhou_maids.features.config.ModClientConfig;
import com.github.magif1712.smarter_touhou_maids.features.maid.menu.InitMenus;
import com.github.magif1712.smarter_touhou_maids.features.smarter.possession.ServerPossessionManager;
import com.github.magif1712.smarter_touhou_maids.features.smarter.agent.SmarterClientService;
import com.github.magif1712.smarter_touhou_maids.features.smarter.agent.registry.AiModeDefaults;
import com.github.magif1712.smarter_touhou_maids.features.smarter.network.SmarterTrackingSync;
import com.github.magif1712.smarter_touhou_maids.features.smarter.network.SmarterPendingCleanup;
import com.github.magif1712.smarter_touhou_maids.features.smarter.agent.reflex_arc_system_agent.debug.VisionDebugHook;
import com.github.magif1712.smarter_touhou_maids.network.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SmarterTouhouMaids.MOD_ID)
public class SmarterTouhouMaids {
    public static final String MOD_ID = "smarter_touhou_maids";

    public SmarterTouhouMaids(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        InitMenus.MENUS.register(modEventBus);

        // 注册默认 AI 模式（ai/process/nn 三层 registry + 默认 entry）。
        // 在 FMLCommonSetupEvent 执行：所有 mod 构造器之后、游戏就绪之前，
        // 附属模组可在自己的 setup event 里追加注册。
        modEventBus.addListener((FMLCommonSetupEvent e) -> AiModeDefaults.registerDefaults());

        MinecraftForge.EVENT_BUS.register(ServerPossessionManager.INSTANCE);
        MinecraftForge.EVENT_BUS.register(SmarterClientService.INSTANCE);
        MinecraftForge.EVENT_BUS.register(new SmarterTrackingSync());
        MinecraftForge.EVENT_BUS.register(new SmarterPendingCleanup());
        ///////////////debug/////////////
        // 两分支的视觉调试钩子各一份：各自只在自己分支附身时 dump（isPossessing 天然守卫）。
        MinecraftForge.EVENT_BUS.register(VisionDebugHook.INSTANCE);
        MinecraftForge.EVENT_BUS.register(com.github.magif1712.smarter_touhou_maids.features.smarter.agent.reflex_arc_system_agent_original.debug.VisionDebugHook.INSTANCE);
        /////////////debug end///////////
        NetworkHandler.init();

        ModClientConfig.register();
    }
}