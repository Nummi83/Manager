package commonComponents;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class LeftMenu extends VerticalLayout {

    Navigator navigator;

    public LeftMenu() {

        setSizeFull();
        setMargin(true);
        setSpacing(true);

        for (int i = 0; i < 9; i++) {
            Button ragnar = new Button("ragnar");
            ragnar.addClickListener(new Button.ClickListener() {

                @Override
                public void buttonClick(ClickEvent event) {

                    navigator.navigateTo("player");
                }
            });
            addComponent(ragnar);
        }

    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

}