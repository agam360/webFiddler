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
    	Fiddle webFiddle = Fiddle.getFiddle(uuid);
        if (webFiddle == null)
            render("Application/noFiddle.html");
        render("Application/indexEdit.html", webFiddle);
    }

    public static void deleteFiddle(String uuid) {
        Logger.info("Fiddle ID [ %s ]",uuid);
        Fiddle webFiddle = Fiddle.getFiddle(uuid);
        if (webFiddle == null)
            render("Application/noFiddle.html");
        webFiddle.delete();
        index();
    }

    public static void saveFiddle(String uuid, String html, String css, String js){
        Logger.info("Fiddle ID [ %s ]",uuid);
        Fiddle webFiddle = Fiddle.getFiddle(uuid);
        webFiddle.html = html;
        webFiddle.css = css;
        webFiddle.js = js;
        if (webFiddle == null)
            render("Application/noFiddle.html");
        indexEdit(webFiddle.uuid);
    }

    public static void createFiddle(String html, String css, String js) {
	    Fiddle webFiddle = new Fiddle(html, css, js);
	    Logger.info("Fiddle[ %s, %s, %s, %s ]", webFiddle.uuid, html, css, js);
	    webFiddle.save();
	    indexEdit(webFiddle.uuid);
	}

}
