package com.atherys.items.util;

import com.atherys.rpg.AtherysRPG;
import com.atherys.rpg.api.stat.AttributeType;
import com.atherys.rpg.data.AttributeData;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemStackUtils {

    private static Text render(String formattedText) {
        return TextSerializers.FORMATTING_CODE.deserialize(formattedText);
    }

    public static void setItemStackName(ItemStack itemStack, String formattedName) {
        itemStack.offer(Keys.DISPLAY_NAME, render(formattedName));
    }

    public static void setItemStackLore(ItemStack itemStack, List<String> formattedLore) {
        List<Text> textLore = new ArrayList<>();
        formattedLore.forEach(line -> textLore.add(render(line)));
        itemStack.offer(Keys.ITEM_LORE, textLore);
    }

    public static void setItemStackDurability(ItemStack itemStack, int durability) {
        itemStack.offer(Keys.ITEM_DURABILITY, durability);
    }

    public static void setItemStackAttributes(ItemStack itemStack, Map<AttributeType, Double> attributes) {
        if (attributes.isEmpty()) {
            return;
        }

        AttributeData data = itemStack.get(AttributeData.class).orElseGet(AttributeData::new);
        attributes.forEach(data::setAttribute);

        if (itemStack.offer(data).isSuccessful() && itemStack.get(AttributeData.class).isPresent()) {
            AtherysRPG.getInstance().getAttributeFacade().updateItemLore(itemStack);
        }
    }

    public static void setItemStackEnchantments(ItemStack itemStack, List<Enchantment> enchantments) {
        itemStack.offer(Keys.ITEM_ENCHANTMENTS, enchantments);
    }

}
