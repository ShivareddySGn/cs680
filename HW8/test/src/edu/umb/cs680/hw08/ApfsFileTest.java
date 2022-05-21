package edu.umb.cs680.hw08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.ApfsDirectory;
import edu.umb.cs680.hw08.ApfsFile;
import edu.umb.cs680.hw08.ApfsLink;

public class ApfsFileTest {
	private static ApfsDirectory root,apps,bin,home,pictures;
	private static ApfsFile x,y,a,b,c;
	private static ApfsLink m,n;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "kevin", "3:00");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "kevin", "3:00");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "kevin", "3:00");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "kevin", "3:00");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "kevin", "3:00");
		x = new ApfsFile(apps, "x", 15, LocalDateTime.now(), "kevin", "3:00");
		y = new ApfsFile(bin, "y", 10, LocalDateTime.now(), "kevin", "3:00");
		a = new ApfsFile(pictures, "a", 5, LocalDateTime.now(), "kevin", "3:00");
		b = new ApfsFile(pictures, "b", 20, LocalDateTime.now(), "kevin", "3:00");
		c = new ApfsFile(home, "c", 25, LocalDateTime.now(), "kevin", "3:00");
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "kevin", "3:00", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "kevin", "3:00", y);
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
	public void TestFileX() {
		String[] expected = { "true", "kevin", "15", "3:00", "apps" };
		ApfsFile actual = x;
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
