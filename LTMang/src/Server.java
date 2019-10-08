import java.io.*;
import java.net.*;
import java.util.Date;

public class Server{
	private Socket socket = null;
	private ServerSocket server = null;
	private DataOutputStream output = null;
	
	public Server(int port) {
		try {
			server = new ServerSocket(port);
			socket = server.accept();
			output = new DataOutputStream(socket.getOutputStream());
			String date = new Date().toString();
			output.writeUTF("hom nay la"+date);
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	public static void main(String args[]) {
		Server sv = new Server(5000);
	}
}