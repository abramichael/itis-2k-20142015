import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	static final String HOST = "127.0.0.1";
	static final int PORT = 1234;

	public static void main(String [] args) 
			throws IOException {

		System.out.println("Connecting to server on "+HOST+":"+ PORT);

		Socket s = new Socket(HOST, PORT);

		System.out.println("Connection established!");

		BufferedInputStream bis =
					new BufferedInputStream(s.getInputStream());
		BufferedOutputStream bos = 
					new BufferedOutputStream(s.getOutputStream());
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int x = bis.read();
			System.out.println("Received from server: " + x);
			int data = scanner.nextInt();
			System.out.println("Sending data: " + data);
			bos.write(data);
			bos.flush();
		}

		//System.out.println("Connection closed.");
	}
	
}