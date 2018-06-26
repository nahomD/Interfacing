import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class EntertainmentNewsImpl extends UnicastRemoteObject implements EntertainmentNews{

    private ArrayList<Movie> mMovieArrayList = new ArrayList<>();

    public EntertainmentNewsImpl()throws RemoteException{
        mMovieArrayList.add(new Movie(5, "The Internet's own boy"));
        mMovieArrayList.add(new Movie(3, "Hidden Colors"));
    }

    @Override
    public ArrayList<Movie> getTopRated() throws RemoteException {
        return mMovieArrayList;
    }

    @Override
    public ArrayList<Movie> search(String s) throws RemoteException {
        return mMovieArrayList;
    }
}
