package dbus._2.firstProductionIssue.type;

public enum C {
    INSTANCE;

    public D createD() {
        return D.INSTANCE;
    }
}
