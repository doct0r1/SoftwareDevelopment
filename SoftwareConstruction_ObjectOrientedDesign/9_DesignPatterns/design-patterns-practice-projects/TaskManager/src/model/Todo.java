package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable {

    private String description;
    private List<Todo> subs;

    public Todo(String description) {
        super();
        this.description = description;
        subs = new LinkedList<>();
    }

    /**
     *
     * @param td the item we want to add to our subtodos
     * @return true if we are able to add the item with no duplicates, else false
     */
    public boolean addDoable(Todo td) {
        if (!subs.contains(td)) {
            subs.add(td);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param td the item we want to remove from our subtodos
     * @return true if we are able to remove the item from our subtodos, else false
     */
    public boolean removeDoable(Todo td) {
        if (subs.contains(td)) {
            subs.remove(td);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * This implementation differs from that of Task. All the subs must be
     * complete for the top-level to be completed.
     */
    @Override
    void setComplete() {
        boolean isAllDone = true;
        for (Doable d: subs) {
            if (!d.getStatus()) {
                isAllDone = false;
            }
        }
        complete = isAllDone;
    }

    @Override
    void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
        for (Doable d: subs) {
            d.display(indentSpace + indentSpace);
        }
    }
}