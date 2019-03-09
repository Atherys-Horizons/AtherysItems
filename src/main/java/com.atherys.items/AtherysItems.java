package com.atherys.items;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

import java.io.IOException;

@Plugin(
        id = "atherysitems",
        name = "A'therys Items",
        description = "",
        version = "",
        dependencies = {
                @Dependency(id = "atherysrpg")
        }
)
public class AtherysItems {

    @Listener
    public void onInit(GameInitializationEvent event) {
        try {
            ItemsConfig config = new ItemsConfig();
            config.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
