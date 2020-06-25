package dbus._3.firstContactWithOptional;

import dbus._2.firstProductionIssue.Application;
import dbus._2.firstProductionIssue.type.A;
import dbus._2.firstProductionIssue.type.G;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {

    @Test
    public void application_should_return_G_when_provided_A_is_valid() {
        // given
        dbus._2.firstProductionIssue.Application application = new dbus._2.firstProductionIssue.Application();
        A a = A.VALID_INSTANCE;

        // when
        String result = application.correctedRun(a);

        // then
        assertThat(result).isEqualTo(G.INSTANCE.toString());
    }

    @Test
    public void application_should_return_not_found_message_when_provided_A_is_not_valid() {
        // given
        dbus._2.firstProductionIssue.Application application = new Application();
        A a = A.NON_VALID_INSTANCE;

        // when
        String result = application.correctedRun(a);

        // then
        assertThat(result).isEqualTo("G cannot be found");
    }

}