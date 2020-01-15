package com.kirilo.patterns.behavioral.template_method.xml_handler;

import com.kirilo.patterns.behavioral.template_method.Element;

public interface Handler {
    void parse(String snippet);

    boolean handleElement(Element element);
}
