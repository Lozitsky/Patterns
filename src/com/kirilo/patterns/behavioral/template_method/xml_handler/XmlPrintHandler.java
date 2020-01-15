package com.kirilo.patterns.behavioral.template_method.xml_handler;

import com.kirilo.patterns.behavioral.template_method.Element;

public class XmlPrintHandler extends XmlHandler {
    @Override
    public boolean handleElement(Element element) {
        if (element == null) {
            return false;
        }
        System.out.println("Found element with tag: " + element.getTag());
        return true;
    }
}
