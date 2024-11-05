package com.co.izy.tasks;

import com.co.izy.models.Credentials;
import com.co.izy.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.locators.WaitForWebElements;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {
Credentials credentials;

    public LoginTask(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credentials.getEmail()).into(LoginPage.TXT_USERNAME));
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));
       //actor.attemptsTo(WaitElement.untilAppears(LoginPage.BTN_LOGIN));
        actor.attemptsTo(WaitUntil.the(LoginPage.BTN_USER, isVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(Click.on(LoginPage.BTN_USER));

    }

    public static LoginTask enterCredentials(Credentials credentials){
        return Tasks.instrumented(LoginTask.class, credentials);

    }

}
