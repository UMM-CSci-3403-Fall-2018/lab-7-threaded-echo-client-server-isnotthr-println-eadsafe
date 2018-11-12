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
		OutputStream socketOutputStream = socket.getOutputStream();
    int readByte;

    while ((readByte = System.in.read()) != -1) {
      socketOutputStream.write(readByte);
    }

    socket.shutdownOutput();
  }
}
