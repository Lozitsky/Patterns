package com.kirilo.patterns.abstract_factory.objects;

import com.kirilo.patterns.abstract_factory.objects.factories.GUIFactory;
import com.kirilo.patterns.abstract_factory.objects.factories.MacOSFactory;
import com.kirilo.patterns.abstract_factory.objects.factories.WindowsFactory;
import com.sun.corba.se.spi.legacy.interceptor.UnknownType;

public class MainClass {
    public static void main(String[] args) {
        ClientCode clientCode = null;
        try {
            clientCode = configureApplication();
        } catch (UnknownType unknownType) {
            unknownType.printStackTrace();
        }
        clientCode.paint();
    }

    private static ClientCode configureApplication() throws UnknownType {
        ClientCode code;
        GUIFactory factory;
        String property = System.getProperty("os.name");
        switch (property) {
            case "mac":
                factory = new MacOSFactory();
                code = new ClientCode(factory);
                break;
            case "Windows 7":
                factory = new WindowsFactory();
                code = new ClientCode(factory);
                break;
            default:
                throw new UnknownType(property);
        }
        return code;
    }
}
