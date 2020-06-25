package dbus._4.improvingComposition;

import dbus._4.improvingComposition.service.*;
import dbus._4.improvingComposition.type.*;

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
        Optional<B> bContainer = serviceAB.apply(providedA);
        if (bContainer.isPresent()) {
            C c = serviceBC.apply(bContainer.get());
            D d = serviceCD.apply(c);
            E e = serviceDE.apply(d);
            F f = serviceEF.apply(e);
            return serviceFG.apply(f).toString();
        } else
            return "G cannot be found";
    }
}
