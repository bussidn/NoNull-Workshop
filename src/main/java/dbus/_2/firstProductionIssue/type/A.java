package dbus._2.firstProductionIssue.type;

public enum A {
    VALID_INSTANCE, NON_VALID_INSTANCE;

    public B requestB() {
        if(this.equals(VALID_INSTANCE))
            return B.INSTANCE;
            else
                return null;
    }
}
