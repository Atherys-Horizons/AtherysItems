package com.atherys.items.generator;

import com.atherys.items.custom.CustomItem;
import com.atherys.items.custom.CustomItemBuilder;
import com.atherys.rpg.api.stat.AttributeType;
import org.spongepowered.api.item.enchantment.EnchantmentType;

import javax.annotation.Nonnull;
import java.util.Map;

public class CustomItemGenerator implements Generator<CustomItem> {

    @Nonnull
    private CustomItemBuilder template;

    @Nonnull
    private Generator<String> nameGenerator;

    @Nonnull
    private Generator<Map<EnchantmentType, Integer>> enchantmentGenerator;

    @Nonnull
    private Generator<Map<AttributeType, Double>> attributeGenerator;

    public CustomItemGenerator(
            CustomItemBuilder template,
            @Nonnull Generator<String> nameGenerator,
            @Nonnull Generator<Map<EnchantmentType, Integer>> enchantmentGenerator,
            @Nonnull Generator<Map<AttributeType, Double>> attributeGenerator
    ) {
        this.template = template;
        this.nameGenerator = nameGenerator;
        this.enchantmentGenerator = enchantmentGenerator;
        this.attributeGenerator = attributeGenerator;
    }

    @Override
    public CustomItem get() {
        template.name(nameGenerator.get());
        template.enchantments(enchantmentGenerator.get());
        template.attributes(attributeGenerator.get());
        return template.build();
    }
}
