package models;

import exceptions.DAGConstraintException;

import java.util.HashSet;
import java.util.List;

/**
 * Represents a coordinate system.
 */
public class Origin extends Point{
    private Space parent;
    private List<? extends Point> children;
    private BoundBox bounds;

    public Origin(double x, double y, Space parent) {
        super(x, y);
        this.parent = parent;
        this.bounds = new BoundBox(this);
    }

    /***
     * Gets all the children (Points and Origins).
     * @return A unique collection of contained points and origins.
     */
    public List<? extends Point> getChildren(){
        return children;
    }

    /**
     * Sets the children of the current origin and checks for cycles.
     * @param newChildren The new children collection.
     * @throws DAGConstraintException if a cycle is found.
     */
    public void setChildren(List<? extends Point> newChildren) throws DAGConstraintException {
        var newChildrenSet = new HashSet<Point>(newChildren);

        if(newChildrenSet.size() != newChildren.size()){
            throw new DAGConstraintException();
        }

        children = newChildren;

        if(containsCycle(parent.getOrigin())){
            throw new DAGConstraintException();
        }
     }

    /**
     * Gets the bounds of all points in the given or child graphs.
     * @return A <i>BoundBox</i> object containing information about the bounds of the current
     * graph and its subgraphs.
     */
     public BoundBox getBounds(){
        return bounds;
     }

     private Boolean containsCycle(Origin origin){
         origin.isChecked = true;

         for (var child : origin.getChildren()){
             if(child.isChecked){
                 return true;
             }else {
                 child.isChecked = true;

                 if(child instanceof Origin){
                     return containsCycle((Origin) child);
                 }
             }
         }

         return false;
     }
}
