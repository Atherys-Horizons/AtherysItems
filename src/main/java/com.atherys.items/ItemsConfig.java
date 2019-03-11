package com.atherys.items;

import com.atherys.core.utils.PluginConfig;
import com.atherys.items.custom.CustomItem;
import com.atherys.rpg.api.stat.AttributeTypes;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
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

    @Setting("name-pools")
    public Map<String, NamePoolConfig> NAME_POOLS = new HashMap<>();

    @ConfigSerializable
    public static class NamePoolConfig {

        @Setting("prefixes")
        public List<String> PREFIXES = new ArrayList<>();

        @Setting("names")
        public List<String> NAMES = new ArrayList<>();

        @Setting("postfixes")
        public List<String> POSTFIXES = new ArrayList<>();

        public NamePoolConfig() {}

    }

    @Setting("default-enchantment-amount")
    public int DEFAULT_ENCHANT_AMOUNT = 3;

    @Setting("default-enchantment-minimum-level")
    public int DEFAULT_ENCHANT_MIN_LEVEL = 1;

    @Setting("default-enchantment-maximum-level")
    public int DEFAULT_ENCHANT_MAX_LEVEL = 10;

    @Setting("default-attribute-amount")
    public int DEFAULT_ATTRIBUTE_AMOUNT = 3;

    @Setting("default-attribute-minimum-level")
    public int DEFAULT_ATTRIBUTE_MIN_LEVEL = 1;

    @Setting("default-attribute-maximum-level")
    public int DEFAULT_ATTRIBUTE_MAX_LEVEL = 10;

    protected ItemsConfig() throws IOException {
        super("config/atherysitems", "custom.conf");
    }
}
