package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementKindComparator implements Comparator<ApfsFSElement>{
	
	private int elementKindToInt(ApfsFSElement o) {
		if (o.isDirectory()) {
			return 0;
		}else if (o.isFile()) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public int compare(ApfsFSElement o1, ApfsFSElement o2) {
		return elementKindToInt(o1) - elementKindToInt(o2);
	}

}