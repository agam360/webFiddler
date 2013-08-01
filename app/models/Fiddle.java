package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
//import play.db.jpa.*;

@Entity
public class Fiddle extends Model{
	public String htmlData;
	public String cssData;
	public String jsData;
	
	@Id
	public Integer id;
	
	public static Finder<Integer, Fiddle> find = new Finder(
		Integer.class, Fiddle.class
	);
	
	// Constractor
	public Fiddle(String html, String css, String js){
		this.htmlData = html;
		this.cssData = css;
		this.jsData = js;
	}
	
	// Get all fiddles
	public static List<Fiddle> all(){
		return find.all();
	}
	
	// Remove fiddle
	public static void delete(Integer id){
		find.ref(id).delete();
	}
	
	// Return the HTML of the fiddle
	public String getHtml(){
		String data = this.htmlData;
		if(data.length()>0){
			return data;
		}
	}
	
	// Return the CSS of the fiddle
	public String getCss(){
		String data = this.cssData;
		if(data.length()>0){
			return data;
		}
	}
	
	// Return the Javascript of the fiddle
	public String getJs(){
		String data = this.jsData;
		if(data.length()>0){
			return data;
		}
	}
	
	
}
