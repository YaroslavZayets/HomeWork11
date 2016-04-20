import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Runtime rn = Runtime.getRuntime();

        int n = 0;
        String answer = "";
        boolean exit = true;

        try {
            ServerSocket s = new ServerSocket(8080);
            Socket incoming = s.accept();

            try {
                Scanner scanner = new Scanner(incoming.getInputStream());
                while (exit) {
                    answer += "Operating System Version -" + System.getProperty("os.name") + "\r\n";
                    answer += "Number of Cores - " + rn.availableProcessors() + "\r\n";
                    answer += "Total memory - " + rn.totalMemory() + "\r\n";
                    answer += "Your request for information under the number - " + (n++) + "\r\n";
                    incoming.getOutputStream().write(answer.getBytes());
                    String line = scanner.nextLine();
                    if (line.compareToIgnoreCase("exit") == 0) {
                        exit = false;
                    }
                }
            } finally {
                incoming.close();
            }


        } catch (IOException e){
            System.out.println(e);
        }
        System.out.println("END");

    }
}

