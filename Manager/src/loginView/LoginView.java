package loginView;

interface LoginView {

    interface LoginViewListener {

        void verify(String username, String password);

    }

    public void addListener(LoginViewListener listener);

}