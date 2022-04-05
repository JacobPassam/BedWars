package com.github.jacobpassam.bedwars.game.shop;

import lombok.Data;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Data
public class StackShopItem implements ShopItem {

    private final String name;
    private final CurrencialCost cost;

    private final ItemStack itemStack;

    public void purchase(Player player) {
        // todo redact, give
    }
}
