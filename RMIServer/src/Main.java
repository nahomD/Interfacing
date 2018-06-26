import sun.rmi.registry.RegistryImpl;

import java.net.Inet4Address;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args){
        try{
            EntertainmentNews entertainmentNews = new EntertainmentNewsImpl();
            Registry reg = LocateRegistry.createRegistry(1099);
            Naming.rebind("entertainMentNews", entertainmentNews);

            reg.bind("entertainmentNews",entertainmentNews);
            System.out.println("Server Running on " + Inet4Address.getLocalHost().getHostName());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
