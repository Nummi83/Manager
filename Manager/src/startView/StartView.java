package startView;

interface StartView {

    interface StartViewListener {

        void continueGame();

    }

    public void addListener(StartViewListener listener);

}