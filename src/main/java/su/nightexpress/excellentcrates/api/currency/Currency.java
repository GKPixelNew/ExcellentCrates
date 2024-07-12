package su.nightexpress.excellentcrates.api.currency;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.excellentcrates.Placeholders;
import su.nightexpress.nightcore.util.NumberUtil;
import su.nightexpress.nightcore.util.placeholder.AdvancedPlaceholder;

public interface Currency extends AdvancedPlaceholder {

    @NotNull
    default String formatValue(double amount) {
        return NumberUtil.format(amount);
    }

    @NotNull
    default String format(CommandSender sender, double amount) {
        return this.replacePlaceholders(sender).apply(this.getFormat()
            .replace(Placeholders.GENERIC_AMOUNT, this.formatValue(amount))
            .replace(Placeholders.GENERIC_NAME, this.getName())
        );
    }

    default double round(double amount) {
        return amount;
    }

    @NotNull CurrencyHandler getHandler();

    @NotNull String getId();

    @NotNull String getName();

    @NotNull String getFormat();
}
