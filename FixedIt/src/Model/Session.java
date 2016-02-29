package Model;

import java.util.ArrayList;

public class Session {
	private User user;
	private ArrayList<Query> sessionSearchHistory;
	
	public Session(User user){
		this.user=user;
		sessionSearchHistory=new ArrayList<Query>();
	}
	
	public User getCurrentUser(){
		return user;
	}
	
	public ArrayList<Query> getSessionSearchHistory(){
		return sessionSearchHistory;
	}
	
	public void logout(){
		user.dispose();
		sessionSearchHistory=null;
	}
}
