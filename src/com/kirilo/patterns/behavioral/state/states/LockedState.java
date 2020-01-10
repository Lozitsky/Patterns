package com.kirilo.patterns.behavioral.state.states;

import com.kirilo.patterns.behavioral.state.ui.Player;

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
            player.setState(new ReadyState(player));
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        player.setState(new ReadyState(player));
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
