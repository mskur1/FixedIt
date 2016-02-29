package Model;

import java.util.ArrayList;

public class Schedule {
	
	public ArrayList<Course> courses;
	public String name;
	
	public Schedule(String name, ArrayList<Course> courses){
		this.name=name;
		this.courses=courses;
	}
	
	public Schedule(String name){
		this.name=name;
		courses=new ArrayList<Course>();
	}
	
	public void addCourse(Course course){
		if(!conflictsWithCourse(course)){
			courses.add(course);
		}
		else{
			throw new IllegalArgumentException("Course conflicts with schedule.");
		}
	}
	
	public void addCourses(Course... coursesToAdd){
		for(Course c : coursesToAdd){
			addCourse(c);
		}
	}
	
	public int getCredits(){
		int credits=0;
		for(Course c : courses){
			credits+=c.getCredits();
		}
		return credits;
	}
	
	/**
	 * Checks whether a course has a time/day conflict
	 * with any courses currently on the schedule
	 * @param course the course for which to check for conflicts
	 * @return boolean
	 */
	public boolean conflictsWithCourse(Course course){
		if(timeConflicts(course)){
			for(Course c : courses){
				char[] cDays=c.getDays().toCharArray();
				for(int i=0; i<cDays.length; i++){
					if(Character.isLetter(cDays[i])){
						if(course.getDays().contains(Character.toString(cDays[i]))){
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * checks strictly for time conflicts; DOES NOT CHECK FOR DAY CONFLICTS
	 * @param course the course for which to check for conflicts
	 * @return boolean
	 */
	public boolean timeConflicts(Course course){
		TimeInterval courseTime=course.getTimeAsTimeInverval();
		for(Course c : courses){
			TimeInterval cTime=c.getTimeAsTimeInverval();
			if(courseTime.getStart()==cTime.getStart() || courseTime.getEnd()==cTime.getEnd()){
				return true;
			}
			else if(courseTime.getStart()<cTime.getStart()){
				if(courseTime.getEnd()>=cTime.getStart()){
					return true;
				}
			}
			else if(cTime.getStart()<courseTime.getStart()){
				if(cTime.getEnd()>=courseTime.getStart()){
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
