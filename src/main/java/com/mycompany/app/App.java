package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {
    
	public static String[] manipulateStrings(String str1, String str2, ArrayList<Integer> arrayList, Integer[] integerArray) {
	    StringBuilder modifiedStr1 = new StringBuilder(str1);
	    for (int i = 0; i < arrayList.size(); i++) {
	        int index = arrayList.get(i);
	        if (index >= 0 && index < str1.length()) {
	            modifiedStr1.setCharAt(index, str2.charAt(i));
	        }
	    }

	    StringBuilder modifiedStr2 = new StringBuilder(str2);
	    for (int i = 0; i < integerArray.length; i++) {
	        int index = integerArray[i];
	        if (index >= 0 && index < str2.length()) {
	            modifiedStr2.setCharAt(index, str1.charAt(i));
	        }
	    }

	    return new String[]{modifiedStr1.toString(), modifiedStr2.toString()};
	}
    public static void main( String[] args )
    {
    	port(getHerokuAssignedPort());
        get("/", (req, res) -> "Welcome to my program, please enter /compute to end of the link in the address tab above to continue! :)");
        post("/compute", (req, res) -> {
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList1.add(value);
          }
          System.out.println(inputList1);
          
          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);


          String input3 = req.queryParams("input3").replaceAll("\\s","");
          String input4 = req.queryParams("input4").replaceAll("\\s","");


          String[] result = App.manipulateStrings(input3 , input4 ,inputList1, inputList2.toArray(new Integer[inputList2.size()]));

          Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not created yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
