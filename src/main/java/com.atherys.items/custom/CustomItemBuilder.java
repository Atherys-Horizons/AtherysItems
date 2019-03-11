package com.atherys.items.custom;

import com.atherys.rpg.api.stat.AttributeType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomItemBuilder {

    private String id;

    private ItemType itemType;

    private int quantity;

    private int durability;

    private String name;

    private List<String> lore = new ArrayList<>();

    private Map<EnchantmentType, Integer> enchantments = new HashMap<>();

    private Map<AttributeType, Double> attributes = new HashMap<>();

    public CustomItemBuilder id(String id) {
        this.id = id;
        return this;
    }

    public CustomItemBuilder itemType(ItemType itemType) {
        this.itemType = itemType;
        return this;
    }

    public CustomItemBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public CustomItemBuilder durability(int startingDurability) {
        this.durability = startingDurability;
        return this;
    }

    public CustomItemBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomItemBuilder lore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public CustomItemBuilder enchantments(List<Enchantment> enchantments) {
        enchantments.forEach(this::enchantment);
        return this;
    }

    public CustomItemBuilder enchantments(Map<EnchantmentType, Integer> enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    public CustomItemBuilder enchantment(Enchantment enchantment) {
        this.enchantments.put(enchantment.getType(), enchantment.getLevel());
        return this;
    }

    public CustomItemBuilder enchantment(EnchantmentType enchantmentType, int level) {
        this.enchantments.put(enchantmentType, level);
        return this;
    }

    public CustomItemBuilder attributes(Map<AttributeType, Double> attributes) {
        this.attributes = attributes;
        return this;
    }

    public CustomItemBuilder attribute(AttributeType type, Double amount) {
        this.attributes.put(type, amount);
        return this;
    }

    public CustomItem build() {
        return new CustomItem(id, itemType, quantity, durability, name, lore, enchantments, attributes);
    }
}
