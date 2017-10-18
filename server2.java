import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;

public class server2{
	public static void main(String args[]) throws Exception
	{
		ServerSocket sersock = new ServerSocket(5000);
		System.out.println("Server is ready");

		Socket sock = sersock.accept();

		InputStream istream = sock.getInputStream();
		DataInputStream dstream = new DataInputStream(istream);
                
		String message2 = dstream.readLine();
		System.out.println(message2);
		dstream.close();
		istream.close();
		sock.close();
		sersock.close();
	}
}
