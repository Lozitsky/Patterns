package com.kirilo.patterns.behavioral.state.ui;

import com.kirilo.patterns.behavioral.state.states.ReadyState;
import com.kirilo.patterns.behavioral.state.states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private boolean playing;
    private List<String> playlist;
    private int currentTrack;

    public Player() {
        playlist = new ArrayList<>();
        state = new ReadyState(this);
        setPlaying(true);
        for (int i = 0; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
