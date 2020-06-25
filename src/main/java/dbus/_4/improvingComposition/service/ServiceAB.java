package dbus._4.improvingComposition.service;

import dbus._4.improvingComposition.type.A;
import dbus._4.improvingComposition.type.B;

import java.util.Optional;

public class ServiceAB {

    public Optional<B> serviceAB(A a) {
        if(a.equals(A.VALID_INSTANCE))
            return Optional.of(B.INSTANCE);
            else
                return Optional.empty();
    }

}
