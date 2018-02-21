import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> list= new ArrayList<Student>();
	/**
	 * Takes the file name and then reads the data from file and stores students in list
	 * @param s is the file name
	 */
	public void loadDataFromFile(String s) {
		
		FileReader reader = null;
		
		try {
			reader = new FileReader(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()){
		String str = in.nextLine();
		//in.nextLine();
		int score = Integer.parseInt(in.nextLine());
		Student stu = new Student(str,score);
		list.add(stu);
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
		
		
	}
	public void processFiles() {
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	
	public static void main(String[] args) {
		
		ScoreTrakker scores= new ScoreTrakker();
		scores.processFiles();
		
		
	}
}
