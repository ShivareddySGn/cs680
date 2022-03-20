package edu.umb.cs680.hw4;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw4.FIFOFileCache;

class FIFOFileCacheTest {
	private static FIFOFileCache cache;
	private static Path p1;
	private static Path p2;
	private static Path p3;
	private static Path p4;

	
	
		

	@Test
	public void fetchwithp1() throws IOException {
		
			cache = new FIFOFileCache(3);
			p1 = Paths.get("TestingFiles/test1.txt");
			p2 = Paths.get("TestingFiles/test2.txt");
			p3 = Paths.get("TestingFiles/test3.txt");
			p4 = Paths.get("TestingFiles/test4.txt");
			cache.fetch(p1);
			cache.fetch(p2);
			cache.fetch(p3);
		assertEquals(Files.readString(p1), cache.fetch(p1));
		
	}
	
	@Test
	public void fetchwithp2() throws IOException {
		
			cache = new FIFOFileCache(3);
			p1 = Paths.get("TestingFiles/test1.txt");
			p2 = Paths.get("TestingFiles/test2.txt");
			p3 = Paths.get("TestingFiles/test3.txt");
			p4 = Paths.get("TestingFiles/test4.txt");
			cache.fetch(p1);
			cache.fetch(p2);
			cache.fetch(p3);
	
		assertEquals(Files.readString(p2), cache.fetch(p2));
		
	}
	
	@Test
	public void fetchwithp3() throws IOException {
		
			cache = new FIFOFileCache(3);
			p1 = Paths.get("TestingFiles/test1.txt");
			p2 = Paths.get("TestingFiles/test2.txt");
			p3 = Paths.get("TestingFiles/test3.txt");
			p4 = Paths.get("TestingFiles/test4.txt");
			cache.fetch(p1);
			cache.fetch(p2);
			cache.fetch(p3);
	
		assertEquals(Files.readString(p3), cache.fetch(p3));
	}
	
	@Test
	public void fetchwithp4() throws IOException {
		
			cache = new FIFOFileCache(3);
			p1 = Paths.get("TestingFiles/test1.txt");
			p2 = Paths.get("TestingFiles/test2.txt");
			p3 = Paths.get("TestingFiles/test3.txt");
			p4 = Paths.get("TestingFiles/test4.txt");
			cache.fetch(p1);
			cache.fetch(p2);
			cache.fetch(p3);
	
		assertEquals(Files.readString(p4), cache.fetch(p4));
		
	}
}

