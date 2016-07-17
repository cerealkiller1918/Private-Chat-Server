package com.killermediagroup.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Transaction extends Thread {

	private SynchList outputStreamList;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	public Transaction(Socket socket, SynchList outputStreamList){
		this.outputStreamList = outputStreamList;
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			outputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		outputStreamList.addOutputStream(outputStream);
	}
	
	public void run(){
		try{
			int input;
			while((input = inputStream.read())!= -1){
				for(int i = 0; i < outputStreamList.listSize(); i++){
					try{
					outputStreamList.getOutputStream(i).write(input);
					outputStreamList.getOutputStream(i).flush();
					System.out.print((char)input);
					}catch(Exception e){
						outputStreamList.removeOutputStream(i);
						System.out.println("Client left the chat");
					}
				}
			}
			
		}catch(Exception e){
			
		}
	}
	
}
