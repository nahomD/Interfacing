import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EntertainmentNews extends Remote {
    ArrayList<Movie> getTopRated() throws RemoteException;
    ArrayList<Movie> search(String query) throws RemoteException;
}
