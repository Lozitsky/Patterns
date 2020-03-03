package com.kirilo.patterns.behavioral.state.states;

import com.kirilo.patterns.behavioral.state.ui.Player;

import static com.kirilo.patterns.behavioral.state.states.StatesEnum.locked;
import static com.kirilo.patterns.behavioral.state.states.StatesEnum.playing;

public class ReadyState extends BaseState {
    private Player player;

    public ReadyState(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public String onLock() {
        player.setState(locked);
        return "Locked...";
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.setState(playing);
        return action;
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
