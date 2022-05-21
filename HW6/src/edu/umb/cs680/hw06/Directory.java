package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{
	private LinkedList<FSElement> children;
	
	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		this.children = new LinkedList<>();
	}
	
	public boolean isDirectory() {
		return true;
	}
	
	public LinkedList<FSElement> getChildren(){
		return this.children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> subDirs = new LinkedList<>();
		for (FSElement fsElement : children) {
			if (fsElement.isDirectory()) {
				Directory subDir = (Directory)fsElement;
				subDirs.add(subDir);
			}
		}
		return subDirs;
	}
	
	public LinkedList<File> getFiles(){
		LinkedList<File> files = new LinkedList<>();
		for (FSElement fsElement : children) {
			if (!fsElement.isDirectory()) {
				File file = (File)fsElement;
				files.add(file);
			}
		}
		return files;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement fsElement : children) {
			if (fsElement.isDirectory()) {
				Directory subDir = (Directory)fsElement;
				totalSize += subDir.getTotalSize();
			}else {
				totalSize += fsElement.getSize();
			}
		}
		return totalSize;
	}

}