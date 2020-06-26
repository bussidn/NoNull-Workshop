package dbus._5;

import dbus._5.service.*;
import dbus._5.type.*;

import java.util.Optional;
import java.util.function.Function;

public class Application {

    private final Function<A, Optional<B>> serviceAB;
    private final Function<B, C> serviceBC;
    private final Function<C, D> serviceCD;
    private final Function<D, E> serviceDE;
    private final Function<E, F> serviceEF;
    private final Function<F, G> serviceFG;


    public Application() {
        serviceAB = new ServiceAB()::serviceAB;
        serviceBC = new ServiceBC()::serviceBC;
        serviceCD = new ServiceCD()::serviceCD;
        serviceDE = new ServiceDE()::serviceDE;
        serviceEF = new ServiceEF()::serviceEF;
        serviceFG = new ServiceFG()::serviceFG;
    }

    public String run(A providedA) {
        return serviceAB.apply(providedA)
                .map(serviceBC)
                .map(serviceCD)
                .map(serviceDE)
                .map(serviceEF)
                .map(serviceFG)
                .map(Object::toString)
                .orElse("G cannot be found");
    }

    public String runWithOnlyOneMap(A providedA) {
        return serviceAB.apply(providedA)
                .map(serviceBC
                        .andThen(serviceCD)
                        .andThen(serviceDE)
                        .andThen(serviceEF)
                        .andThen(serviceFG)
                        .andThen(Object::toString))
                .orElse("G cannot be found");
    }
}
