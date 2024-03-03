import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculatriceServeur extends UnicastRemoteObject implements Calculatrice {
    public CalculatriceServeur() throws RemoteException {
        super();
    }

    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        return a / b;
    }
}
