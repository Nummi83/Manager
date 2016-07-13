package manager;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import commonComponents.LeftMenu;
import loginView.LoginPresenter;
import loginView.LoginViewImpl;
import mainMenuView.MainMenuPresenter;
import mainMenuView.MainMenuViewImpl;
import playerView.PlayerPresenter;
import playerView.PlayerViewImpl;
import startView.StartPresenter;
import startView.StartViewImpl;

@SuppressWarnings("serial")
@Theme("manager")
public class ManagerUI extends UI
        implements VerificationListener, ChoiceListener {

    private Navigator navigator;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ManagerUI.class, widgetset = "manager.widgetset.ManagerWidgetset")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        LoginViewImpl loginViewImpl = new LoginViewImpl();
        LoginPresenter loginPresenter = new LoginPresenter(loginViewImpl);

        loginPresenter.addListener(this);

        setContent(loginViewImpl);

    }

    @Override
    public void onSuccess() {

        buildStartView();
    }

    public void buildStartView() {

        StartViewImpl startViewImpl = new StartViewImpl();
        StartPresenter startPresenter = new StartPresenter(startViewImpl);

        startPresenter.addListener(this);

        setContent(startViewImpl);

    }

    @Override
    public void choose(String choice) {

        buildMainMenu();
    }

    private void buildMainMenu() {

        HorizontalLayout rootLayout = new HorizontalLayout();
        LeftMenu leftMenu = new LeftMenu();
        CssLayout contentLayout = new CssLayout();
        contentLayout.setSizeFull();

        rootLayout.addComponents(leftMenu, contentLayout);

        setContent(rootLayout);

        navigator = new Navigator(this, contentLayout);

        leftMenu.setNavigator(navigator);

        MainMenuViewImpl mainMenuViewImpl = new MainMenuViewImpl();
        new MainMenuPresenter(mainMenuViewImpl);

        navigator.addView("main", mainMenuViewImpl);
        navigator.navigateTo("main");

        // Button temp = new Button("Temp");
        // temp.addClickListener(new ClickListener() {
        //
        // @Override
        // public void buttonClick(ClickEvent event) {
        // navigator.navigateTo("player");
        //
        // }
        //
        // });
        //
        // rootLayout.addComponents(temp);

        createMainViews();

    }

    private void createMainViews() {

        PlayerViewImpl playerViewImpl = new PlayerViewImpl();
        new PlayerPresenter(playerViewImpl);
        navigator.addView("player", playerViewImpl);

    }

}