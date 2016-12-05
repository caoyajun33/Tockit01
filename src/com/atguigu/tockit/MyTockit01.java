package com.atguigu.tockit;


public class MyTockit01 {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class Ticket implements Runnable{
	private int ticket = 30;
	@Override
	public void run() {
		while(true){
			synchronized (this) {
				//notify();
				if(ticket > 0){
					
					System.out.println(Thread.currentThread().getName()+"出售"+ticket--+"剩余"+ticket);
				}else{
					break;
				}
			}
		}
	}
}

