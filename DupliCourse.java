package assignment_3;

public class DupliCourse {

	public static void main(String[] args) {
        Course course1 = new Course("Java");

        course1.addStudents("stu1");
        course1.addStudents("stu2");
        course1.addStudents("stu3");
        course1.addStudents("stu4");

        Course course2 = (Course)course1.clone();
        course2.addStudents("stu5");           //调用add方法添加一个学生以检验是否复制成功
        System.out.println("Course1学生人数： " + course1.getNumberOfStudents());
        System.out.println("复制Course1并添加学生后的Course2人数：" + course2.getNumberOfStudents());
    }
}

class Course implements Cloneable {
	private String courseName;
	private String[] students = new String[100]; 
	private int numOfStudents;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void addStudents(String student) {
		students[numOfStudents] = student;
		numOfStudents++;
	}
	
	public String[] getStudents() {
		return students;		
	}
	
	public int getNumberOfStudents() {
		return numOfStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}
		
	
	public Object clone() {
		try {
	    	Course course = (Course) super.clone();
	    	course.courseName = courseName;
	    	course.numOfStudents = numOfStudents;
	    	course.students = students.clone();
	    	return course;
    	} catch (CloneNotSupportedException ex) {
    		return null;
    	}
	}
}

	
	

