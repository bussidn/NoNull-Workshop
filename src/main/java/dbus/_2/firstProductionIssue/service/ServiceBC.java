package dbus._2.firstProductionIssue.service;

import dbus._2.firstProductionIssue.type.B;
import dbus._2.firstProductionIssue.type.C;

public class ServiceBC {

    public C serviceBC(B b) {
        return C.INSTANCE;
    }

}
