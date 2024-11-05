package com.co.izy.stepdefinitions;

import com.co.izy.exceptions.MessageExceptions;
import com.co.izy.models.Credentials;
import com.co.izy.questions.CompareName;
import com.co.izy.tasks.LoginTask;
import com.co.izy.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginStepDefinition {

    @Managed
    WebDriver hisBrowser;
    private Object LoginTask;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));

    }

    @Given("^el usuario abre la pagina web$")
    public void elUsuarioAbreLaPaginaWeb() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("http://campusvirtual.izyacademy.com:8000/login"));

    }

    @When("^el usuario ingresa las credenciales$")
    public void elUsuarioIngresaLasCredenciales(List<Credentials> credentialsList) {

        Credentials credentials;
        credentials= credentialsList.get(1);

        OnStage.theActorInTheSpotlight().attemptsTo(com.co.izy.tasks.LoginTask.enterCredentials(credentials));
    }

    @Then("^el usuario podra ver su nombre$")
    public void elUsuarioPodraVerSuNombre() {
    OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CompareName.compare(), Matchers.is(Constants.NAME_COMPARATION))
            .orComplainWith(MessageExceptions.class, com.co.izy.utils.Constants.MESSAGE_FINAL)

    );
    }


}
