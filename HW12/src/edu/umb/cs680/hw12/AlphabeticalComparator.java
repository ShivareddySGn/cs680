package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsFSElement>{

	public int compare(ApfsFSElement o1, ApfsFSElement o2) {
		return o1.getName().compareTo(o2.getName());
	}

}