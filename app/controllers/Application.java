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
    
    //Save a new fiddle
    public static void saveFiddle(html,css,js){
		Fiddle fiddle = new Fiddle(html, css, js);
		fiddle.saveFiddle();
	}

}
