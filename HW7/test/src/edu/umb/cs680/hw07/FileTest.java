package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class FileTest {
	private static Directory root;
	private static Directory apps;
	private static Directory bin;
	private static Directory home;
	private static Directory pictures;
	private static File x;
	private static File y;
	private static File a;
	private static File b;
	private static File c;
	private static Link p;
	private static Link q;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		x = new File(apps, "x", 15, LocalDateTime.now());
		y = new File(bin, "y", 10, LocalDateTime.now());
		a = new File(pictures, "a", 5, LocalDateTime.now());
		b = new File(pictures, "b", 20, LocalDateTime.now());
		c = new File(home, "c", 25, LocalDateTime.now());
		p = new Link(home, "p", 0, LocalDateTime.now(), bin);
		q = new Link(pictures, "q", 0, LocalDateTime.now(), y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(p);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(q);
	}
	
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void TestFileEqualToX() {
		String[] expected = { "true", "x", "15", String.valueOf(x.getCreationTime()), "apps" };
		File actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void TestFileEqualToA() {
		String[] expected = { "true", "a", "5", String.valueOf(a.getCreationTime()), "pictures" };
		File actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void CheckifDirectoyTestingWithB() {
		assertFalse(b.isDirectory());
	}
	
	@Test
	public void CheckifFileTestingWithB() {
		assertTrue(b.isFile());
	}
	
	@Test
	public void CheckifLinkTestingWithB() {
		assertFalse(b.isLink());
	}

}