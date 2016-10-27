package sockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
	
	public static void client() throws IOException {
		Socket client =  new Socket(InetAddress.getLocalHost(), 8080);

		OutputStream outputStream = client.getOutputStream();

		//Aufgabe2f:
		//outputStream.write("Hello\n".getBytes());
	    
		//Starts Aufgabe 3+4 with command "Add"
		//outputStream.write("Add 1 2 3\n".getBytes());
		
		//Tests the other commands by commenting out the others
		outputStream.write("Subtract 1 2 3\n".getBytes());
		outputStream.write("Multiply 1 2 3\n".getBytes());
		outputStream.write("Hello Malwine\n".getBytes());
		
		outputStream.flush();
		
		// We might want to send back the result of the commands to the client. 
		// At the moment the results are simply output to the console through Protocol#process.
		
		InputStreamReader input = new InputStreamReader(client.getInputStream());
   		BufferedReader reader = new BufferedReader(input);
   		System.out.println(reader.readLine());

		client.close();
		
	}

	public static void main(String[] args) {
		
		try {
			client();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
