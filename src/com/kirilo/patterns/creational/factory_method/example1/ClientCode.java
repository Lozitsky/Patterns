package com.kirilo.patterns.creational.factory_method.example1;
import com.kirilo.patterns.creational.factory_method.example1.factory.*;

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
