package echoserver;

public class ScreenWriter implements Runnable {
  private Socket socket;

  public ScreenWriter(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    InputStream socketInputStream = socket.getInputStream();
    int writeByte;

    while ((writeByte = socketInputStream.read()) != -1) {
      System.out.write(writeByte);
    }

    socket.shutdownOutput();
  }
}
