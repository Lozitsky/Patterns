package com.kirilo.patterns.behavioral.state.states;

import com.kirilo.patterns.behavioral.state.ui.Player;

public abstract class BaseState implements State {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public BaseState(Player player) {
        this.player = player;
    }
}
