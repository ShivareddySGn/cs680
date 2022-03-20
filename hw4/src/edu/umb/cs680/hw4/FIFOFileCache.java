package edu.umb.cs680.hw4;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedHashMap;

public class FIFOFileCache extends FileCache{
	private int scope;
	
	public FIFOFileCache(int scope) {
		this.scope = scope;
		cache = new LinkedHashMap<>();
	}

	protected boolean isCached(Path path) {
		if(cache.containsKey(path)) {
			return true;
		}else {
			return false;
		}
	}

	protected boolean isCacheFull() {
		if(cache.size() == scope) {
			return true;
		}else {
			return false;
		}
	}

	protected void cacheFile(Path path) {
		try {
			String matter = Files.readString(path);
			cache.put(path, matter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void replace(Path path) {
		try {
			String matter = Files.readString(path);
			Path deleteKey = cache.keySet().iterator().next();
			cache.remove(deleteKey);
			cache.put(path, matter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}