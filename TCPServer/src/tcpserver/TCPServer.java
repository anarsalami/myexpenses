/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author sarkhanrasullu
 */
public class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ourFirstSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = ourFirstSocket.accept();

            InputStreamReader isr = new InputStreamReader(connectionSocket.getInputStream());

            InputStream in = connectionSocket.getInputStream();
            Scanner sc = new Scanner(System.in);
            System.out.println("enter file name:");
            // Writing the file to disk
            // Instantiating a new output stream object
            OutputStream output = new FileOutputStream(sc.nextLine());

            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            System.out.println("file transfer finished");
            // Closing the FileOutputStream handle
            output.close();
        }
    }

}
