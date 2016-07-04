package mainMenuView;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;

import commonComponents.LeftMenu;

public class MainMenuViewImpl extends HorizontalLayout
        implements MainMenuView, View {

    public MainMenuViewImpl() {

        setSizeFull();
        setMargin(true);
        setSpacing(true);

        LeftMenu leftMenu = new LeftMenu();
        addComponent(leftMenu);

        GridLayout mainMenu = new GridLayout(3, 3);
        mainMenu.setSizeFull();
        mainMenu.setSpacing(true);
        mainMenu.setMargin(true);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button ragnar = new Button("Ragnar");
                mainMenu.addComponent(ragnar, col, row);
            }
        }

        addComponent(mainMenu);

        setExpandRatio(leftMenu, 1);
        setExpandRatio(mainMenu, 2);

    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub
    }

    List<MainMenuViewListener> listeners = new ArrayList<MainMenuViewListener>();

    @Override
    public void addListener(MainMenuViewListener listener) {
        listeners.add(listener);
    }

}
