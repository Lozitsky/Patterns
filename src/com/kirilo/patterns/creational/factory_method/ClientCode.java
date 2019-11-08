package com.kirilo.patterns.creational.factory_method;

import com.kirilo.patterns.creational.factory_method.factory.Dialog;
import com.kirilo.patterns.creational.factory_method.factory.HtmlDialog;
import com.kirilo.patterns.creational.factory_method.factory.WindowsDialog;

public class ClientCode {
    private static Dialog dialog;

    public static void main(String[] args) {
        configSimpleFactory();
        runBusinessLogic();
    }

    private static void runBusinessLogic() {
        dialog.renderWindow();
    }

//    an example of a Simple factory pattern
    private static void configSimpleFactory() {
        switch (System.getProperty("os.name")) {
            case "Windows NT":
                System.out.println("Windows NT");
                break;
            case "Windows 7":
                dialog = new WindowsDialog();
                break;
            case "Windows 10":
                dialog = new WindowsDialog();
                break;
            default:
                dialog = new HtmlDialog();
                break;
        }
    }
}
