package dbus.type;

public enum A {
    INSTANCE;

    public B next() {
        return B.INSTANCE;
    }
}
