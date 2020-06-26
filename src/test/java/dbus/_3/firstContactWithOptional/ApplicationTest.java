package dbus._3.firstContactWithOptional;

import dbus._3.firstContactWithOptional.type.A;
import dbus._3.firstContactWithOptional.type.G;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    @Test
    public void application_should_return_G_when_provided_A_is_valid() {
        // given
        Application application = new Application();
        A a = A.VALID_INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo(G.INSTANCE.toString());
    }

    @Test
    public void application_should_return_not_found_message_when_provided_A_is_not_valid() {
        // given
        Application application = new Application();
        A a = A.NON_VALID_INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo("G cannot be found");
    }

}