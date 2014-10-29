import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {

	static final int PORT = 1234;
	
	public static void main(String [] args) throws IOException{
		
		System.out.println("Started server on " + PORT);
		ServerSocket ss = new ServerSocket(PORT);
		System.out.print("Waiting for connection... ");
		Socket s = ss.accept();
		System.out.println("Got it!");

		BufferedInputStream bis =
					new BufferedInputStream(s.getInputStream());
		BufferedOutputStream bos = 
					new BufferedOutputStream(s.getOutputStream());
		Scanner scanner = new Scanner(System.in);

		while (true) {
			int data = scanner.nextInt();
			System.out.println("Sending data: " + data);
			bos.write(data);
			bos.flush();
			int x = bis.read();
			System.out.println("Received from client: " + x);
		}

		//System.out.println("Halting server.");

	}

}