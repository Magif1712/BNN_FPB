package com.github.magif1712.smarter_touhou_maids.features.smarter.agent.reflex_arc_system_agent_original;

import com.github.magif1712.smarter_touhou_maids.features.smarter.agent.reflex_arc_system_agent_original.effector.network.ServerboundActionIntentPacket;
import net.minecraftforge.network.simple.SimpleChannel;

public final class AgentNetwork {
    private AgentNetwork() {
    }

    public static int registerPackets(SimpleChannel channel, int baseIndex) {
        int index = baseIndex;
        channel.registerMessage(index++, ServerboundActionIntentPacket.class, ServerboundActionIntentPacket::encode, ServerboundActionIntentPacket::decode, ServerboundActionIntentPacket::handle);
        return index;
    }
}