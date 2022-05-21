package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class DirectoryTest {
	private static Directory root,apps,bin,home,pictures;
	private static File x,y,a,b,c;
	private static Link p,q;
	

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

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void TestgetTotalSizeWithRoot() {
		assertEquals(75, root.getTotalSize());
	}
	
	@Test
	public void TestgetTotalSizeWithHome() {
		assertEquals(50, home.getTotalSize());
	}
	@Test
	public void TestDirectoryEqualtoRoot() {
		String[] expected = { "true", "root", "75", String.valueOf(root.getCreationTime()), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void TestDirectoryEqualtoHome() {
		String[] expected = { "true", "home", "50", String.valueOf(home.getCreationTime()), "3" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void TestgetFilesWithPictures() {
		File[] expected = new File[2];
		expected[0] = a;
		expected[1] = b;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestgetLinksWithHome() {
		assertSame(p, home.getLinks().get(0));
	}
	
	@Test
	public void TestisDirectoyWithRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void CheckifFileTesingWithRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void CheckifLinkTestingWithRoot() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void TestappendChildrenWithRoot() {
		assertSame(root, apps.getParent());
	}
	

	
	@Test
	public void TestcountChildrenWithRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	
	
	@Test
	public void TestgetSubDirectoriesWithRoot() {
		Directory[] expected = new Directory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}

}
