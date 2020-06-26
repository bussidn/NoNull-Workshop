package dbus._6.TheLongRun.service;

import dbus._6.TheLongRun.type.C;
import dbus._6.TheLongRun.type.B;

public class ServiceBC {

    private final boolean nullC;

    public ServiceBC(boolean nullC) {
        this.nullC = nullC;
    }

    public C serviceBC(B b) {
        if (nullC)
            return null;
        return C.INSTANCE;
    }

}
