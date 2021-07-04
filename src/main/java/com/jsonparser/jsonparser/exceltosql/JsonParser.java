package com.jsonparser.jsonparser.exceltosql;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.jsonparser.jsonparser.util.JFlat;
//import com.github.opendevl.JFlat;

public class JsonParser {

	public static void main(String[] args) throws Exception {
		String str = new String(
				Files.readAllBytes(Paths.get("E://GitProjects//jsonparser//jsonparser//testing//test4.json")));

		JFlat flatMe = new JFlat(str);

		// get the 2D representation of JSON document
		flatMe.json2Sheet().headerSeparator(".").getJsonAsSheet();

		// write the 2D representation in csv format
		flatMe.write2csv("E://GitProjects//jsonparser//jsonparser//testing//test4.csv");
	}
}
