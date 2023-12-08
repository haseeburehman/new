import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.server.*;
/**
 *
 * @author hp
 */
public class Server extends UnicastRemoteObject implements ISearchCity  {
    String str;

    Server() throws RemoteException {
        str = " ";
    }

    public String findcity(String cityname) throws RemoteException {
        int j = 0;
        String a[][] = {{"Lahore", "110"}, {"Islamabad", "1110"}, {"Karachi", "1101"}, {"Multan", "1010"}};
        for (int i = 0; i <= 3; i++) {
            if (cityname.equals(a[i][j])) {
                j++;
                str = a[i][j];
                break;
            } else {
                j++;
            }
        }

        return str;
    }

    public static void main(String args[]) throws RemoteException {
        try {
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1092);
            Server s = new Server();
            
            r.rebind("Searchcity", (Remote) s);
            System.out.println("Server is connected and ready for operation");

        } catch (Exception e) {
            System.out.println("Server is not connected" + e);
        }
    }
}
