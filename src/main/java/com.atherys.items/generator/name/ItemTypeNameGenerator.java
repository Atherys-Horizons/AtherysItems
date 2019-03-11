package com.atherys.items.generator.name;

import com.atherys.items.generator.Generator;
import org.spongepowered.api.item.ItemType;

public class ItemTypeNameGenerator implements Generator<String> {

    private ItemType itemType;

    public ItemTypeNameGenerator(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String get() {
        return itemType.getTranslation().get();
    }
}
