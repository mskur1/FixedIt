package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Registrar {
	String URL;
	public Registrar(String URL){
		this.URL=URL;
	}
	
	public ArrayList<Course> fetch() throws IOException{
		String sourceHTML=getUrlSource(URL);
		String[] lines=getLinesFromHTML(sourceHTML);
		return parseCSVLines(lines);
	}
	
	private String getUrlSource(String url) throws IOException {
        URL link = new URL(url);
        URLConnection connection = link.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        return a.toString();
    }
	
	private ArrayList<Course> parseCSVLines(String[] lines){
		ArrayList<Course> courses=new ArrayList<Course>();
		for(int i=0; i<lines.length; i++){
			String[] data=lines[i].split(",");
			Course course=new Course();
			if(data[0].matches("[A-Za-z0-9]+")){
				if(data[4].contains("TUT") || data[4].contains("IND")){
					course.setCRN(Integer.parseInt(data[0]));
					course.setCourseAndSection(data[1]);
					course.setTitle(data[2]);
					course.setCredits(Double.parseDouble(data[3]));
					course.setType(data[4]);
					course.setTime(data[5]);
					course.addLocation(data[6]);
					course.addInstructor(data[7]);
					course.setCapacity(Integer.parseInt(data[8].substring(1)));
					course.setSeatsRemain(Integer.parseInt(data[9].substring(1)));
					course.setSeatsFilled(Integer.parseInt(data[10].substring(1)));
					course.setBeginEnd(data[11]);
				}
				else{
					course.setCRN(Integer.parseInt(data[0]));
					course.setCourseAndSection(data[1]);
					course.setTitle(data[2]);
					course.setCredits(Double.parseDouble(data[3]));
					course.setType(data[4]);
					course.setDays(data[5]);
					course.setTime(data[6]);
					course.addLocation(data[7]);
					course.addInstructor(data[8]);
					course.setCapacity(Integer.parseInt(data[9].substring(1)));
					course.setSeatsRemain(Integer.parseInt(data[10].substring(1)));
					course.setSeatsFilled(Integer.parseInt(data[11].substring(1)));
					course.setBeginEnd(data[12]);
				}
				
				courses.add(course);
			}
			else {
				if(data[8].matches("[A-Za-z0-9]+")){
					courses.get(i-1).addInstructor(data[8]);	
				}
				if(data[7].matches("[A-Za-z0-9]+")){
					courses.get(i-1).addLocation(data[7]);
				}
			}
		}
		
		return courses;
	}
	
	private String[] getLinesFromHTML(String sourceHTML){
		sourceHTML=sourceHTML.substring(sourceHTML.lastIndexOf("<table  class="));
		sourceHTML=sourceHTML.substring(0, sourceHTML.lastIndexOf("</table>")+8);
		 Document doc = Jsoup.parseBodyFragment(sourceHTML);
		 Elements rows = doc.getElementsByTag("tr");
		 String csv="";
		 for (Element row : rows) {
			 Elements cells = row.getElementsByTag("td");
			 for (Element cell : cells) {
				 csv=csv+cell.text().concat(", ");
			 }
			 csv=csv+"\n";
		 }
		 csv=csv.substring(csv.indexOf('\n'));
		 csv=csv.replace(" view book info", "");
		 csv=csv.substring(1);
		 String[] lines=csv.split("\\n");
		 return lines;
	}
}
