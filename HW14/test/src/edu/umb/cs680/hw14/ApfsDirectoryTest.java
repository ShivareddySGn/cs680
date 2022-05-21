package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.ApfsDirectory;
import edu.umb.cs680.hw14.ApfsFSElement;
import edu.umb.cs680.hw14.ApfsFile;
import edu.umb.cs680.hw14.ApfsLink;

public class ApfsDirectoryTest {
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
		x = new ApfsFile(apps, "x", 15, LocalDateTime.now(), "kevin", "7:00");
		y = new ApfsFile(bin, "y", 10, LocalDateTime.now(), "kevin", "7:00");
		a = new ApfsFile(pictures, "a", 5, LocalDateTime.now(), "kevin", "7:00");
		b = new ApfsFile(pictures, "b", 20, LocalDateTime.now(), "kevin", "7:00");
		c = new ApfsFile(home, "c", 25, LocalDateTime.now(), "kevin", "7:00");
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

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void TestDirectoryEqualityRoot() {
		String[] expected = { "true", "kevin", "75", "7:00", "3" };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void TestDirectoryEqualityHome() {
		String[] expected = { "true", "kevin", "50", "7:00", "3" };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void CheckifDirectoyTestingWithRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void CheckifFileTestingWithRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void CheckifLinkTestingWithRoot() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void TestappendChildrenWithHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void TestcountChildrenWithHome() {
		assertSame(3, home.countChildren());
	}
	
	@Test
	public void TestgetChildrenOfHome() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = c;
		expected[1] = m;
		expected[2] = pictures;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren();
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestReverseAlphabeticalWithgetChildrenOfHome() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = pictures;
		expected[1] = m;
		expected[2] = c;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestElementKindWithgetChildrenOfHome() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = pictures;
		expected[1] = c;
		expected[2] = m;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren(Comparator.comparing(e -> e.elementKindToInt()));
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestgetSubDirectoriesOfRoot() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestReverseAlphabeticalWithgetSubDirectoriesOfRoot() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = home;
		expected[1] = bin;
		expected[2] = apps;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestElementKindWithgetSubDirectoriesOfRoot() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing(e -> e.elementKindToInt()));
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestgetSubDirectoriesWithHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void TestgetFilesWithHome() {
		assertSame(c, home.getFiles().get(0));
	}
	
	@Test
	public void TestgetFilesOfPictures() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = a;
		expected[1] = b;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestReverseAlphabeticalWithgetFilesOfPictures() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = b;
		expected[1] = a;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestElementKindWithgetFilesOfPictures() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = a;
		expected[1] = b;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles(Comparator.comparing(e -> e.elementKindToInt()));
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void TestgetLinksWithHome() {
		assertSame(m, home.getLinks().get(0));
	}
	
	@Test
	public void TestgetLinksWithPictures() {
		assertSame(n, pictures.getLinks().get(0));
	}
	
	@Test
	public void TestgetTotalSizeWithRoot() {
		assertEquals(75, root.getTotalSize());
	}
	
	@Test
	public void TestgetTotalSizeWithHome() {
		assertEquals(50, home.getTotalSize());
	}

}