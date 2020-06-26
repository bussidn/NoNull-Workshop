package dbus._6.TheLongRun.service;

import dbus._6.TheLongRun.type.A;
import dbus._6.TheLongRun.type.B;

public class ServiceAB {

    private final boolean nullB;

    public ServiceAB(boolean nullB) {
        this.nullB = nullB;
    }

    public B serviceAB(A a) {
        if (nullB)
            return null;
        return B.INSTANCE;
    }

}
