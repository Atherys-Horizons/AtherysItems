package com.atherys.items.custom;

import com.atherys.rpg.api.stat.AttributeType;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.EnchantmentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigSerializable
public class CustomItem {

    @Setting("id")
    private String id;

    @Setting("type")
    private ItemType itemType;

    @Setting("quantity")
    private int quantity;

    @Setting("durability")
    private int durability;

    @Setting("name")
    private String name;

    @Setting("lore")
    private List<String> lore = new ArrayList<>();

    @Setting("enchantments")
    private Map<EnchantmentType, Integer> enchantments = new HashMap<>();

    @Setting("attributes")
    private Map<AttributeType, Double> attributes = new HashMap<>();

    public CustomItem() {
    }

    protected CustomItem(
            String id,
            ItemType itemType,
            int quantity,
            int durability,
            String name,
            List<String> lore,
            Map<EnchantmentType, Integer> enchantments,
            Map<AttributeType, Double> attributes
    ) {
        this.id = id;
        this.itemType = itemType;
        this.quantity = quantity;
        this.durability = durability;
        this.name = name;
        this.lore = lore;
        this.enchantments = enchantments;
        this.attributes = attributes;
    }

    public static CustomItemBuilder builder() {
        return new CustomItemBuilder();
    }

    public String getId() {
        return id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDurability() {
        return durability;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    public Map<EnchantmentType, Integer> getEnchantments() {
        return enchantments;
    }

    public Map<AttributeType, Double> getAttributes() {
        return attributes;
    }
}
