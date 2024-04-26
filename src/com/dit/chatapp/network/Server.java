package com.dit.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.dit.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket ss;
	ArrayList<ServerWorker> workers = new ArrayList<>(); //contains all the client sockets
	//Multiple Client
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		ss = new ServerSocket(PORT);
		System.out.println("Server starts....");
		System.out.println("Waiting for clients to join....");
		handleClientRequest();
	}
	//Multiple Client Handshaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket = ss.accept(); //handshaking
			// per Client per Thread
			ServerWorker serverWorker = new ServerWorker(clientSocket, this); //creating a new worker/thread
			workers.add(serverWorker);
			serverWorker.start();
		}
	}
	
	/* Single Client */
	/*
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		ss = new ServerSocket(PORT);
		System.out.println("Server Started....");
		System.out.println("Waiting for the Client Connection...");
		Socket socket = ss.accept(); //handshaking
		System.out.println("Client Joins the Server....");
		InputStream in = socket.getInputStream(); //read bytes from the network
		byte arr[] = in.readAllBytes();
		String str = new String(arr); //bytes gets converted into string
		System.out.println("Message received from Client : "+str);
		in.close();
		socket.close();
	}
	*/
	

	public static void main(String[] args) throws IOException {
		Server s = new Server();
	}
}
