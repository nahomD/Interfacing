import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args){
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            EntertainmentNews entertainmentNews = (EntertainmentNews) reg.lookup("entertainmentNews");
            System.out.println(entertainmentNews.getTopRated());
            System.out.println(entertainmentNews.search("Bingo"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
