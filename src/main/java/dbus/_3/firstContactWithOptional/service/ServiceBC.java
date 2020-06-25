package dbus._3.firstContactWithOptional.service;

import dbus._3.firstContactWithOptional.type.B;
import dbus._3.firstContactWithOptional.type.C;

public class ServiceBC {

    public C serviceBC(B b) {
        return C.INSTANCE;
    }

}
