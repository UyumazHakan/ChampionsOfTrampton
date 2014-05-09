import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import Command.*;

public class Network {
  private String serverIP;
  private Socket socket;
  private ServerSocket server;
  private int numPlayers;
  private Socket[] connectedClients;
  private ObjectInputStream inputStream;
  private ObjectOutputStream outputStream;
  private final int PORT = 8888;
  public Network(int numPlayers){
    this.numPlayers=numPlayers;
    this.connectedClients=new Socket[numPlayers];
  }
  public Network(String serverIP){
    this.serverIP =serverIP;


  }
  private void setupServer(){
    try {
      server=new ServerSocket(PORT);
      for(int i=0;i<numPlayers;i++) {
        connectedClients[i] = server.accept();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void connectionEstablished(){

  }
  private void setupClient(){
    try {
      socket=new Socket(serverIP,PORT);
      inputStream=new ObjectInputStream(socket.getInputStream());
      outputStream=new ObjectOutputStream(socket.getOutputStream());
      connectionEstablished();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void send(Command command){
    try {
      outputStream.writeObject(command);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public Command receive(){
    try {
      return ((Command) inputStream.readObject());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


}