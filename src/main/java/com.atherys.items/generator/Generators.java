package com.atherys.items.generator;

import com.atherys.items.custom.CustomItem;
import com.atherys.items.custom.CustomItemBuilder;
import com.atherys.items.generator.attribute.ClampedAttributeGenerator;
import com.atherys.items.generator.enchant.ClampedEnchantmentGenerator;
import com.atherys.items.generator.name.ItemTypeNameGenerator;
import com.atherys.rpg.api.stat.AttributeType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.EnchantmentType;

import java.util.Map;

public final class Generators {

    public static Generator<CustomItem> itemGenerator(
            CustomItemBuilder template,
            Generator<String> nameGenerator,
            Generator<Map<EnchantmentType, Integer>> enchantmentGenerator,
            Generator<Map<AttributeType, Double>> attributeGenerator
    ) {
        return new CustomItemGenerator(template, nameGenerator, enchantmentGenerator, attributeGenerator);
    }

    public static Generator<String> itemTypeNameGenerator(ItemType itemType) {
        return new ItemTypeNameGenerator(itemType);
    }

    public static Generator<Map<EnchantmentType, Integer>> clampedEnchantmentGenerator(int number, int minimumLevel, int maximumLevel) {
        return new ClampedEnchantmentGenerator(number, minimumLevel, maximumLevel);
    }

//    public static Generator<List<Enchantment>> configuredClampedEnchantmentGenerator() {
//        return new ClampedEnchantmentGenerator(
//                AtherysItems.getInstance().getConfig().DEFAULT_ENCHANT_AMOUNT,
//                AtherysItems.getInstance().getConfig().DEFAULT_ENCHANT_MIN_LEVEL,
//                AtherysItems.getInstance().getConfig().DEFAULT_ENCHANT_MAX_LEVEL
//        );
//    }

    public static Generator<Map<AttributeType, Double>> clampedAttributeGenerator(int number, double minimumValue, double maximumValue) {
        return new ClampedAttributeGenerator(number, minimumValue, maximumValue);
    }

//    public static Generator<Map<AttributeType, Double>> configuredClampedAttributeGenerator() {
//        return new ClampedEnchantmentGenerator(
//                AtherysItems.getInstance().getConfig().DEFAULT_ATTRIBUTE_AMOUNT,
//                AtherysItems.getInstance().getConfig().DEFAULT_ATTRIBUTE_MIN_LEVEL,
//                AtherysItems.getInstance().getConfig().DEFAULT_ATTRIBUTE_MAX_LEVEL
//        );
//    }

}
