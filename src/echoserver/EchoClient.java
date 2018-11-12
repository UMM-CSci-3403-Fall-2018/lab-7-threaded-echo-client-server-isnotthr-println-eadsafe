package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.lang.Thread;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {
		// set up the socket for the threaded pieces to use
		Socket socket = new Socket("localhost", PORT_NUMBER);

		// make 2 threads. One to handle reading input + sending to server,
		// the other to handle reading from the server + writing to screen.
		Thread readKeyboard = new Thread(new KeyboardReader(socket));
		Thread writeToScreen = new Thread(new ScreenWriter(socket));

		// run each thread's run() method and wait for them to finish
		readKeyboard.start();
		writeToScreen.start();
		readKeyboard.join();
		writeToScreen.join();
	}
}
