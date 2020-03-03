package com.kirilo.patterns.behavioral.state.states;

import com.kirilo.patterns.behavioral.state.ui.Player;

import static com.kirilo.patterns.behavioral.state.states.StatesEnum.ready;

public class LockedState extends BaseState {
    private Player player;

    public LockedState(Player player) {
        super(player);
        this.player = player;
        this.player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.setState(ready);
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        player.setState(ready);
        return "Ready";
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
