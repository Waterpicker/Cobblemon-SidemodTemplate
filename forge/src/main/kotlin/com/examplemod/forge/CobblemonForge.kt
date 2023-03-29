package com.examplemod.forge

import dev.architectury.platform.forge.EventBuses
import com.examplemod.ExampleMod
import java.util.*
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent

@Mod(ExampleMod.MODID)
class ExampleModForge {
    init {
        with(thedarkcolour.kotlinforforge.forge.MOD_BUS) {
            EventBuses.registerModEventBus(ExampleMod.MODID, this)
            addListener(this@ExampleModForge::initialize)
        }
    }

    fun initialize(event: FMLCommonSetupEvent) {
        ExampleMod.initialize()
        println("ExampleMod Forge Init.")
    }

}