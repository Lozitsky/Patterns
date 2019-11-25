package com.kirilo.patterns.structural.adapter;

import com.kirilo.patterns.structural.adapter.adapters.SquarePegAdapter;
import com.kirilo.patterns.structural.adapter.round.RoundHole;
import com.kirilo.patterns.structural.adapter.round.RoundPeg;
import com.kirilo.patterns.structural.adapter.square.SquarePeg;

public class Demo {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        System.out.println("roundHole.getRadius(): " + roundHole.getRadius() + ", " + "roundPeg.getRadius(): " + roundPeg.getRadius());
        System.out.println("roundHole.fits(roundPeg): " + roundHole.fits(roundPeg));

        SquarePeg smallSquarePeg = new SquarePeg(2);
        SquarePeg largeSquarePeg = new SquarePeg(20);

        SquarePegAdapter smallPegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter largePegAdapter = new SquarePegAdapter(largeSquarePeg);
        System.out.println("smallPegAdapter.getRadius(): " + smallPegAdapter.getRadius());
        System.out.println("roundHole.fits(smallPegAdapter): " + roundHole.fits(smallPegAdapter));
        System.out.println("largePegAdapter.getRadius(): " + largePegAdapter.getRadius());
        System.out.println("roundHole.fits(largePegAdapter): " + roundHole.fits(largePegAdapter));
    }
}
