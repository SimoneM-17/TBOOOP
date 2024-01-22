package tbooop.model.pickupables.pickups.impl;

import java.util.List;
import java.util.Random;
import java.util.Arrays;
import tbooop.commons.Point2d;
import tbooop.model.core.api.GameTag;
import tbooop.model.pickupables.api.Pickupable;

/**
 * Class implementing logic for pickups
 * generations in the game.
 * A pickup will spawn when a standard
 * room is visited and the player
 * defeats every enemy.
 */
public class PickupsLogic {

    private final Point2d location = new Point2d(2.0, 2.0);
    private static final int PICKUPS_NUMBER = 3;
    private final List<Pickupable> list = Arrays.asList(new Coin(this.location, 2.0, GameTag.PICKUP), 
                                                new Heart(this.location, 2.0, GameTag.PICKUP),
                                                new Key(this.location, 2.0, GameTag.PICKUP));
    private final Random random = new Random();

    /**
     * Return a random Pickupable.
     * 
     * @return a random Pickupable
     */
    public Pickupable getRandomPickup() {
        return list.get(random.nextInt(PICKUPS_NUMBER));
    }
}
