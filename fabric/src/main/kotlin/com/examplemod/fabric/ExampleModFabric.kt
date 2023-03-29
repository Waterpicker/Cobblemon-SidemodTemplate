package com.examplemod.fabric

import com.examplemod.ExampleMod
import net.fabricmc.api.ModInitializer

class ExampleModFabric : ModInitializer {
    override fun onInitialize() {
        System.out.println("Fabric Mod init")
        ExampleMod.initialize();
    }
}