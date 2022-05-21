package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsFSElement>{

	public int compare(ApfsFSElement o1, ApfsFSElement o2) {
		return o2.getName().compareTo(o1.getName());
	}

}