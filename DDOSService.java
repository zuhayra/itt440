import java.rmi.*;

public interface DDOSService extends java.rmi.Remote
{
	public String attack ()
		throws RemoteException;

}

