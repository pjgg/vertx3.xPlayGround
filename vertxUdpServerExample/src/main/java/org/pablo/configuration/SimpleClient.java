package org.pablo.configuration;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SimpleClient {
	 public static void main(String args[]) throws IOException {
		 
	      String host = "127.0.0.1";
	      int port = 8282;

	      byte[] message = "Java Source and Support".getBytes();

	      // Get the internet address of the specified host
	      InetAddress address = InetAddress.getByName(host);

	      // Initialize a datagram packet with data and address
	      DatagramPacket packet = new DatagramPacket(message, message.length,
	          address, port);

	      // Create a datagram socket, send the packet through it, close it.
	      DatagramSocket dsocket = new DatagramSocket();
	      dsocket.send(packet);
	      dsocket.close();
	  }
}
