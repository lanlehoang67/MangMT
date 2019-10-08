import java.io.*;
import java.net.*;
public class Client {
	private Socket socket = null;
	private DataInputStream in = null;
	public Client(String address, int port) {
		try {
			socket = new Socket(address,port);
			in = new DataInputStream(socket.getInputStream());
			System.out.print(in.readUTF());
		}
		catch(IOException e) {
			System.out.print(e);
		}
	}
	public static void main(String args[]) {
		Client client = new Client("127.0.0.1",5000);
	}
}