import java.util.Scanner;
import java.io.IOException;

public class BookDemo{
	public static void main(String[] args) throws IOException{
		
		String account = "", password = "", mod = "", task="";
		Task t = new Task();
		Scanner sr = new Scanner(System.in);

		for(int i = 0;(!(account.equals("cis"))||!(password.equals("1234")))&& i < 3;i++){
			System.out.printf("Account: ");
			account = sr.nextLine();
			System.out.printf("Password: ");
			password = sr.nextLine();

			if(!(account.equals("cis"))|| !(password.equals("1234"))){
				System.out.printf("account or password error!\r\nYou can only try only 3 times!\r\n\r\n");
				if(i==2)
					System.exit(0);
			}
			
			
		}//login system
		
		t.openFile();
		
		while(true){

			System.out.println("==========================================================================");
			System.out.printf("\r\nEnter A for user mode        Enter B for manger mode\r\n");
			mod = sr.nextLine();//User mode or Manger mode
System.out.println("1");			
			if( mod.equalsIgnoreCase("A") ){
				while(true){
					System.out.println("==========================================================================");
					System.out.printf("\r\nSelect what you want to do\r\n");
					System.out.printf("1.add   2.modify   3.delete   4.read   5.search   6.score   7.back   8.exit\r\n");
					task = sr.nextLine();
					switch(task){
						case "1":t.Add();break;
						case "2":t.modify();break;
						case "3":t.deletData();break;
						case "4":t.readFile();break;
						case "5":t.search();break;
						case "6":t.addScore();break;
						case "7":break;
						case "8":t.outFile();System.exit(0);
						default:System.out.println("\r\nInput Error!\r\nPlease try again\r\n");
					}
					if(task.equals("7"))
						break;
				}
			}
			else if(mod.equalsIgnoreCase("B")){
				while(true){
					
					System.out.println("==========================================================================");
					System.out.printf("Select what you want to do\r\n");
					System.out.println("1.Sort    2.Data reorganization   3.back   4.exit");
					task = sr.nextLine();
					
						switch(task){
							case "1":break;
							case "2":break;
							case "3":break;
							case "4":t.outFile();System.exit(0);
							default:System.out.println("\r\nInput Error!\r\nPlease try again\r\n");
						}
						
						if(task.equals("3"))
							break;	
				}
			}
			else{
				System.out.println("Input Error!\r\nPlease try again\r");
			}
		
		}
				
	}
}