package com.kirilo.patterns.builder.components;

public class GPSNavigator {
    private String route;

    public String getRoute() {
        return route;
    }

    public GPSNavigator(String route) {
        this.route = route;
    }

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }
}
