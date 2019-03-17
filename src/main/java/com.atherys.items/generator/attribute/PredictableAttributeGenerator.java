package com.atherys.items.generator.attribute;

import com.atherys.items.generator.AbstractGenerator;
import com.atherys.items.generator.Generator;
import com.atherys.rpg.api.stat.AttributeType;
import com.atherys.rpg.api.stat.AttributeTypes;

import java.util.HashMap;
import java.util.Map;

/**
 * Will generate a map of attributes and their values from a string in the following format:<br>
 * <br>
 * {attribute_shorthand}{attribute_value}{separator}{attribute_shorthand}{attribute_value}{separator}{attribute_shorthand}{attribute_value}{separator}...<br>
 * <br>
 * Example seed: ag5-ch12-st7 ( Agility of 5, Charisma of 12, Strength of 7 )<br>
 * <br>
 * Map of all shorthands: <br>
 *     ag - Agility<br>
 *     df - Defense<br>
 *     in - Intelligence<br>
 *     ch - Charisma<br>
 *     ws - Wisdom<br>
 *     wp - Willpower<br>
 *     pc - Perception<br>
 *     lk - Luck<br>
 *     ct - Constitution<br>
 *     st - Strength
 */
public class PredictableAttributeGenerator implements Generator<Map<AttributeType, Double>> {

    private static final Map<String, AttributeType> ATTRIBUTE_SHORTHANDS = new HashMap<>();
    static {
        ATTRIBUTE_SHORTHANDS.put("ag", AttributeTypes.AGILITY);
        ATTRIBUTE_SHORTHANDS.put("df", AttributeTypes.DEFENSE);
        ATTRIBUTE_SHORTHANDS.put("in", AttributeTypes.INTELLIGENCE);
        ATTRIBUTE_SHORTHANDS.put("ch", AttributeTypes.CHARISMA);
        ATTRIBUTE_SHORTHANDS.put("ws", AttributeTypes.WISDOM);
        ATTRIBUTE_SHORTHANDS.put("wp", AttributeTypes.WILLPOWER);
        ATTRIBUTE_SHORTHANDS.put("pc", AttributeTypes.PERCEPTION);
        ATTRIBUTE_SHORTHANDS.put("lk", AttributeTypes.LUCK);
        ATTRIBUTE_SHORTHANDS.put("ct", AttributeTypes.CONSTITUTION);
        ATTRIBUTE_SHORTHANDS.put("st", AttributeTypes.STRENGTH);
    }

    private String seed;

    private String separator;

    private Map<AttributeType, Double> result;

    public PredictableAttributeGenerator(String seed, String separator) {
        this.seed = seed;
        this.separator = separator;
    }

    @Override
    public Map<AttributeType, Double> get() {
        if (result != null) {
            return result;
        }

        result = new HashMap<>();

        String[] tokens = seed.split(separator);

        for (String token : tokens) {
            AttributeType type = ATTRIBUTE_SHORTHANDS.get(token.substring(0, 2));
            Double value = Double.valueOf(token.substring(2));

            result.put(type, value);
        }

        return result;
    }
}
