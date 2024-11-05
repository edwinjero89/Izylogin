package com.co.izy.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target TXT_USERNAME = Target.the("Ingresar usuario").locatedBy("//input[@id='exampleInputEmail1']");

    public static final Target TXT_PASSWORD = Target.the("Ingresar password").locatedBy("//input[@id='exampleInputPassword1']");

    public static final Target BTN_LOGIN = Target.the("Click en el botón login").locatedBy("//button[@id='effect-button']");

    public static final Target BTN_USER = Target.the("Click en el elemento User").locatedBy("//button[@type='button']");

    public static final Target Compare = Target.the("Click en el user").locatedBy("//*[contains(@class,'dropdown-item fw-normal fs-6 ms-1')]");
}
