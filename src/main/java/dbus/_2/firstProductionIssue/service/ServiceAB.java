package dbus._2.firstProductionIssue.service;

import dbus._2.firstProductionIssue.type.A;
import dbus._2.firstProductionIssue.type.B;

public class ServiceAB {

    public B serviceAB(A a) {
        return a.requestB();
    }

}
