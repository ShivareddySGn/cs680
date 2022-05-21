package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsCountingVisitor;

public class ApfsCountingVisitorTest {
	private static ApfsDirectory root,apps,bin,home,pictures;
	private static ApfsFile x,y,a,b,c;
	private static ApfsLink m,n;
	private static ApfsCountingVisitor rootVisitor,homeVisitor;
	

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
		rootVisitor = new ApfsCountingVisitor();
		homeVisitor = new ApfsCountingVisitor();
		root.accept(rootVisitor);
		home.accept(homeVisitor);
	}

	@Test
	public void TestDirectoryNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestFileNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestLinkNumberRoot() {
		int expected = 2;
		int actual = rootVisitor.getLinkNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestDirectoryNumberHome() {
		int expected = 2;
		int actual = homeVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestFileNumberHome() {
		int expected = 3;
		int actual = homeVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestLinkNumberHome() {
		int expected = 2;
		int actual = homeVisitor.getLinkNum();
		assertEquals(expected, actual);
	}

}
