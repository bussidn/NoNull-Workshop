package dbus._6.TheLongRun;


import dbus._6.TheLongRun.type.A;
import dbus._6.TheLongRun.type.G;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {


    @Test
    public void application_should_return_G_when_provided_Application_does_not_have_any_null_in_its_call_sequence() {
        // given
        Application application = Application.passingApplication();
        A a = A.INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo(G.INSTANCE.toString());
    }

    @Test
    public void application_should_return_not_found_message_when_serviceAB_returns_a_null_B() {
        // given
        Application application = Application.with(Application.Builder::withNullB);
        A a = A.INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo("G cannot be found");
    }

    @Test
    public void application_should_return_not_found_message_when_serviceBC_returns_a_null_C() {
        // given
        Application application = Application.with(Application.Builder::withNullC);
        A a = A.INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo("G cannot be found");
    }

    @Test
    public void application_should_return_not_found_message_when_serviceCD_returns_a_null_D() {
        // given
        Application application = Application.with(Application.Builder::withNullD);
        A a = A.INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo("G cannot be found");
    }

    @Test
    public void application_should_return_not_found_message_when_serviceEF_returns_a_null_F() {
        // given
        Application application = Application.with(Application.Builder::withNullF);
        A a = A.INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo("G cannot be found");
    }

    @Test
    public void application_should_return_not_found_message_when_serviceFG_returns_a_null_G() {
        // given
        Application application = Application.with(Application.Builder::withNullG);
        A a = A.INSTANCE;

        // when
        String result = application.run(a);

        // then
        assertThat(result).isEqualTo("G cannot be found");
    }

}