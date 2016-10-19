package sockets.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
	
	public static void client() throws IOException {
		Socket client =  new Socket(InetAddress.getLocalHost(), 8080);

		OutputStream outputStream = client.getOutputStream();

		outputStream.write("Hello".getBytes());

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
