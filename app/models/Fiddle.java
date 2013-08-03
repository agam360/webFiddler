package models;
import play.*;
//import java.util.*;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import play.db.jpa.*;

@Entity
public class Fiddle extends GenericModel {
	public String html;
	public String css;
	public String js;
	
  	@Id 
    public String uuid;
	
	// Constractor
	public Fiddle(String html, String css, String js){
		this.uuid = java.util.UUID.randomUUID()+"";
		this.html = html;
		this.css = css;
		this.js = js;
	}
	
	// Remove fiddle
	public static void delete(String uuid){
		Fiddle wFiddle = Fiddle.findById(uuid);
		wFiddle.delete();
	}
	
	public static Fiddle getFiddle(String uuid){
		Logger.info("\nGet ID [ %s ]",uuid);
		if(Fiddle.find("uuid", uuid).fetch().size() > 0)
			return (Fiddle)Fiddle.find("uuid", uuid).fetch().get(0);
		else
			return null;
	}	
}
