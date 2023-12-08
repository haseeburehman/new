import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class clientclass {
    public static void main(String arg[]){
        clientclass c=new clientclass();
        c.connectRemote();
    }
    private void connectRemote(){
        try{
            Registry r=LocateRegistry.getRegistry("localhost",1092);
            ISearchCity s=(ISearchCity)r.lookup("Searchcity");
            System.out.println(s.findcity("Islamabad"));
        }
        catch(Exception ee)
        {
            System.out.println("exception "+ee);
        }
    }

}
