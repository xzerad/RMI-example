package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NoteInterface extends Remote {
	double getNote(int etudiantCin, String codeMatier) throws RemoteException;;
}
