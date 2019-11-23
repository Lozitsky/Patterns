package com.kirilo.patterns.structural.adapters;

import com.kirilo.patterns.structural.round.RoundPeg;
import com.kirilo.patterns.structural.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow(peg.getWidth(), 2) * 2) / 2;
    }
}
