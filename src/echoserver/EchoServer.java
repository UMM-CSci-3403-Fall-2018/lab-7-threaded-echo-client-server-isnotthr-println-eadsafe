package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class EchoServer {
	public static final int PORT_NUMBER = 6013;
	private static int threadPoolSize = 16;

	public static void main(String[] args) throws IOException, InterruptedException {

		if (args.length == 1) {
			threadPoolSize = Integer.parseInt(args[0]);
		}

		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);

		// Thanks to https://www.geeksforgeeks.org/thread-pools-java/
		ExecutorService pool = Executors.newFixedThreadPool(threadPoolSize);

		while (true) {
			ClientHandler client = new ClientHandler(serverSocket.accept());
			pool.execute(client);
		}
	}
}
