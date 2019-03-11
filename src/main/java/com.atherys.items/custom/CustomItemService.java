package com.atherys.items.custom;

import com.atherys.items.util.ItemStackUtils;
import com.google.inject.Singleton;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.*;

@Singleton
public class CustomItemService {

    private Map<String, CustomItem> customItems = new HashMap<>();

    public void registerCustomItem(CustomItem item) {
        customItems.put(item.getId(), item);
    }

    public void registerCustomItems(List<CustomItem> items) {
        items.forEach(this::registerCustomItem);
    }

    public Optional<CustomItem> getCustomItem(String id) {
        return Optional.ofNullable(customItems.get(id));
    }

    public ItemStack getItemStack(CustomItem customItem) {
        ItemStack stack = ItemStack.of(customItem.getItemType(), customItem.getQuantity());

        ItemStackUtils.setItemStackName(stack, customItem.getName());
        ItemStackUtils.setItemStackLore(stack, customItem.getLore());
        ItemStackUtils.setItemStackDurability(stack, customItem.getDurability());
        ItemStackUtils.setItemStackEnchantments(stack, getEnchantments(customItem.getEnchantments()));
        ItemStackUtils.setItemStackAttributes(stack, customItem.getAttributes());

        return stack;
    }

    private List<Enchantment> getEnchantments(Map<EnchantmentType, Integer> enchantments) {
        List<Enchantment> result = new ArrayList<>();
        enchantments.forEach((k,v) -> result.add(Enchantment.of(k, v)));
        return result;
    }

}
