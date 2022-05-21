package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.ApfsDirectory;
import edu.umb.cs680.hw14.ApfsFile;
import edu.umb.cs680.hw14.ApfsLink;

public class ApfsLinkTest {
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
	
	private String[] linkToStringArray(ApfsLink l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getOwnerName(), String.valueOf(l.getSize()),
						l.getLastModifiedTime(), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void TestLinkEqualityM() {
		String[] expected = { "true", "kevin", "0", "7:00", "home", "bin" };
		ApfsLink actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	
	@Test
	public void TestLinkEqualityN() {
		String[] expected = { "true", "kevin", "0", "7:00", "pictures", "y" };
		ApfsLink actual = n;
		assertArrayEquals(expected, linkToStringArray(actual));
	}

	@Test
	public void CheckifDirectoyTestingWithN() {
		assertFalse(n.isDirectory());
	}
	
	@Test
	public void CheckifFileTestingWithN() {
		assertFalse(n.isFile());
	}
	
	@Test
	public void CheckifLinkTestingWithN() {
		assertTrue(n.isLink());
	}
	
	@Test
	public void TestgetTargetWithM() {
		assertSame(bin, m.getTarget());
	}
	
	@Test
	public void TestsetTargetWithM() {
		m.setTarget(apps);
		assertSame(apps, m.getTarget());
	}

}