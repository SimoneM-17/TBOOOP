package tbooop.model.pickupables.items.impl;

import java.util.List;
import tbooop.commons.Point2dImpl;
import tbooop.commons.api.Point2d;
import tbooop.model.core.api.GameTag;
import tbooop.model.pickupables.items.api.Items;

/**
 * Class implementing item's room logic
 * in the game.
 * It will be used to get a random item
 * to spawn there.
 */
public class ItemRoomLogic {
    private final Point2d location = new Point2dImpl(1.0, 1.0);
    private static final double ITEM_COLLIDER_RADIUS = 1.0;
    private static final double GOLDENHEART_PROB = 0.1;
    private static final double ANOTHERITEM_PROB = 0.3;
    private final List<Items> itemsList = List.of(new GoldenHeart(location, ITEM_COLLIDER_RADIUS, GameTag.PICKUP));

    /**
     * Compute the chances every item has
     * to spawn.
     * 
     * @param randomNumber
     * @return an Integer from 0 to
     * the max number of Items.
     */
    private int getChanceToSpawn(final double randomNumber) {
        if (randomNumber <= GOLDENHEART_PROB) {
            return 0;
        } else if (randomNumber > GOLDENHEART_PROB && randomNumber <= ANOTHERITEM_PROB) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Return a random Item to spawn.
     * Every item has a certain chance
     * to be chosen.
     * 
     * @return a random Item.
     */
    public Items getRandomItem() {
        final double randomNumber = Math.random();
        final int itemIndex = getChanceToSpawn(randomNumber);
        return itemsList.get(itemIndex);
    }
}
