package com.atherys.items.generator.attribute;

import com.atherys.items.generator.AbstractGenerator;
import com.atherys.rpg.api.stat.AttributeType;
import org.spongepowered.api.Sponge;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClampedAttributeGenerator extends AbstractGenerator<Map<AttributeType, Double>> {

    private int amount;

    private double minimumValue;

    private double maximumValue;

    public ClampedAttributeGenerator(int number, double minimumValue, double maximumValue) {
        this.amount = number;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    public AttributeType getRandomType() {
        Collection<AttributeType> attributeTypes = Sponge.getRegistry().getAllOf(AttributeType.class);
        return attributeTypes.parallelStream()
                .skip((long) (attributeTypes.size() * getRandom().nextDouble()))
                .findFirst()
                .orElse(null);
    }

    public Double getRandomValue() {
        return minimumValue + (getRandom().nextDouble() * (maximumValue - minimumValue));
    }

    @Override
    public Map<AttributeType, Double> get() {
        Map<AttributeType, Double> result = new HashMap<>();

        for (int i = 0; i < amount; i++) {
            result.put(getRandomType(), getRandomValue());
        }

        return result;
    }
}
