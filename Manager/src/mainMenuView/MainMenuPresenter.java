package mainMenuView;

import com.vaadin.navigator.Navigator;

public class MainMenuPresenter implements MainMenuView.MainMenuViewListener {

    MainMenuView mainMenuView;

    Navigator navigator;

    public MainMenuPresenter(MainMenuView mainMenuView, Navigator navigator) {

        this.mainMenuView = mainMenuView;
        this.navigator = navigator;
    }

}