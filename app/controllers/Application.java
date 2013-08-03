package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.*;

public class Application extends Controller {
	
	//Index route
    public static void index() {
        render("Application/index.html");
        /*Fiddle webFiddle = new Fiddle(html, css, js);
        render("Application/index.html", webFiddle)*/
    }

    public static void indexEdit(String uuid) {
    	Logger.info("Fiddle ID [ %s ]",uuid);
    	Fiddle fiddle = Fiddle.getFiddle(uuid);
        render("Application/indexEdit.html", fiddle);
        /*Fiddle webFiddle = new Fiddle(html, css, js);
        render("Application/index.html", webFiddle)*/
    }

    public static void saveFiddle(String html, String css, String js) {
    	
	    Fiddle webFiddle = new Fiddle(html, css, js);
	    Logger.info("Fiddle[ %s, %s, %s, %s ]",webFiddle.uuid, html, css, js);
	    webFiddle.save();
	    indexEdit(webFiddle.uuid);
	}

}
