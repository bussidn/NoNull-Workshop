package dbus._5.service;

import dbus._5.type.A;
import dbus._5.type.B;

import java.util.Optional;

public class ServiceAB {

    public Optional<B> serviceAB(A a) {
        if(a.equals(A.VALID_INSTANCE))
            return Optional.of(B.INSTANCE);
            else
                return Optional.empty();
    }

}
