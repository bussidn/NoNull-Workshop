package dbus.type;

public enum A {
    INSTANCE;

    public B requestB() {
        return B.INSTANCE;
    }
}
