package com.atherys.items.generator;

import com.atherys.items.custom.CustomItem;
import com.atherys.items.custom.CustomItemBuilder;
import com.atherys.items.generator.attribute.ClampedAttributeGenerator;
import com.atherys.items.generator.attribute.PredictableAttributeGenerator;
import com.atherys.items.generator.enchant.ClampedEnchantmentGenerator;
import com.atherys.items.generator.enchant.PredictableEnchantmentGenerator;
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

    public static Generator<Map<EnchantmentType, Integer>> predictableEnchantmentGenerator(String seed, String separator) {
        return new PredictableEnchantmentGenerator(seed, separator);
    }

    public static Generator<Map<AttributeType, Double>> clampedAttributeGenerator(int number, double minimumValue, double maximumValue) {
        return new ClampedAttributeGenerator(number, minimumValue, maximumValue);
    }

    public static Generator<Map<AttributeType, Double>> predictableAttributeGenerator(String seed, String separator) {
        return new PredictableAttributeGenerator(seed, separator);
    }

}
