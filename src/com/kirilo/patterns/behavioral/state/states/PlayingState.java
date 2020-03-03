package com.kirilo.patterns.behavioral.state.states;

import com.kirilo.patterns.behavioral.state.ui.Player;

import static com.kirilo.patterns.behavioral.state.states.StatesEnum.*;

public class PlayingState extends BaseState {
    private Player player;

    public PlayingState(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public String onLock() {
        player.setState(locked);
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        player.setState(ready);
        return "Paused...";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
