package client;
import serveur.NoteInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {
	public static void main(String[] args) {
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		try {
			Remote name = Naming.lookup("rmi://127.0.0.1/note");
			if(name instanceof NoteInterface){
				System.out.println(((NoteInterface) name).getNote(13, "khalil"));
			}
		} catch (NotBoundException | MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}
