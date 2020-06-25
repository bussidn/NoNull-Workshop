package dbus._3.firstContactWithOptional.service;

import dbus._3.firstContactWithOptional.type.A;
import dbus._3.firstContactWithOptional.type.B;

public class ServiceAB {

    public B serviceAB(A a) {
        return a.requestB();
    }

}
