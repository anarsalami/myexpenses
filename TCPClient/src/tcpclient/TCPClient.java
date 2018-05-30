/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author sarkhanrasullu
 */
public class TCPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("37.26.14.6",6789);//1000  200,200,200,200,200
        DataOutputStream outToStream = new DataOutputStream(clientSocket.getOutputStream());
        
        Scanner sc = new Scanner(System.in);//SMPP short message peer to peer, HTTP, header body
        String text = sc.nextLine();
        byte[] bytes = readBytesFromFile(text);
        outToStream.write(bytes);

        clientSocket.close();
    }
    
    
    private static byte[] readBytesFromFile(String filePath) {

        byte[] bytesArray = null;

        try(FileInputStream fileInputStream=new FileInputStream(filePath);) {
            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];
            //read file into bytes[]
            fileInputStream.read(bytesArray);
        } catch (IOException e) {
            e.printStackTrace();
        } 

        return bytesArray;

    }
    
}
