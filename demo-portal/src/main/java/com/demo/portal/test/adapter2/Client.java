package com.demo.portal.test.adapter2;

public class Client {

    public static void main(String[] args) {
        Projector<AdapterUSB2VGA> adapterUSB2VGAProjector = new Projector<>();
        adapterUSB2VGAProjector.projection(new AdapterUSB2VGA());
        System.out.println("-----------");
        Projector<VGA> vgaProjector = new Projector<>();
        vgaProjector.projection(new VgaImpl());
        System.out.println("-----------");
        Projector<Usb> usbProjector = new Projector<Usb>();
        usbProjector.projection(new UsbImpl());
    }
}
