package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.lang.Thread;

public class ScreenWriter implements Runnable {
  private Socket socket;

  public ScreenWriter(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      // get input stream (from server)
      InputStream socketInputStream = socket.getInputStream();
      int writeByte;

      // while the server is still sending stuff, print it to stdout
      while ((writeByte = socketInputStream.read()) != -1) {
        System.out.write(writeByte);
      }

      System.out.flush();

    } catch (IOException ioe) {
      System.out.println("Uh-oh!");
    }
  }

}
