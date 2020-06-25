package dbus._2.firstProductionIssue.service;

import dbus._2.firstProductionIssue.type.A;
import dbus._2.firstProductionIssue.type.B;

public class ServiceAB {

    public B serviceAB(A a) {
        if(a.equals(A.VALID_INSTANCE))
            return B.INSTANCE;
            else
                return null;
    }

}
