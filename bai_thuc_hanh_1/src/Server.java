import java.net.*; 
import java.io.*; 
import java.io.*;
public class Server 
{ 
   private Socket socket = null;
   private ServerSocket server = null;
   private DataInputStream in =null;
   private DataOutputStream out = null;
   public Server(int port) {
	   try {
		   server = new ServerSocket(port);
		   System.out.println("Server started");
		   System.out.println("Waiting for a client");
		   socket = server.accept();
		   System.out.println("Client accepted");
		   in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		   out = new DataOutputStream(socket.getOutputStream());
		   String line = "";
		   while(!line.equals("Over")) {
			   try
			   {
				   line = in.readUTF();
				   out.writeUTF(ToUpperCase(line));
				   System.out.println(ToUpperCase(line));
			   }
			   catch(IOException i) {
				   System.out.println(i);
			   }
		   }
		   System.out.println("Closing connection");
		   socket.close();
		   in.close();
	   }
	   catch(IOException i) {
		   System.out.println(i);
	   }
   }
   private String ToUpperCase(String line) {
	   char str[]=line.toCharArray();
	     for(int i=0;i<str.length;i++)
	     {
	         if(str[i]>='a' && str[i]<='z')
	         { 
	         str[i]=(char)((int)str[i]-32);
	         }
	     }
	     return String.copyValueOf(str);
   }
   public String ToLowerCase(String line) {
	   char str[]=line.toCharArray();
	     for(int i=0;i<str.length;i++)
	     {
	         if(str[i]>='A' && str[i]<='Z')
	         { 
	         str[i]=(char)((int)str[i]+32);
	         }
	     }
	     return String.copyValueOf(str);
   }
   public String ToLowerOrUpperCase(String line) {
	   char str[]=line.toCharArray();
	     for(int i=0;i<str.length;i++)
	     {
	         if(str[i]>='a' && str[i]<='z')
	         { 
	         str[i]=(char)((int)str[i]-32);
	         }
	         else if(str[i]>='A' && str[i]<='Z')
	         { 
	         str[i]=(char)((int)str[i]+32);
	         }
	     }
	     return String.copyValueOf(str);
   }
   public int NumberOfWords(String line) {
	   		if (line == null || line.isEmpty()) {
		      return 0;
		    }
		    int wordCount = 0;

		    boolean isWord = false;
		    int endOfLine = line.length() - 1;
		    char[] characters = line.toCharArray();
		    for (int i = 0; i < characters.length; i++) {
		      if (Character.isLetter(characters[i]) && i != endOfLine) {
		        isWord = true;

		      } else if (!Character.isLetter(characters[i]) && isWord) {
		        wordCount++;
		        isWord = false;
		      } else if (Character.isLetter(characters[i]) && i == endOfLine) {
		        wordCount++;
		      }
		    }

		    return wordCount;
   }
   public static void main(String args[]) {
	   Server server = new Server(5000);
   }
} 