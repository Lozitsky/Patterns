package com.kirilo.patterns.behavioral.state.states;

import com.kirilo.patterns.behavioral.state.ui.Player;

public class PlayingState extends BaseState {
    private Player player;

    public PlayingState(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public String onLock() {
        player.setState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        player.setState(new ReadyState(player));
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
