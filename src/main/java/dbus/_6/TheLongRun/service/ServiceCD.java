package dbus._6.TheLongRun.service;

import dbus._6.TheLongRun.type.C;
import dbus._6.TheLongRun.type.D;

public class ServiceCD {

    private final boolean nullD;

    public ServiceCD(boolean nullD) {
        this.nullD = nullD;
    }

    public D serviceCD(C c) {
        if(nullD)
            return null;
        return D.INSTANCE;
    }

}
