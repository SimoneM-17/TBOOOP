package tbooop.view.api;

import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Represents an empty view component.
 */
public abstract class ViewComponent {

    private final Group root;
    private final ViewElements view;

    /**
     * Constructs a new ViewComponent and attaches it to the main view's root.
     * 
     * @param view the main view
     */
    public ViewComponent(final ViewElements view) {
        this.view = view;
        this.root = new Group();
        view.getRoot().getChildren().add(root);
    }

    /**
     * Adds a node to the root of this ViewComponent.
     * 
     * @param node the node to attach to this component's root
     */
    public void addToRoot(final Node node) {
        this.root.getChildren().add(node);
    }

    /**
     * Returns the main view associated with this ViewComponent.
     * 
     * @return the main view
     */
    public ViewElements getView() {
        return view;
    }

    /**
     * To update ViewComponent.
     */
    public abstract void update();

}
