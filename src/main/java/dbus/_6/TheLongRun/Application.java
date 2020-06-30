package dbus._6.TheLongRun;

import dbus._6.TheLongRun.service.*;
import dbus._6.TheLongRun.type.*;

import java.util.Optional;
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
        B b = serviceAB.apply(providedA);
        if(b != null) {
            C c = serviceBC.apply(b);
            if(c != null) {
                D d = serviceCD.apply(c);
                if(d != null) {
                    E e = serviceDE.apply(d);
                    if(e != null) {
                        F f = serviceEF.apply(e);
                        if(f !=  null) {
                            G g = serviceFG.apply(f);
                            if(g != null)
                                return g.toString();
                        }
                    }
                }
            }
        }
        return "G cannot be found";
    }

    public static Application with(Function<Builder, Builder> config) {
        return config.apply(Application.builder()).build();
    }

    static Application passingApplication() {
        return builder().build();
    }

    public static Builder builder() {
        return new Builder();
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

    public static <T> Optional<T> flatten(@SuppressWarnings("OptionalUsedAsFieldOrParameterType") Optional<Optional<T>> nested) {
        return nested.orElseGet(Optional::empty);
    }
}
