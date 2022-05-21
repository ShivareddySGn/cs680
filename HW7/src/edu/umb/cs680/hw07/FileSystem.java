package edu.umb.cs680.hw07;


import java.util.LinkedList;

public class FileSystem {
	private static FileSystem instance = null;
	private LinkedList<Directory> rootDirs;
	
	private FileSystem() {
		this.rootDirs = new LinkedList<>();
	}
	
	public static FileSystem getFileSystem() {
		if (instance == null) {
			instance = new FileSystem();
		}
		return instance;
	}
	
	public LinkedList<Directory> getRootDirs(){
		return rootDirs;
	}
	
	public void appendRootDir(Directory root) {
		rootDirs.add(root);
	}
}