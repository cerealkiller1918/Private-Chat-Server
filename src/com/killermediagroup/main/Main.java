package com.killermediagroup.main;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		SynchList outputStreamList = new SynchList();
		Transaction transaction;
		ServerSocket serverSocket = new ServerSocket(5000);
		
			
		while(true){
			System.out.println("waiting on client");
			transaction = new Transaction(serverSocket.accept(), outputStreamList);
			transaction.start();
			System.out.println("client joined");
		}

	}

}
