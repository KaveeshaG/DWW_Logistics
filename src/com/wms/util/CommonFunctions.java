package com.wms.util;

import java.util.ArrayList;

public class CommonFunctions {

	
	
	public static String generateIDs(ArrayList<String> arrayList, String prefix) {

		String id;
		int next = arrayList.size();
		next++;
		id = prefix + next;
		while (arrayList.contains(id)) {
			next++;
			id = prefix + next;
		}
		return id;
	}
	
	

}
