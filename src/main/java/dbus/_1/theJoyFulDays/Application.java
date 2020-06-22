package dbus._1.theJoyFulDays;

import dbus._1.theJoyFulDays.service.*;
import dbus._1.theJoyFulDays.type.*;

import java.util.function.Function;

public class Application {

    private final Function<A, B> serviceAB;
    private final Function<B, C> serviceBC;
    private final Function<C, D> serviceCD;
    private final Function<D, E> serviceDE;
    private final Function<E, F> serviceEF;
    private final Function<F, G> serviceFG;


    Application() {
        serviceAB = new ServiceAB()::serviceAB;
        serviceBC = new ServiceBC()::serviceBC;
        serviceCD = new ServiceCD()::serviceCD;
        serviceDE = new ServiceDE()::serviceDE;
        serviceEF = new ServiceEF()::serviceEF;
        serviceFG = new ServiceFG()::serviceFG;
    }

    G run(A providedA) {
        return serviceAB
                .andThen(serviceBC)
                .andThen(serviceCD)
                .andThen(serviceDE)
                .andThen(serviceEF)
                .andThen(serviceFG)
                .apply(providedA);
    }
}
