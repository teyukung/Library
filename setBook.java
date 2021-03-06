import java.util.StringTokenizer;

public class setBook{
	public String name,writer,publish,year,number,term;
    public String score;
	public setBook(){
		name = "";
		writer = "";
		publish = "";
		year = "";
		number = "";
		term = "";
	    score = "";
	}
		
	public setBook(String line){
		dividLine(line);
	}
	
	public setBook(String inname, String inwriter, String inpublish, String inyear, String innumber, String interm){
		name = inname;
		writer =inwriter;
		publish = inpublish;
		year = inyear;
		number = innumber;
		term = interm;
		score = "";
	}
	
	public void setScore(String inscore){
		score = inscore;
	}

	public void setName(String theName){
		name = theName;
	}

	public void setWriter(String theWriter){
		writer = theWriter;
	}
	
	public void setPublish(String thePublish){
		publish = thePublish;
	}
	
	public void setYear(String theYear){
		year = theYear;
	}
	
	public void setNumber(String theNumber){
		number = theNumber;
	}
	
	public void setTerm(String theTerm){
		term = theTerm;
	}

	public String getName(){
		return name;
	}
	
	public String getWriter(){
		return writer;
	}
	
	public String getPublish(){
		return publish;
	}
	
	public String getYear(){
		return year;
	}

	public String getNumber(){
		return number;
	}

	public String getTerm(){
		return term;
	}
	
	public void dividLine(String line){
		StringTokenizer st = new StringTokenizer(line);
		name = st.nextToken();
		writer = st.nextToken();
		publish = st.nextToken();
		year = st.nextToken();
		number = st.nextToken();
		term = st.nextToken();
		if(st.hasMoreTokens()){
				setScore(st.nextToken());
		}
		else
			score="";
	}

	public void printLine(){
		System.out.printf("%-16s  %-8s  %-16s  %-8s  %-6s  %-6s  %s",name,writer,publish,year,number,term,score);
		if(!(name.equals("")))
			System.out.print("\r\n");
	}
	
	public String outLine(){
		if(!(name.equals("")))
			return String.format("%-16s  %-8s  %-16s  %-8s  %-6s  %-6s  %s\r\n",name,writer,publish,year,number,term,score);
		else
			return null;
		
	}
}
