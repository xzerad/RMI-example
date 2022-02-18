package serveur;
import java.rmi.RemoteException;

public class NoteImpl implements NoteInterface{
	@Override
	public double getNote(int etudiantCin, String codeMatier) throws RemoteException {
		return 10+Math.random()*10;
	}
}
