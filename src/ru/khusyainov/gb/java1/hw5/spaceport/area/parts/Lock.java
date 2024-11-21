package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

public class Lock {
    private Door door;
    private final Key key;
    private boolean locked;

    public Lock(Door door, Key key) {
        this.door = door;
        this.key = key;
        locked = false;
    }

    public Lock(Key key) {
        this.key = key;
        locked = false;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public boolean isLocked() {
        return locked;
    }

    private boolean setLocked(Key key, boolean locked) {
        if (this.locked == locked || this.key.equals(key)) {
            System.out.println("Замок " + (this.locked ? "за" : "от") + "крыт.");
            this.locked = locked;
            return true;
        }
        System.out.println("Ключ не подходит к этому замку.");
        return false;
    }

    public boolean unlock(Key key) {
        return setLocked(key, false);
    }

    public boolean lock(Key key) {
        return setLocked(key, true);
    }

    @Override
    public String toString() {
        return "Lock{" +
                "door=" + door +
                ", locked=" + locked +
                '}';
    }
}
