package com.kirilo.patterns.behavioral.state.ui;

import com.kirilo.patterns.behavioral.state.states.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kirilo.patterns.behavioral.state.states.StatesEnum.ready;

public class Player {
    private State state;
    private Map<StatesEnum, State> states;
    private boolean playing;
    private List<String> playlist;
    private int currentTrack;

    public Player() {
        playlist = new ArrayList<>();
        states = new HashMap<>();
//        state = new ReadyState(this);
        state = StateFactory(ready);
        setPlaying(true);
        for (int i = 0; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    private State StateFactory(StatesEnum StateName) {
        State state = states.get(StateName);
        if (state == null) {
            switch (StateName) {
                case locked:
                    state = new LockedState(this);
                    break;
                case playing:
                    state = new PlayingState(this);
                    break;
                default:
                    state = new ReadyState(this);
                    break;
            }
            states.put(StateName, state);
        }
        return state;
    }

    public State getState() {
        return state;
    }

    public void setState(StatesEnum stateName) {
        state = StateFactory(stateName);
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String startPlayback() {
        return printNameOfTrack();
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack >= playlist.size()) {
            currentTrack = 0;
        }
        return printNameOfTrack();
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return printNameOfTrack();
    }

    public void setCurrentTrackAfterStop() {
        currentTrack = 0;
    }

    private String printNameOfTrack() {
        return "Playing" + playlist.get(currentTrack);
    }
}
