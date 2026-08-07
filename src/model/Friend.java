package model;

/**
 * A friend in the Splitwise group with a unique id and display name.
 */
public class Friend {
    private static int lastId = 0;
    private final int id;
    private final String name;

    /**
     * Creates a friend with the given name and assigns the next available id.
     * @param name the friend's display name
     */
    public Friend(String name) {
        lastId++;
        this.id = lastId;
        this.name = name;
    }

    /**
     * @return this friend's unique id
     */
    public int getId() {
        return id;
    }

    /**
     * @return this friend's display name
     */
    public String getName() {
        return name;
    }
}