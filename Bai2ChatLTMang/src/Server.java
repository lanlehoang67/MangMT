import java.io.*;
import java.net.*;
public class Server {

	private DataInputStream in = null;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	private Socket socket = null;
	private ServerSocket server = null;
	
	public Server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("System online");
			socket = server.accept();
			System.out.println("Client accepted");
			in = new DataInputStream(socket.getInputStream());
			input = new DataInputStream(new BufferedInputStream(System.in));
			out = new DataOutputStream(socket.getOutputStream());
			String msg ="";
			String line = "";
			while(true){
				try {
					msg = in.readUTF();
					System.out.println("tin tu client: "+msg);
					line = input.readLine();
					out.writeUTF(line);
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
		Server sv = new Server(5002);
	}
	
}
