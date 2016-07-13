package mainMenuView;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;

public class MainMenuViewImpl extends GridLayout implements MainMenuView, View {

    public MainMenuViewImpl() {

        setSizeFull();
        setMargin(true);
        setSpacing(true);

        setRows(3);
        setColumns(3);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button ragnar = new Button("Ragnar");
                addComponent(ragnar, col, row);
            }
        }

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
