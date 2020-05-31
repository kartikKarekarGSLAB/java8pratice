package com.gslab.java8.baisc.practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution{

	public static void main(String[] args) {
//	      String str = "The lettes kartik are so long Kartik karekarekar    kartik    kArTIk 	karekar KARekar kaRTIK";
//	      String str = "kartik KArtik KARTIK Kartik KArtik The the string kaRTik String string stringing.";
		  String str = "<html>     <head>         <title>Example</title>     </head>     <body>         <p>This is an example of a simple HTML page with one paragraph.</p>     </body> </html>";	
	      System.out.println("Content ="+str);
	      boolean endOfContent = true;
	      Pattern pattern = Pattern.compile("<(\\w+)>(.+)</(\\1)>", Pattern.CASE_INSENSITIVE);
	      
	      while(endOfContent) {
	    	  
	    	  endOfContent = false;
	    	  Matcher matcher = pattern.matcher(str);
	    	  while(matcher.find()) {	    		  
	    		  System.out.println("Tag name ::" + matcher.group(1) + ", Tag content :: "+matcher.group(2));
	    		  str = matcher.group(2);
	    		  endOfContent = true;
	    	  }	    	  
	      }
	      
	   }
}
