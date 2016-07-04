package loginView;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginViewImpl extends VerticalLayout implements LoginView, View {

    List<LoginViewListener> listeners = new ArrayList<LoginViewListener>();

    public LoginViewImpl() {

        setSizeFull();
        setSpacing(true);
        setMargin(true);

        TextField username = new TextField();
        TextField password = new TextField();
        Button enter = new Button("Enter");
        enter.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                for (LoginViewListener listener : listeners) {
                    listener.verify(username.getValue(), password.getValue());
                }
            }

        });

        addComponents(username, password, enter);
    }

    @Override
    public void addListener(LoginViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
