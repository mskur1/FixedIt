package Model;

public class Course {
	private int CRN, credits, capacity, seatsRemain, seatsFilled;
	private String courseAndSection, title, type, location, days, time;
	
	public Course(int CRN, int credits, int capacity, int seatsRemain, int seatsFilled, String courseAndSection, String title, String type, String location, String days, String time){
		this.CRN=CRN;
		this.credits=credits;
		this.capacity=capacity;
		this.seatsRemain=seatsRemain;
		this.seatsFilled=seatsFilled;
		this.courseAndSection=courseAndSection;
		this.title=title;
		this.type=type;
		this.location=location;
		this.days=days;
		this.time=time;
	}
	public Course(){
		System.out.print("Course object created.");
	}
	public int getCRN() {
		return CRN;
	}
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
