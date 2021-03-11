package usantatecla.utils.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIP {

	private ServerSocket serverSocket;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public TCPIP(Socket socket) {
		this.serverSocket = null;
		this.socket = socket;
		try {
			this.out = new PrintWriter(socket.getOutputStream());
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}

	public TCPIP(ServerSocket serverSocket, Socket socket) {
		this(socket);
		this.serverSocket = serverSocket;
	}

	public void send(String value) {
		this.println(value);
		this.out.flush();
	}

	protected void println(String value) {
		this.out.println(value);
	}

	public void send(int value) {
		this.send("" + value);
	}

	public void send(boolean value) {
		this.send("" + value);
	}

	public String receiveLine() {
		String result = null;
		try {
			result = this.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	protected String readLine() throws IOException {
		return this.in.readLine();
	}

	public int receiveInt() {
		String line = this.receiveLine();
		return line != null ? Integer.parseInt(line) : -1;
	}

	public boolean receiveBoolean() {
		String line = this.receiveLine();
		return Boolean.parseBoolean(line);
	}

	public void close() {
		try {
			this.closeInAndOut();
			this.socket.close();
			if (this.serverSocket != null) {
				this.serverSocket.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void closeInAndOut() throws IOException {
		this.in.close();
		this.out.close();
	}

}
