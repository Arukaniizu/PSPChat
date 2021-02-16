import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {


    public static void main(String[] args) {
        int puerto = 1234;
        int maximoConexiones = 10; // Maximo de conexiones simultaneas
        ServerSocket servidor = null;
        Socket socket = null;
        MensajeChat mensajes = new MensajeChat();

        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);

            // Bucle infinito para esperar conexiones
            while (true) {
                socket = servidor.accept();

                ConexionCliente cc = new ConexionCliente(socket, mensajes);
                cc.start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            finally{
                try {
                    socket.close();
                    servidor.close();
                } catch (IOException ex) {

                }
            }


    }


}

