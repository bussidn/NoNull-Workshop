package dbus._1.theJoyFulDays;

import dbus._1.theJoyFulDays.type.A;
import dbus._1.theJoyFulDays.type.G;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    @Test
    public void application_should_return_G_when_provided_A() {
        // given
        Application application = new Application();
        A a = A.INSTANCE;

        // when
        G result = application.run(a);

        // then
        assertThat(result).isEqualTo(G.INSTANCE);
    }

}