
package server;

public class Principal {
    public static void main(String[] args) {
        Server server = new Server();
        System.out.println("Corriendo servidor");
        server.run();
    }
}
