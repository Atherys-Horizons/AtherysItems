package com.atherys.items.custom;

import com.atherys.items.util.ItemStackUtils;
import com.google.inject.Singleton;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        ItemStackUtils.setItemStackDurability(stack, customItem.getStartingDurability());
        ItemStackUtils.setItemStackEnchantments(stack, customItem.getEnchantments());
        ItemStackUtils.setItemStackAttributes(stack, customItem.getAttributes());

        return stack;
    }

}
