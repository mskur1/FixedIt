package HTMLParse.proofOfConcept.youCanDeleteThisAfterWeImplementRegistrar;

import java.util.ArrayList;

public class Course {
	private int CRN, capacity, seatsRemain, seatsFilled;
	double credits;
	private String courseAndSection, title, type, days, time, beginEnd;
	private ArrayList<String> instructors, locations;
	
	public Course(int CRN, String courseAndSection, String title, double credits, String type, String days, 
			String time, String location, String instructor, int capacity, int seatsRemain, 
			int seatsFilled, String beginEnd){
		this.CRN=CRN;
		this.credits=credits;
		this.capacity=capacity;
		this.seatsRemain=seatsRemain;
		this.seatsFilled=seatsFilled;
		this.courseAndSection=courseAndSection;
		this.title=title;
		this.type=type;
		this.days=days;
		this.time=time;
		instructors=new ArrayList<String>();
		instructors.add(instructor);
		locations=new ArrayList<String>();
		this.locations.add(location);
		this.beginEnd=beginEnd;
	}
	@Override
	public String toString() {
		return "Course [CRN=" + CRN + ", courseAndSection=" + courseAndSection + ", title=" + title + ", credits="
				+ credits + ", type=" + type + ", days=" + days + ", time=" + time + ", locations=" + locations
				+ ", instructors=" + instructors + ", capacity=" + capacity + ", seatsRemain=" + seatsRemain
				+ ", seatsFilled=" + seatsFilled + ", beginEnd=" + beginEnd + "]";
	}
	public Course(){
		locations=new ArrayList<String>();
		instructors=new ArrayList<String>();
	}
	
	
	public void addInstructor(String instructor){
		instructors.add(instructor);
	}
	public void addLocation(String location){
		locations.add(location);
	}
	public String getBeginEnd() {
		return beginEnd;
	}
	public void setBeginEnd(String beginEnd) {
		this.beginEnd = beginEnd;
	}
	public ArrayList<String> getInstructors() {
		return instructors;
	}
	public void setInstructors(ArrayList<String> instructors) {
		this.instructors = instructors;
	}
	public int getCRN() {
		return CRN;
	}
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}
	public double getCredits() {
		return credits;
	}
	public void setCredits(double d) {
		this.credits = d;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getSeatsRemain() {
		return seatsRemain;
	}
	public void setSeatsRemain(int seatsRemain) {
		this.seatsRemain = seatsRemain;
	}
	public int getSeatsFilled() {
		return seatsFilled;
	}
	public void setSeatsFilled(int seatsFilled) {
		this.seatsFilled = seatsFilled;
	}
	public String getCourseAndSection() {
		return courseAndSection;
	}
	public void setCourseAndSection(String courseAndSection) {
		this.courseAndSection = courseAndSection;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getLocation() {
		return locations;
	}
	public void setLocation(ArrayList<String> locations) {
		this.locations = locations;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
