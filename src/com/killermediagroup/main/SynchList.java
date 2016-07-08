package com.killermediagroup.main;

import java.io.OutputStream;
import java.util.ArrayList;

public class SynchList {
	
	ArrayList <OutputStream> streams;
	
	public SynchList(){
		streams = new ArrayList<OutputStream>();
	}
	
	synchronized OutputStream getOutputStream(int index){
		return streams.get(index);
	}
	
	synchronized void addOutputStream(OutputStream stream){
		streams.add(stream);
	}
	synchronized void removeOutputStream(int index){
		streams.remove(index);
	}
	synchronized int listSize(){
		return streams.size();
	}
}
