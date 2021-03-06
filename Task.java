import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Task {
	private int count = 0, tmp = 0, choose;
	private int[] a = new int[128];
	private String select,keyword,score;
	private Scanner sc = new Scanner(System.in);
	private String name,writer,publish,year,number,term,read;
	public String start = "書名　　　　　　　作者　　　出版社　　　　　　出版年份　編號　　分類    評分";
	public setBook[] b = new setBook[128];
			
			
	public void openFile()throws IOException{
		
		for(int i=0;i<128;i++){
				b[i] = new setBook();
				a[i] = 128;
		}

		BufferedReader File = new BufferedReader(new FileReader("book.txt"));//openfile
		
		try{
			File.readLine();
			for(read = File.readLine();read != null ;read = File.readLine()){
					b[count++] =new setBook(read);
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		finally{
			File.close();
		}
	}

	public void Add(){
		System.out.println("==========================================================================");
		System.out.println("book name: ");
		name = sc.nextLine();
		System.out.println("Writer: ");
		writer = sc.nextLine();
		System.out.println("Publish: ");
		publish = sc.nextLine();
		System.out.println("Year: ");
		year = sc.nextLine();
		System.out.println("NO.: ");
		number = sc.nextLine();
		System.out.println("Term: ");
		term = sc.nextLine();

		if(checkData(year,number))
			b[count++] = new setBook(name,writer,publish,year,number,term);
		else{
			System.out.println("Year or Number are illegal.\r\nPlease enter again!");
			Add();
		}
			
	}
	
	public boolean checkData(String inyear,String innumber){
		
		if(inyear.matches("[0-9]{4}"))
			if((Integer.parseInt(inyear) > 1900) && (Integer.parseInt(inyear) < 2017))
				if((innumber.substring(0,1)).matches("[a-z[A-Z]]"))
					if((innumber.substring(1)).matches("[0-9]{5}"))
						return true;
						
		return false;
					
	}
	
	public void search(){
		System.out.println("==========================================================================");
		System.out.println("1.name\n\r2.writer\n\r3.publish");
		select = sc.nextLine();
		for(;;select = sc.next()){
			switch(select){
				case "1":searchName();break;
				case "2":searchWriter();break;
				case "3":searchPublish();break;
				default:System.out.println("Worng input!\n\rPlease try again\n\r\n\r1.name\n\r2.writer\n\r3.publish");
			}
			if(select.equals("1") || select.equals("2") || select.equals("3"))
				break;
			
		}
	}
	
	public void searchName(){
		tmp = 0;
		System.out.println("Please enter the book name you want to search: ");
		keyword = sc.nextLine();
		for(int i = 0 ;i < count ;i++ ){
			if((b[i].name).equals(keyword)){
				a[tmp] = i;
				tmp++;
			}
		}
		if(tmp == 0)
			System.out.println("Can't find suitable file!");
		else{
			System.out.println("==========================================================================");
			System.out.println(start);			
			for(int i = 0; i < tmp ; i++)
				b[a[i]].printLine();
		}
		
	}

	public void searchWriter(){
		tmp = 0;
		System.out.println("Please enter the book name you want to search: ");
		keyword = sc.nextLine();
		for(int i = 0 ;i < count ;i++ ){
			if((b[i].writer).equals(keyword)){
				a[tmp] = i;
				tmp++;
			}
		}
		if(tmp == 0)
			System.out.println("Can't find suitable file!");
		else{
			System.out.println("==========================================================================");
			System.out.println(start);
			for(int i = 0; i < tmp ; i++)
				b[a[i]].printLine();
		}
	}
	
	public void searchPublish(){
		tmp = 0;
		System.out.println("Please enter the book name you want to search: ");
		keyword = sc.nextLine();
		for(int i = 0 ;i < count ;i++ ){
			if((b[i].publish).equals(keyword)){
				a[tmp] = i;
				tmp++;
			}
		}
		if(tmp == 0)
			System.out.println("Can't find suitable file!");
		else{
			System.out.println("==========================================================================");
			System.out.println(start);
			for(int i = 0; i < tmp ; i++)
				b[a[i]].printLine();
		}
	}
		
	public void readFile(){
		System.out.println("==========================================================================");
		System.out.println("1.All   2.Name   3.Writer   4.Year   5.Publish   6.Number   7.Term   8.Score");
		select = sc.nextLine();
		switch (select){			
			case "1":printFile();break;
			case "2":printName();break;
			case "3":printWriter();break;
			case "4":printYear();break;
			case "5":printPublish();break;
			case "6":printNumber();break;
			case "7":printTerm();break;
			case "8":printScore();break;
			default:
		}
	}

	public void printFile(){
		System.out.println("==========================================================================");
		System.out.print(start + "\r\n");
		for(int i = 0 ;i < count ; i++){
			b[i].printLine();
		
		}
	}
	
	public void printName(){
		System.out.println("==========================================================================");
		System.out.print("書名 \r\n");
		for(int i = 0 ;i < count ; i++){
			System.out.println(b[i].name);
		}
	}
	
	public void printWriter(){
		System.out.println("==========================================================================");
		System.out.print("作者 \r\n");
		for(int i = 0 ;i < count ; i++){
			System.out.println(b[i].writer);
		}
	}
	
	public void printPublish(){
		System.out.println("==========================================================================");
		System.out.print("出版社 \r\n");
		for(int i = 0 ;i < count ; i++){
			System.out.println(b[i].publish);
		}
	}
	
	public void printYear(){
		System.out.println("==========================================================================");
		System.out.print("出版年份 \r\n");
		for(int i = 0 ;i < count ; i++){
			System.out.println(b[i].year);
		}
	}
	
	public void printNumber(){
		System.out.println("==========================================================================");
		System.out.print("編號 \r\n");
		for(int i = 0 ;i < count ; i++){
			System.out.println(b[i].number);
		}
	}

	public void printTerm(){
		System.out.println("==========================================================================");
		System.out.print("分類 \r\n");
		for(int i = 0 ;i < count ; i++){
			System.out.println(b[i].term);
		}
	}
	
	public void printScore(){
		System.out.println("==========================================================================");
		System.out.print("評分 \r\n");
		for(int i = 0 ;i < count ; i++){
			System.out.println(b[i].score);
		}
	}

	public void outFile()throws IOException{
		FileWriter fw1 = new FileWriter("book.txt");
		fw1.write(start + "\r\n");
		//8-4-8-4-3
		for(int i = 0; i < count; i++)
			fw1.write(b[i].outLine());

		fw1.flush();
		fw1.close();
	}
	
	public void modify(){
		tmp = 0;
		System.out.println("==========================================================================");
		printName();
		System.out.println("Enter the name of book you want to modify");
		keyword = sc.nextLine();
		for(int i = 0 ;i < count ;i++ ){
			if((b[i].name).equals(keyword)){
				a[tmp] = i;
				tmp++;
			}
		}
		if(tmp == 0)
			System.out.println("Can't find suitable file!");
		else{
			System.out.println("==========================================================================");
			System.out.print("  " + start + "\r\n");
			for(int i = 0;i < tmp; i++){
				System.out.print((i+1) + ".");
				b[a[i]].printLine();
			}
			System.out.println("==========================================================================");
			System.out.println("Which data do you want to modify?");
			keyword = sc.nextLine();
			choose = Integer.parseInt(keyword);

			if((--choose) < tmp){
				System.out.println("book name: ");
				name = sc.nextLine();
				System.out.println("Writer: ");
				writer = sc.nextLine();
				System.out.println("Publish: ");
				publish = sc.nextLine();
				System.out.println("Year: ");
				year = sc.nextLine();
				System.out.println("NO.: ");
				number = sc.nextLine();
				System.out.println("Term: ");
				term = sc.nextLine();
				
				b[a[choose]] = new setBook(name,writer,publish,year,number,term);
			}
				
		}
		
	}
	
	public void deletData(){
		tmp = 0;
		System.out.println("==========================================================================");
		printName();
		System.out.println("Enter the name of book you want to delet");
		keyword = sc.nextLine();
		for(int i = 0 ;i < count ;i++ ){
			if((b[i].name).equals(keyword)){
				a[tmp] = i;
				tmp++;
			}
		}
		if(tmp == 0)
			System.out.println("Can't find suitable file!");
		else{
			System.out.println("==========================================================================");
			System.out.print("  " + start + "\r\n");
			for(int i = 0;i < tmp; i++){
				System.out.print((i+1) + ".");
				b[a[i]].printLine();
			}
			System.out.println("==========================================================================");
			System.out.println("Which data do you want to delet?");
			keyword = sc.nextLine();
			choose = Integer.parseInt(keyword);
			
			b[a[--choose]] = new setBook();
			count--;
			for(int i = a[choose];i < count;)
				b[i++] = b[i];
		}
	}

	public void addScore(){
		tmp = 0;
		System.out.println("==========================================================================");
		printName();
		System.out.println("\r\nWhich book you want to score?");
		keyword = sc.nextLine();
		for(int i = 0 ;i < count ;i++ ){
			if((b[i].name).equals(keyword)){
				a[tmp] = i;
				tmp++;
				
			}
		}
		if(tmp == 0)
			System.out.println("Can't find suitable file!");
		else{
			System.out.println("==========================================================================");
			System.out.print("  " + start + "\r\n");
			for(int i = 0;i < tmp; i++){
				System.out.print((i+1) + ".");
				b[a[i]].printLine();
			}
			System.out.println("==========================================================================");
			System.out.println("Which data do you want to score?");
			keyword = sc.nextLine();
			choose = Integer.parseInt(keyword);
        
			if(((--choose) < tmp) &&(choose >= 0)){
				System.out.println("new score");
				score = sc.nextLine();
			    
				if(isScore(score)){
					
					b[a[choose]].setScore(score);}
				else{
					System.out.println("\r\nInput Error!\r\nPlease try again\r\n");
					addScore();
				}
			}
			else
				System.out.println("Can't find suitable file!");	
		}
	}
	
	public boolean isScore(String inscore){
		if(Integer.parseInt(score)==10)
			return true;
		else if((score.matches("[0-9]{1}")))
					return true;
		else
			return false;
	}
}

