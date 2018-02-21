import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> list= new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscores.txt", "nofile.txt" };
	/**
	 * Takes the file name and then reads the data from file and stores students in list
	 * @param s is the file name
	 */
	public void loadDataFromFile (String s) throws FileNotFoundException {
		
		FileReader reader = null;
		
		
			reader = new FileReader(s);
		
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()){
		String scorecatch= "";
		String str="";
		
		
		//in.nextLine();
		try{
			
			
			
		str = in.nextLine();
		scorecatch= in.nextLine();
		int score = Integer.parseInt(scorecatch);
		Student stu = new Student(str,score);
		list.add(stu);
		}catch( NumberFormatException score ){
			System.out.println("Incorrect format for "+ str + " not a valid score: "+ scorecatch);
		}
		
		}
		
		
	}
	/**
	 * This will sort and print our array list of students
	 */
	public void printInOrder(){
		//SORT
		Collections.sort(list);
		
		//PRINT
		for(Student x: list){
			System.out.println(x);
		}
		
		list.clear();
	}
	public void processFiles() {
		
		String iofile="";
		for(String s: files){
			try{
			iofile=s;
			loadDataFromFile(s);
			printInOrder();
			}catch(FileNotFoundException e){
				System.out.println("Can't open File: "+ s);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		ScoreTrakker scores= new ScoreTrakker();
		scores.processFiles();
		
		
	}
}
