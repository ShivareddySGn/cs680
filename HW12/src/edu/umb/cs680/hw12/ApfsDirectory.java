package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsFSElement{
	private LinkedList<ApfsFSElement> children;
	
	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			String lastModifiedTime) {
		super(parent, name, size, creationTime, ownerName, lastModifiedTime);
		this.children = new LinkedList<>();
	}

	public boolean isDirectory() {
		return true;
	}
	
	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}
	
	public LinkedList<ApfsFSElement> getChildren(){
		Collections.sort(this.children, new AlphabeticalComparator());
		return this.children;
	}
	
	public void appendChild(ApfsFSElement child) {
		this.children.add(child);
		child.setParent(this);
		Collections.sort(this.children, new AlphabeticalComparator());
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories() {
		LinkedList<ApfsDirectory> subDirs = new LinkedList<>();
		for (ApfsFSElement e : children) {
			if (e.isDirectory()) {
				ApfsDirectory subDir = (ApfsDirectory)e;
				subDirs.add(subDir);
			}
		}
		Collections.sort(subDirs, new AlphabeticalComparator());
		return subDirs;
	}
	
	public LinkedList<ApfsFile> getFiles(){
		LinkedList<ApfsFile> files = new LinkedList<>();
		for (FSElement e : children) {
			if (e.isFile()) {
				ApfsFile file = (ApfsFile)e;
				files.add(file);
			}
		}
		Collections.sort(files, new AlphabeticalComparator());
		return files;
	}
	
	public LinkedList<ApfsLink> getLinks(){
		LinkedList<ApfsLink> links = new LinkedList<>();
		for (ApfsFSElement fsElement : children) {
			if (fsElement.isLink()) {
				ApfsLink link = (ApfsLink)fsElement;
				links.add(link);
			}
		}
		return links;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for (ApfsFSElement e : children) {
			if (e.isDirectory()) {
				ApfsDirectory subDir = (ApfsDirectory)e;
				totalSize += subDir.getTotalSize();
			}else {
				totalSize += e.getSize();
			}
		}
		return totalSize;
	}
	
	public LinkedList<ApfsFSElement> getChildren(Comparator<ApfsFSElement> comparator){
		Collections.sort(this.children, comparator);
		return this.children;
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsFSElement> comparator) {
		LinkedList<ApfsDirectory> subDirs = getSubDirectories();
		Collections.sort(subDirs, comparator);
		return subDirs;
	}
	
	public LinkedList<ApfsFile> getFiles(Comparator<ApfsFSElement> comparator) {
		LinkedList<ApfsFile> files = getFiles();
		Collections.sort(files, comparator);
		return files;
	}

}