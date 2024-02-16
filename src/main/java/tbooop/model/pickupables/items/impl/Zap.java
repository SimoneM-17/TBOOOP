package tbooop.model.pickupables.items.impl;

import tbooop.commons.api.Point2d;
import tbooop.model.core.api.GameTag;
import tbooop.model.pickupables.api.PickupableName;
import tbooop.model.pickupables.items.api.ItemAbs;
import tbooop.model.player.api.Player;
/**
 * Class rapresenting "the Zap" item in the
 * game. If picked up by the player, it
 * will increase its velocity of a
 * determined amount.
 */
public class Zap extends ItemAbs {

    private static final double VELOCITY_TO_INCREASE = 0.02;

    /**
     * Create a new istance of the Zap item.
     * 
     * @param position       spawn position (as a Point2d)
     * @param colliderRadius radius of the circle collider (hitbox).
     *                       The center of the collider will be this game object's
     *                       position
     * @param tag            the tag of this game object
     * @param itemCost       cost of this item
     * @param pickupTag      name of this item
     * @throws NullPointerException if any parameter passed is null
     */
    protected Zap(final Point2d position, 
                        final double colliderRadius, 
                        final GameTag tag,
                        final int itemCost,
                        final PickupableName pickupTag) {
        super(position, colliderRadius, tag, itemCost, pickupTag);
    }

    /**
     * When the Zap is picked up
     * by the player, its velocity will
     * be increased.
     * 
     * @param player
    */
    @Override
    protected void onPickup(final Player player) {
        player.increaseVelocity(VELOCITY_TO_INCREASE);
        destroy();
    }
}
