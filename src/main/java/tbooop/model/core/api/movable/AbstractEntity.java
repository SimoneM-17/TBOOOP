package tbooop.model.core.api.movable;

import tbooop.commons.api.Point2d;
import tbooop.commons.api.Projectile;
import tbooop.commons.api.Health;
import tbooop.model.core.api.GameTag;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Entity is an abstraction of anything that is Damageable and Movable in the
 * game.
 * Every object can take damage and can move must extends this abstact class.
 */
public abstract class AbstractEntity extends AbstractDamageable implements Entity {

    private final Set<Projectile> shotProjectiles = new HashSet<>();

    /**
     * Create a new istance of an Entity.
     * 
     * @param position      starting position
     * @param health the entity's health
     * @param velocity      it is the Entity velocity
     * @param tag specifies the type of entity
     * @throws NullPointerException if any parameter is null
     */
    protected AbstractEntity(final Point2d position, final Health health,
    final double velocity, final GameTag tag) {
        super(position, health, velocity, tag);
    }

    /**
     * Returns the latest projectiles that have been shot. 
     * 
     * @return the set of projectiles
     */
    @Override
    public Set<Projectile> getShotProjectiles() {
        return new HashSet<>(this.shotProjectiles);
    }

    /**
     * Adds a projectile in the set shotProjectiles.
     * @param projectile the projectile to add in the set.
     * @throws NullPointerException if the projectile is null.
     */
    protected void addProjectile(final Projectile projectile) {
        this.shotProjectiles.add(Objects.requireNonNull(projectile));
    }

    /**
     * Clear the set shotProjectiles.
     */
    protected void removeProjectiles() {
        this.shotProjectiles.clear();
    }
}
