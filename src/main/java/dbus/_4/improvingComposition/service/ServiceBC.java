package dbus._4.improvingComposition.service;

import dbus._4.improvingComposition.type.B;
import dbus._4.improvingComposition.type.C;

public class ServiceBC {

    public C serviceBC(B b) {
        return C.INSTANCE;
    }

}
