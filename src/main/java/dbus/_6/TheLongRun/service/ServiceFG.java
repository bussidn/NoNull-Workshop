package dbus._6.TheLongRun.service;

import dbus._6.TheLongRun.type.F;
import dbus._6.TheLongRun.type.G;

public class ServiceFG {

    private final boolean nullG;

    public ServiceFG(boolean nullG) {
        this.nullG = nullG;
    }

    public G serviceFG(F f) {
        if(nullG)
            return null;
        return G.INSTANCE;
    }

}
