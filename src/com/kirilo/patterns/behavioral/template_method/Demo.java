package com.kirilo.patterns.behavioral.template_method;

import com.kirilo.patterns.behavioral.template_method.xml_handler.XmlHandler;
import com.kirilo.patterns.behavioral.template_method.xml_handler.XmlLogHandler;
import com.kirilo.patterns.behavioral.template_method.xml_handler.XmlPrintHandler;

public class Demo {
    public static void main(String[] args) {
        String snippet = "<books><book><title>Ben-Hur</title><author>Lew Wallace</author></book></books>";
        XmlHandler  printHandler = new XmlPrintHandler();
        printHandler.parse(snippet);

        printHandler = new XmlLogHandler();
        printHandler.parse(snippet);

    }
}
