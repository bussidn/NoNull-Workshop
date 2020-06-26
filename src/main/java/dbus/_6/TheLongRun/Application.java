package dbus._6.TheLongRun;

import dbus._6.TheLongRun.service.*;
import dbus._6.TheLongRun.type.*;

import java.util.function.Function;

public class Application {

    private final Function<A, B> serviceAB;
    private final Function<B, C> serviceBC;
    private final Function<C, D> serviceCD;
    private final Function<D, E> serviceDE;
    private final Function<E, F> serviceEF;
    private final Function<F, G> serviceFG;

    public Application(Function<A, B> serviceAB, Function<B, C> serviceBC, Function<C, D> serviceCD,
                       Function<D, E> serviceDE, Function<E, F> serviceEF, Function<F, G> serviceFG) {
        this.serviceAB = serviceAB;
        this.serviceBC = serviceBC;
        this.serviceCD = serviceCD;
        this.serviceDE = serviceDE;
        this.serviceEF = serviceEF;
        this.serviceFG = serviceFG;
    }

    public String run(A providedA) {
        return "G cannot be found";
    }

    public static class Builder {
        public boolean nullB = false;
        public boolean nullC = false;
        public boolean nullD = false;
        public boolean nullF = false;
        public boolean nullG = false;

        public Application.Builder withNullB() {
            this.nullB = true;
            return this;
        }

        public Application.Builder withNullC() {
            this.nullC = true;
            return this;
        }

        public Application.Builder withNullD() {
            this.nullD = true;
            return this;
        }

        public Application.Builder withNullF() {
            this.nullF = true;
            return this;
        }

        public Application.Builder withNullG() {
            this.nullG = true;
            return this;
        }

        public Application build() {
            return new Application(
                    new ServiceAB(nullB)::serviceAB,
                    new ServiceBC(nullC)::serviceBC,
                    new ServiceCD(nullD)::serviceCD,
                    new ServiceDE()::serviceDE,
                    new ServiceEF(nullF)::serviceEF,
                    new ServiceFG(nullG)::serviceFG
            );
        }
    }
}
