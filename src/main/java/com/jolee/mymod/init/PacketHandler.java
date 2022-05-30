package com.jolee.mymod.init;

import com.jolee.mymod.MyMod;

import com.jolee.mymod.network.ClientboundUpdateToiletPacket;
import com.jolee.mymod.network.ServerboundToiletUpdatePacket;
import com.jolee.mymod.network.ClientboundUpdateEnergyStorageScreenPacket;
import com.jolee.mymod.network.ServerboundGetEnergyStoredPacket;


import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public final class PacketHandler {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(MyMod.MOD_ID, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals);

    private PacketHandler() {
    }

    public static void init() {
        int index = 0;
        INSTANCE.messageBuilder(ServerboundToiletUpdatePacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
            .encoder(ServerboundToiletUpdatePacket::encode).decoder(ServerboundToiletUpdatePacket::new)
            .consumer(ServerboundToiletUpdatePacket::handle).add();
        INSTANCE.messageBuilder(ClientboundUpdateToiletPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
            .encoder(ClientboundUpdateToiletPacket::encode).decoder(ClientboundUpdateToiletPacket::new)
            .consumer(ClientboundUpdateToiletPacket::handle).add();
        INSTANCE
            .messageBuilder(ClientboundUpdateEnergyStorageScreenPacket.class, index++, NetworkDirection.PLAY_TO_CLIENT)
            .encoder(ClientboundUpdateEnergyStorageScreenPacket::encode)
            .decoder(ClientboundUpdateEnergyStorageScreenPacket::new)
            .consumer(ClientboundUpdateEnergyStorageScreenPacket::handle).add();
        INSTANCE.messageBuilder(ServerboundGetEnergyStoredPacket.class, index++, NetworkDirection.PLAY_TO_SERVER)
            .encoder(ServerboundGetEnergyStoredPacket::encode).decoder(ServerboundGetEnergyStoredPacket::new)
            .consumer(ServerboundGetEnergyStoredPacket::handle).add();
        MyMod.LOGGER.info("Registered {} packets for mod '{}'", index, MyMod.MOD_ID);
    }
}
