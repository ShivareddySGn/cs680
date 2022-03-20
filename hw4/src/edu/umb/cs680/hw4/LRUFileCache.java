package edu.umb.cs680.hw4;

import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedHashMap;

public class LRUFileCache extends FileCache{
	private int scope;
	
	public LRUFileCache(int capacity) {
		this.scope = capacity;
		cache = new LinkedHashMap<>(capacity, 0.75f, true);
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

	@Override
	protected void cacheFile(Path path) {
		try {
			String matter = Files.readString(path);
			cache.put(path, matter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
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
