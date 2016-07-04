package manager;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import loginView.LoginPresenter;
import loginView.LoginViewImpl;
import mainMenuView.MainMenuPresenter;
import mainMenuView.MainMenuViewImpl;
import startView.StartPresenter;
import startView.StartViewImpl;

@SuppressWarnings("serial")
@Theme("manager")
public class ManagerUI extends UI
        implements VerificationListener, ChoiceListener {

    private Navigator navigator;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ManagerUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        navigator = new Navigator(this, this);

        LoginViewImpl loginViewImpl = new LoginViewImpl();
        LoginPresenter loginPresenter = new LoginPresenter(loginViewImpl);

        loginPresenter.addListener(this);

        navigator.addView("login", loginViewImpl);

        navigator.navigateTo("login");
    }

    @Override
    public void onSuccess() {

        buildStartView();
    }

    public void buildStartView() {

        StartViewImpl startViewImpl = new StartViewImpl();
        StartPresenter startPresenter = new StartPresenter(startViewImpl);

        startPresenter.addListener(this);

        navigator.addView("start", startViewImpl);

        navigator.navigateTo("start");
    }

    @Override
    public void choose(String choice) {

        buildMainMenu();
    }

    private void buildMainMenu() {

        MainMenuViewImpl mainMenuViewImpl = new MainMenuViewImpl();
        new MainMenuPresenter(mainMenuViewImpl, navigator);

        navigator.addView("mainMenu", mainMenuViewImpl);

        navigator.navigateTo("mainMenu");
    }

}