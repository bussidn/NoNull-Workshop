package dbus._2.firstProductionIssue;

import dbus._2.firstProductionIssue.service.*;
import dbus._2.firstProductionIssue.type.*;

import java.util.function.Function;

public class Application {

    private final Function<A, B> serviceAB;
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
        B b = serviceAB.apply(providedA);
        C c = serviceBC.apply(b);
        D d = serviceCD.apply(c);
        E e = serviceDE.apply(d);
        F f = serviceEF.apply(e);
        return serviceFG.apply(f).toString();
    }

    public String correctedRun(A providedA) {
        B b = serviceAB.apply(providedA);
        if (b != null) {
            C c = serviceBC.apply(b);
            D d = serviceCD.apply(c);
            E e = serviceDE.apply(d);
            F f = serviceEF.apply(e);
            return serviceFG.apply(f).toString();
        } else
            return "G cannot be found";
    }
}
