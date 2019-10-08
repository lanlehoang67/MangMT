public class NoSync extends Thread{
	 Sync a = new Sync();
	 public void Run() {
		 synchronized(a) {
			 a.Display();
		 }
		 
	 }
	 public static void main(String[] args) {
			NoSync a = new NoSync();
			NoSync b = new NoSync();
		}
}
 class Sync extends Thread {
	 public void Display() {
		 for(int i =0;i<10;i++) {
			 System.out.println(i);
			 try {
				 Thread.sleep(1000);
			 }
			 catch(Exception e) {}
		 }
	 }
		
	}
