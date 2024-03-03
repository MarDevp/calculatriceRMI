import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatriceClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Calculatrice stub = (Calculatrice) registry.lookup("Calculatrice");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Entrez le code de l'opération (1:addition, 2:soustraction, 3:multiplication, 4:division) et les opérandes :");
                int code = scanner.nextInt();
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double resultat = 0;
                switch (code) {
                    case 1:
                        resultat = stub.addition(a, b);
                        break;
                    case 2:
                        resultat = stub.soustraction(a, b);
                        break;
                    case 3:
                        resultat = stub.multiplication(a, b);
                        break;
                    case 4:
                        resultat = stub.division(a, b);
                        break;
                }
                System.out.println("Le résultat est : " + resultat);
                System.out.println("Voulez-vous arrêter l'exécution ? (oui/non)");
                String reponse = scanner.next();
                if (reponse.equalsIgnoreCase("oui")) {
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
