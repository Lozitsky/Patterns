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

    //    an example of a Simple factory
    private static void configSimpleFactory() {
        String os = System.getProperty("os.name");
        switch (os) {
            case "Windows NT":
            case "Windows 7":
            case "Windows 10":
                System.out.println(os);
                dialog = new WindowsDialog();
                break;
            default:
                dialog = new HtmlDialog();
                break;
        }
    }
}
