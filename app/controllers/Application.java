package controllers;

import play.*;
import play.mvc.*;
import java.util.*;

import models.*;

public class Application extends Controller {
	
	//Index route
    public static void index() {
        render("Application/index.html");
    }

    public static void indexEdit(String uuid) {
    	Logger.info("Fiddle ID [ %s ]",uuid);
    	Fiddle fiddle = Fiddle.getFiddle(uuid);
        if (fiddle == null)
            render("Application/noFiddle.html");
        render("Application/indexEdit.html", fiddle);
    }

    public static void deleteFiddle(String uuid) {
        Logger.info("Fiddle ID [ %s ]",uuid);
        Fiddle fiddle = Fiddle.getFiddle(uuid);
        if (fiddle == null)
            render("Application/noFiddle.html");
        fiddle.delete();
        index();
    }

    public static void saveFiddle(String html, String css, String js) {
	    Fiddle webFiddle = new Fiddle(html, css, js);
	    Logger.info("Fiddle[ %s, %s, %s, %s ]",webFiddle.uuid, html, css, js);
	    webFiddle.save();
	    indexEdit(webFiddle.uuid);
	}

}
