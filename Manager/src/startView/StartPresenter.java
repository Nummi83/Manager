package startView;

import java.util.ArrayList;
import java.util.List;

import manager.ChoiceListener;

public class StartPresenter implements StartView.StartViewListener {

    List<ChoiceListener> listeners = new ArrayList<ChoiceListener>();

    StartView startView;

    public StartPresenter(StartView startView) {
        this.startView = startView;
        startView.addListener(this);
    }

    @Override
    public void continueGame() {
        for (ChoiceListener listener : listeners) {
            listener.choose("continue game");
        }
    }

    public void addListener(ChoiceListener listener) {
        listeners.add(listener);
    }

}