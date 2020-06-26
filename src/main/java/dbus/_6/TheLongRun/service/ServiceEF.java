package dbus._6.TheLongRun.service;

import dbus._6.TheLongRun.type.E;
import dbus._6.TheLongRun.type.F;

public class ServiceEF {

    private final boolean nullF;

    public ServiceEF(boolean nullF) {
        this.nullF = nullF;
    }

    public F serviceEF(E e) {
        if(nullF)
            return null;
        return F.INSTANCE;
    }

}
