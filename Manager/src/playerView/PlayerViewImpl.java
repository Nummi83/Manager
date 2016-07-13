package playerView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class PlayerViewImpl extends VerticalLayout implements PlayerView, View {

    public PlayerViewImpl() {

        setSizeFull();
        setMargin(true);
        setSpacing(true);

        Label hello = new Label("Hello World!");

        addComponent(hello);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
