package dbus.type;

public enum C {
    INSTANCE;

    public D createD() {
        return D.INSTANCE;
    }
}
