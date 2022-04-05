package com.github.jacobpassam.bedwars.game.upgrades;

import com.github.jacobpassam.bedwars.game.shop.ShopItem;

public interface Upgrade extends ShopItem {

    String getDescription();
    UpgradeLevel[] getLevels();

}
