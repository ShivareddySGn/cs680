package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.ApfsDirectory;
import edu.umb.cs680.hw14.ApfsFile;
import edu.umb.cs680.hw14.ApfsLink;

public class ApfsFileTest {
	private static ApfsDirectory root, apps, bin, home, pictures;
	private static ApfsFile x, y, a, b, c;
	private static ApfsLink m, n;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "kevin", "7:00");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "kevin", "7:00");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "kevin", "7:00");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "kevin", "7:00");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "kevin", "7:00");
		x = new ApfsFile(apps, "x", 10, LocalDateTime.now(), "kevin", "7:00");
		y = new ApfsFile(bin, "y", 20, LocalDateTime.now(), "kevin", "7:00");
		a = new ApfsFile(pictures, "a", 30, LocalDateTime.now(), "kevin", "7:00");
		b = new ApfsFile(pictures, "b", 40, LocalDateTime.now(), "kevin", "7:00");
		c = new ApfsFile(home, "c", 50, LocalDateTime.now(), "kevin", "7:00");
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "kevin", "7:00", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "kevin", "7:00", y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(n);
	}
	
	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getOwnerName(), String.valueOf(f.getSize()),
							f.getLastModifiedTime(), f.getParent().getName() };
		return fileInfo;
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
	@Test
	public void TestFileEqualityX() {
		String[] expected = { "true", "kevin", "10", "7:00", "apps" };
		ApfsFile actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void TestFileEqualityA() {
		String[] expected = { "true", "kevin", "30", "7:00", "pictures" };
		ApfsFile actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	
}