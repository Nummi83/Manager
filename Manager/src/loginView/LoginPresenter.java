package loginView;

import java.util.ArrayList;
import java.util.List;

import manager.VerificationListener;

public class LoginPresenter implements LoginView.LoginViewListener {

    LoginView loginView;

    List<VerificationListener> listeners = new ArrayList<VerificationListener>();

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginView.addListener(this);
    }

    @Override
    public void verify(String username, String password) {
        for (VerificationListener listener : listeners) {
            listener.onSuccess();
        }
    }

    public void addListener(VerificationListener listener) {
        listeners.add(listener);
    }

}
