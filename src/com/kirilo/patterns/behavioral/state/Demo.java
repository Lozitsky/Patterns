package com.kirilo.patterns.behavioral.state;

import com.kirilo.patterns.behavioral.state.ui.Player;
import com.kirilo.patterns.behavioral.state.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
