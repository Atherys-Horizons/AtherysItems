package com.atherys.items.generator.enchant;

import com.atherys.items.generator.AbstractGenerator;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.enchantment.EnchantmentType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClampedEnchantmentGenerator extends AbstractGenerator<Map<EnchantmentType, Integer>> {
    private int amount;

    private int minimumLevel;

    private int maximumLevel;

    public ClampedEnchantmentGenerator(int number, int minimumLevel, int maximumLevel) {
        this.amount = number;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
    }

    public EnchantmentType getRandomType() {
        Collection<EnchantmentType> attributeTypes = Sponge.getRegistry().getAllOf(EnchantmentType.class);
        return attributeTypes.parallelStream()
                .skip((long) (attributeTypes.size() * getRandom().nextDouble()))
                .findFirst()
                .orElse(null);
    }

    public Integer getRandomLevel() {
        return minimumLevel + (int) (getRandom().nextDouble() * (maximumLevel - minimumLevel));
    }

    @Override
    public Map<EnchantmentType, Integer> get() {
        Map<EnchantmentType, Integer> result = new HashMap<>();

        for (int i = 0; i < amount; i++) {
            result.put(getRandomType(), getRandomLevel());
        }

        return result;
    }
}
