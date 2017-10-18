import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class client2{

	public static void main(String args[])throws Exception
	{
		Socket sock = new Socket("192.168.220.132",5000);
		String message1 = "Accept Best Wishes";

		OutputStream ostream = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(ostream);
		dos.writeBytes(message1);
		dos.close();
		ostream.close();
		sock.close();
	}
}
