package edu.umkc.idbmscc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
public static void main(String[] args) {
	List<String> list =new ArrayList<String>();
	//add some stuff
	list.add("android is");
	list.add("apple");
	list.add("android is");
	list.add("android");
	String[] stringArray = list.toArray(new String[list.size()]);
	String[] array = new HashSet<String>(Arrays.asList(stringArray)).toArray(new String[0]);
	
	System.out.println(Arrays.toString(array));
	System.out.println(array.length);
}
}
