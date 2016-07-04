package commonComponents;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class LeftMenu extends VerticalLayout {

    public LeftMenu() {

        setSizeFull();
        setMargin(true);
        setSpacing(true);

        for (int i = 0; i < 9; i++) {
            Button ragnar = new Button("ragnar");
            addComponent(ragnar);
        }

    }

}