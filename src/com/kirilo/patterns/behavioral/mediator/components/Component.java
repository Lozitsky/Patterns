package com.kirilo.patterns.behavioral.mediator.components;

import com.kirilo.patterns.behavioral.mediator.mediators.Mediator;

public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
