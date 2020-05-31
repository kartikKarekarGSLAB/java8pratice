package com.gslab.java8.regularexpressions;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.html.HTML;

public class HTMLTagExtractor {

	private String regex;
	private Pattern pattern;
	private Matcher matcher;
	
	
	public HTMLTagExtractor() {
		this.regex = "<(\\w+)>(.+)</(\\1)>";
		this.pattern = Pattern.compile(this.regex);
	}
	
	private String getInputFileContent() {
		try {
			byte[] encodes = Files.readAllBytes(Paths.get("index.html"));
			return new String(encodes, StandardCharsets.UTF_8);			
		}  catch (IOException e) {
			System.err.println("Exception while reading file content ::"+e.getMessage());
		}
		return null;
	}
	
	public void getHTMLContent() {
		String content = this.getInputFileContent();
		if(null != content) {
			boolean endOfContent = true;
		      while(endOfContent) {
		    	  System.out.println(content);
		    	  endOfContent = false;
		    	  matcher = pattern.matcher(content);
		    	  while(matcher.find()) {	    		  
		    		  System.out.println("Tag name ::" + matcher.group(1) + ", Tag content :: "+matcher.group(2));
		    		  content = matcher.group(2);
		    		  endOfContent = true;
		    	  }	    	  
		      }			
		}
		
	}
	
	public static void main(String[] args) {
		HTMLTagExtractor app = new HTMLTagExtractor();
		app.getHTMLContent();
	}

}
