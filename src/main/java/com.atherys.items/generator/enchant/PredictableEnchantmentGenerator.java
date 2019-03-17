package com.atherys.items.generator.enchant;

import com.atherys.items.generator.Generator;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;

import java.util.HashMap;
import java.util.Map;

public class PredictableEnchantmentGenerator implements Generator<Map<EnchantmentType, Integer>> {

    private static final Map<String, EnchantmentType> ENCHANTMENT_SHORTHANDS = new HashMap<>();
    static {
        ENCHANTMENT_SHORTHANDS.put("aa", EnchantmentTypes.AQUA_AFFINITY);
        ENCHANTMENT_SHORTHANDS.put("ba", EnchantmentTypes.BANE_OF_ARTHROPODS);
        // TODO: Add shortcuts for the rest of the enchantment types
    }

    private String seed;

    private String separator;

    private Map<EnchantmentType, Integer> result;

    public PredictableEnchantmentGenerator(String seed, String separator) {
        this.seed = seed;
        this.separator = separator;
    }

    @Override
    public Map<EnchantmentType, Integer> get() {
        if (result != null) {
            return result;
        }

        result = new HashMap<>();

        String[] tokens = seed.split(separator);

        for (String token : tokens) {
            EnchantmentType type = ENCHANTMENT_SHORTHANDS.get(token.substring(0, 2));
            Integer value = Integer.valueOf(token.substring(2));

            result.put(type, value);
        }

        return result;
    }
}
