package com.atherys.items.command;

import com.atherys.core.command.ParameterizedCommand;
import com.atherys.core.command.PlayerCommand;
import com.atherys.core.command.annotation.Aliases;
import com.atherys.items.AtherysItems;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.serializer.TextSerializers;

import javax.annotation.Nonnull;

/**
 * /items generate [FLAG]...
 * -n : name, the name to be set on the item. Overrides -p. If not specified, see -p.<br>
 * -p : pool, the pool of names to be used. "none" if you do not wish a custom generated name on the item.<br>
 *      If no name pool is specified, the item type will be used as a pool instead.<br>
 *      If no such pool exists, the item will have it's default item name.<br>
 * -t : type, the type of the item you want generated.<br>
 *      Must be specified.<br>
 * -q : quantity, the size of the stack of item(s) you want generated.<br>
 *      The default is 1.<br>
 * -f : formatting, the formatting to be applied to the item's full name after assembly. Uses formatting codes.<br>
 *      If none is specified, no formatting will be applied to the item name.<br>
 * -e : enchants, the enchants of to put on the item.<br>
 *      // TODO: Further details<br>
 * -a : attributes, the attributes to put on the items in the form of a special format seed string.<br>
 *      Each attribute type has a shorthand mapping, and you can specify multiple attributes by<br>
 *      separating them with a dash character ( "-" ).<br>
 *      Example usage: "-a ws6-st7-ch18" ( Wisdom 6, Strength 7, Charisma 18 )<br>
 *      Map of all shorthands: <br>
 *      ag - Agility<br>
 *      df - Defense<br>
 *      in - Intelligence<br>
 *      ch - Charisma<br>
 *      ws - Wisdom<br>
 *      wp - Willpower<br>
 *      pc - Perception<br>
 *      lk - Luck<br>
 *      ct - Constitution<br>
 *      st - Strength<br>
 * -d : durability, the durability the item should start with.<br>
 *      The default is the maximum item durability.<br>
 */
@Aliases("generate")
public class GenerateItemCommand implements PlayerCommand, ParameterizedCommand {
    @Nonnull
    @Override
    public CommandResult execute(@Nonnull Player source, @Nonnull CommandContext args) throws CommandException {
        return AtherysItems.getInstance().getCustomItemFacade().generateItem(
                args.getOne("name").orElse(""),
                args.getOne("pool").orElse(""),
                args.getOne("type").orElse(""),
                args.getOne("quantity").orElse(1),
                args.getOne("formatting").orElse(TextFormat.NONE),
                args.getOne("enchants").orElse(""),
                args.getOne("attributes").orElse(""),
                args.getOne("durability").orElse(-1)
        );
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[] {
                GenericArguments.flags()
                        .valueFlag(GenericArguments.string(Text.of("name")), "n")
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
