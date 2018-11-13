package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class ClientHandler implements Runnable {
  private Socket socket;

  public ClientHandler (Socket socket) {
    this.socket = socket;
  }

  public void run() {
    InputStream inputStream = socket.getInputStream();
    OutputStream outputStream = socket.getOutputStream();
    int b;
    while ((b = inputStream.read()) != -1) {
      outputStream.write(b);
    }

    // System.out.println("Saying goodbye to client's ScreenWriter");
    socket.shutdownOutput();
  }
}
