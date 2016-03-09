package Model;
import java.util.ArrayList;
import java.util.Collection;




public class FakeDatabase {
	
	ArrayList <String> Data = new ArrayList <String>();
	ArrayList <String> user1 = new ArrayList <String>();
    ArrayList <String> query1 = new ArrayList <String>();
	ArrayList <String> allcourses = new ArrayList <String>();
	 String course = "CS320 MWF 1-150";
	 String course1 = "CS201 MWF 9-950";
	 String username = "mskurla@ycp.edu";
	 
	public  FakeDatabase(){
		Data.addAll(user1);
		Data.addAll(query1);
		Data.addAll(allcourses);
	
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<String> query(Query query){
	query1.addAll((Collection<? extends String>) query.createRegistrar());
	query1.add(course);
	query1.add(course1);
	//System.out.println(query1);
		
	return query1;
		
}
	public void user(User user){
		user1.add(user.getEmailAddress());
		
		
	}
	public void allcourses(Course course){
		allcourses.add(course.toCSVLine());
		
	
}
	
	
		//System.out.print(query1);**/
		
	

	
/**	
	
public static void main(String[] args){
	ArrayList <String> Data = new ArrayList <String>();
	ArrayList <String> user1 = new ArrayList <String>();
	ArrayList <String> Data2 = new ArrayList <String>();
    ArrayList <String> query1 = new ArrayList <String>();
    ArrayList <String> query2 = new ArrayList <String>();
	ArrayList <String> allcourses = new ArrayList <String>();
	 String course = "CS320 MWF 1-150";
	 String course1 = "CS201 MWF 9-950";
	 String course2 = "MAT201 TR 9-950";
	 String course3 = "EGR201 T 11-1150";
	 String course4 ="PSY101 MWF 8-850";
	 String course5 ="CHM101 TR 1-215";	
	 
	 String course00 = "CS320 MWF 1-150";
	 String course21 = "CS201 MWF 9-950";
	 String course12 = "MAT201 TR 9-950";
	 String course33 = "EGR201 T 11-1150";
	 String course44 ="PSY101 MWF 8-850";
	 String course45 ="CHM101 TR 1-215";	
	 
	 String username = "mskurla@ycp.edu";
	 String username2 = "lskurla@ycp.edu";
	//public  FakeDatabase(){
		Data.addAll(user1);
		Data.addAll(query1);
		Data.addAll(allcourses);
		Data.add(username);
		Data2.add(username2);
		
		
	//}
	//@SuppressWarnings("unchecked")
	//public ArrayList<String> query(Query query){
		//query1.addAll((Collection<? extends String>) query.createRegistrar());
		query1.add(course);
		query1.add(course1);
		query1.add(course2);
		query1.add(course3);
		query1.add(course4);
		query1.add(course5);
		
		query2.add(course00);
		query2.add(course12);
		query2.add(course21);
		query2.add(course33);
		query2.add(course44);
		query2.add(course45);
		System.out.println(Data);
		System.out.println(query1);
		System.out.println(Data2);
		System.out.println(query2);
		
//		return query1;
		
	//}
	//public void user(User user){
		//user1.add(user.getEmailAddress());
		user1.add(username);
		
	/**}
	public void allcourses(Course course){
		allcourses.add(course.toCSVLine());
		
	}
	
	
		System.out.print(query1);**/
		
	}


