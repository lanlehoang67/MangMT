import java.io.*;
import java.net.*;
public class Client {

	private DataInputStream in = null;
	private DataOutputStream out = null;
	private DataInputStream input = null;
	private Socket socket = null;
	
	public Client(String address, int port) {
		try {
			socket = new Socket(address, port);
			System.out.print("Connected to server");
			in = new DataInputStream(socket.getInputStream());
			input = new DataInputStream(new BufferedInputStream(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			String msg = "";
			String line = "";
			while(true) {
				try {
					line = input.readLine();
					out.writeUTF(line);
					msg = in.readUTF();
					System.out.println("Tin nhan tu server: "+msg);
					
				}
				catch(IOException e) {
					System.out.println(e);
				}
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	public static void main(String args[]) {
		Client client = new Client("127.0.0.1", 5002);
	}
}