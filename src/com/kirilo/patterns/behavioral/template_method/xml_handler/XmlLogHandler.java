package com.kirilo.patterns.behavioral.template_method.xml_handler;

import com.kirilo.patterns.behavioral.template_method.Element;

import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlLogHandler extends XmlHandler {
    private final static Logger LOGGER = Logger.getLogger(XmlHandler.class.getName());

    @Override
    public boolean handleElement(Element element) {
        if (element == null) {
            return false;
        }
        LOGGER.log(Level.SEVERE, element.getTag());
        return true;
    }
}
