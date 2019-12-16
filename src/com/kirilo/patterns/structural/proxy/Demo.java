package com.kirilo.patterns.structural.proxy;

import com.kirilo.patterns.structural.proxy.images.Image;
import com.kirilo.patterns.structural.proxy.images.ProxyImage;

public class Demo {
    public static void main(String[] args) {
        Image image = new ProxyImage("path:someFile.img");
        image.display();
        System.out.println("Get image again: ");
        image.display();
    }
}
