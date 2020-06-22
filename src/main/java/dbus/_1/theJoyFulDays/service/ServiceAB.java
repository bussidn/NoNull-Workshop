package dbus._1.theJoyFulDays.service;

import dbus.type.A;
import dbus.type.B;

public class ServiceAB {

    public B serviceAB(A a) {
        return a.requestB();
    }

}
