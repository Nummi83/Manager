package startView;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class StartViewImpl extends VerticalLayout implements StartView, View {

    public StartViewImpl() {
        setSizeFull();
        setMargin(true);
        setSpacing(true);
        Button clickMe = new Button("Continue Game",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        for (StartViewListener listener : listeners) {
                            listener.continueGame();
                        }
                    }
                });

        addComponent(clickMe);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub
    }

    List<StartViewListener> listeners = new ArrayList<StartViewListener>();

    @Override
    public void addListener(StartViewListener listener) {
        listeners.add(listener);
    }

}
