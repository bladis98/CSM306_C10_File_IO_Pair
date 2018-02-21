
public class Student implements Comparable<Student>{
	private String name;
	private int score;
	@Override
	public String toString() {
		return name + " " + score;
	}

	

	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}




	public int compareTo(Student kid) {
		int returnVal;
		if(score< kid.score ){
			returnVal= -1;
		}else if(score>kid.score){
			returnVal=1;
		}else{
			returnVal=0;
		}
		return returnVal;
	}
}
