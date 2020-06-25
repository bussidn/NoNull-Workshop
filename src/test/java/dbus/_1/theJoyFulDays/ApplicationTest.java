package dbus._1.theJoyFulDays;

import dbus._1.theJoyFulDays.type.A;
import dbus._1.theJoyFulDays.type.G;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    @Nested
    public class _1TheJoyfulDays {

        @Test
        public void application_should_return_G_when_provided_A() {
            // given
            Application application = new Application();
            A a = A.INSTANCE;

            // when
            String result = application.run(a);

            // then
            assertThat(result).isEqualTo(G.INSTANCE.toString());
        }

        @Test
        public void application_should_return_G_when_provided_A_when_calling_the_more_familiar_version() {
            // given
            Application application = new Application();
            A a = A.INSTANCE;

            // when
            String result = application.moreFamiliarRun(a);

            // then
            assertThat(result).isEqualTo(G.INSTANCE.toString());
        }
    }

}