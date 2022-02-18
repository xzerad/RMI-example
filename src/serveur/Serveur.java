package serveur;
import java.lang.SecurityManager;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {
	public static void main(String[] args) {
		NoteImpl note = new NoteImpl();
		String url = "rmi://127.0.0.1/note";

		try {
			LocateRegistry.createRegistry(1099);
			if(System.getSecurityManager() == null){
				System.setSecurityManager(new SecurityManager());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {
			Remote obj = UnicastRemoteObject.exportObject(note, 1099);
			Naming.rebind(url, obj);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
