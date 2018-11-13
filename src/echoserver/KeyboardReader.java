package echoserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class KeyboardReader implements Runnable {
  private Socket socket;

  public KeyboardReader(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      // get input from keyboard
      OutputStream socketOutputStream = socket.getOutputStream();
      int readByte;

      // while there's still stuff in stdin, send it to the server
      while ((readByte = System.in.read()) != -1) {
        socketOutputStream.write(readByte);
      }

      // System.out.println("Shutting down KeyboardReader");
      socket.shutdownOutput();

    } catch (IOException ioe) {
      System.out.println("Uh-oh!");
    }
  }
}
