package com.ozalp.dollars;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup
                    .connect(
                            "https://www.google.com/search?q=dollars&sxsrf=AB5stBimrLwgM46PbIhUyeak3sl-psL03w%3A1690558307553&source=hp&ei=Y9_DZPamH9GVxc8P_9GxkAo&iflsig=AD69kcEAAAAAZMPtc-mFRlfp8hPTOYcJabdHUvtXRzB3&ved=0ahUKEwi25JC73LGAAxXRSvEDHf9oDKIQ4dUDCAk&uact=5&oq=dollars&gs_lp=Egdnd3Mtd2l6Igdkb2xsYXJzMgwQIxiKBRgnGEYYggIyDRAAGIAEGLEDGIMBGAoyBxAAGIAEGAoyBxAAGIAEGApIsg5QzQhYtw1wAngAkAEAmAGdAaAB2AaqAQMwLja4AQPIAQD4AQGoAgrCAgcQIxjqAhgnwgIHECMYigUYJ8ICBBAjGCfCAgsQABiABBixAxiDAcICCxAAGIoFGLEDGIMBwgIFEAAYgATCAgQQABgDwgIIEAAYgAQYsQM&sclient=gws-wiz")
                    .get();
            Elements dollarElements = doc.select(
                    "span.DFlfde.SwHCTb");
            String dollarsText = dollarElements.text().replace(",", ".");
            System.out.println(dollarsText);

            Scanner scanner = new Scanner(System.in);

            islemleriGerceklestir(scanner, dollarsText);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void islemleriGerceklestir(Scanner scanner, String dollarsText) {
        int islem;
        double deger;
        while (true) {
            System.out.println("\n***********************");
            System.out.println("Mevcut dolar kuru: " + dollarsText);
            System.out.println("İşlem seçiniz:\n1.Dolar => TL\n2.TL => Dolar");
            islem = scanner.nextInt();
            scanner.nextLine();

            switch (islem) {
                case 1:
                    System.out.print("Dolar bazında değer giriniz: ");
                    deger = scanner.nextDouble();
                    System.out.print(deger + " => ");
                    scanner.nextLine();
                    deger = deger * Double.parseDouble(dollarsText);
                    System.out.println(deger);
                    break;
                case 2:
                    System.out.print("TL bazında değer giriniz: ");
                    deger = scanner.nextDouble();
                    System.out.print(deger + " => ");
                    scanner.nextLine();
                    deger = deger / Double.parseDouble(dollarsText);
                    System.out.println(deger);
                    break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
