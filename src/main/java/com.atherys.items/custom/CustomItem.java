package com.atherys.items.custom;

import com.atherys.rpg.api.stat.AttributeType;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.Enchantment;

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
    private int startingDurability;

    @Setting("name")
    private String name;

    @Setting("lore")
    private List<String> lore = new ArrayList<>();

    @Setting("enchantments")
    private List<Enchantment> enchantments = new ArrayList<>();

    @Setting("attributes")
    private Map<AttributeType, Double> attributes = new HashMap<>();

    public CustomItem() {
    }

    protected CustomItem(
            String id,
            ItemType itemType,
            int quantity,
            int startingDurability,
            String name,
            List<String> lore,
            List<Enchantment> enchantments,
            Map<AttributeType, Double> attributes
    ) {
        this.id = id;
        this.itemType = itemType;
        this.quantity = quantity;
        this.startingDurability = startingDurability;
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

    public int getStartingDurability() {
        return startingDurability;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    public List<Enchantment> getEnchantments() {
        return enchantments;
    }

    public Map<AttributeType, Double> getAttributes() {
        return attributes;
    }
}
