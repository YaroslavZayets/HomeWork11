package Inspection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("site.txt"))){
            String str = "";
            while ((str = bf.readLine())!=null){
                try {
                    InetAddress address = InetAddress.getByName(str);
                    System.out.println("Сайт " + str + " доступен");

                } catch (UnknownHostException e){
                    System.out.println("Сайт " + str + " не доступен");
                }
            }

        } catch (IOException e){
            System.out.println(e);
        }
    }
}
