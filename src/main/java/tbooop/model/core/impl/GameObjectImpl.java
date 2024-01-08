package tbooop.model.core.impl;

import tbooop.commons.CircleColliderImpl;
import tbooop.commons.Point2d;
import tbooop.commons.api.CircleCollider;
import tbooop.model.core.api.GameObject;
import tbooop.model.core.api.GameTag;

import java.util.Objects;

/**
 * A GameObject is an abstraction of anything that is present in the game.
 * Every class must estend it, directly or not.
 */
public abstract class GameObjectImpl implements GameObject {

    private Point2d position;
    private CircleCollider collider;
    private final double colliderRadius;
    private final GameTag tag;

    /**
     * Create a new istance of a GameObject.
     * 
     * @param position       starting position (as a {@link javafx.geometry.Point2D
     *                       Point2D})
     * @param colliderRadius radius of the circle collider (hitbox).
     *                       The center of the collider will be this game object's
     *                       position
     * @param tag            the tag of this game object
     * @throws NullPointerException if any parameter passed is null
     */
    protected GameObjectImpl(final Point2d position, final double colliderRadius, final GameTag tag) {
        this.position = Objects.requireNonNull(position);
        this.colliderRadius = colliderRadius;
        this.collider = new CircleColliderImpl(position, colliderRadius);
        this.tag = tag;
    }

    /** {@inheritDoc} */
    @Override
    public Point2d getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public void setPosition(final Point2d newPos) {
        this.position = Objects.requireNonNull(newPos);
        this.collider = new CircleColliderImpl(newPos, colliderRadius);
    }

    /** {@inheritDoc} */
    @Override
    public CircleCollider getCollider() {
        return this.collider;
    }

    /** {@inheritDoc} */
    @Override
    public GameTag getTag() {
        return this.tag;
    }

}
