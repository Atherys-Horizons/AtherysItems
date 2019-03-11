package com.atherys.items.command;

import com.atherys.core.command.ParameterizedCommand;
import com.atherys.core.command.PlayerCommand;
import com.atherys.core.command.annotation.Aliases;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

import javax.annotation.Nonnull;

/**
 * /items generate [FLAG]...
 * -p : pool, the pool of names to be used. "none" if you do not wish a custom generated name on the item.
 *      If no name pool is specified, the item type will be used as a pool instead.
 *      If no such pool exists, the item will be nameless.
 * -t : type, the type of the item you want generated.
 *      Must be specified.
 * -q : quantity, the size of the stack of item(s) you want generated.
 *      The default is 1.
 * -f : formatting, the formatting to be applied to the item's full name after assembly. Uses formatting codes.
 *      If none is specified, no formatting will be applied to the item name.
 * -e : enchants, the enchants of to put on the item.
 *      // TODO: Further details
 * -a : attributes, the attributes to put on the items.
 *      // TODO: Further details
 * -d : durability, the durability the item should start with.
 *      The default is the maximum item durability.
 */
@Aliases("generate")
public class GenerateItemCommand implements PlayerCommand, ParameterizedCommand {
    @Nonnull
    @Override
    public CommandResult execute(@Nonnull Player source, @Nonnull CommandContext args) throws CommandException {
        return null;
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[] {
                GenericArguments.flags()
                        .valueFlag(GenericArguments.string(Text.of("pool")), "p")
                        .valueFlag(GenericArguments.catalogedElement(Text.of("type"), ItemType.class), "t")
                        .valueFlag(GenericArguments.integer(Text.of("quantity")), "q")
                        .valueFlag(GenericArguments.text(Text.of("formatting"), TextSerializers.FORMATTING_CODE, false), "f")
                        .valueFlag(GenericArguments.integer(Text.of("enchants")), "e")
                        .valueFlag(GenericArguments.integer(Text.of("attributes")), "a")
                        .valueFlag(GenericArguments.integer(Text.of("durability")), "d")
                        .buildWith(GenericArguments.none()),
        };
    }
}
