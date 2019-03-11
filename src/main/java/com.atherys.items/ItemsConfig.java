package com.atherys.items;

import com.atherys.core.utils.PluginConfig;
import com.atherys.items.custom.CustomItem;
import com.atherys.rpg.api.stat.AttributeTypes;
import ninja.leaping.configurate.objectmapping.Setting;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;

import java.io.IOException;
import java.util.*;

public class ItemsConfig extends PluginConfig {

    @Setting("items")
    public List<CustomItem> ITEMS = new ArrayList<>();

    {
        ITEMS.add(CustomItem.builder()
                .id("example-leather-tunic")
                .name("&b&rTough Leather Tunic")
                .itemType(ItemTypes.LEATHER_CHESTPLATE)
                .quantity(1)
                .lore(Arrays.asList(
                        "A toughened leather tunic.",
                        "It's really hard to bite into..."
                ))
                .durability(400)
                .enchantment(EnchantmentTypes.UNBREAKING, 3)
                .enchantment(EnchantmentTypes.THORNS, 1)
                .attribute(AttributeTypes.DEFENSE, 5.0)
                .attribute(AttributeTypes.STRENGTH, 3.0)
                .build()
        );
    }

    protected ItemsConfig() throws IOException {
        super("config/atherysitems", "custom.conf");
    }
}
