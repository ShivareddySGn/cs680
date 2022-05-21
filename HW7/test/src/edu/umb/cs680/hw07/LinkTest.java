package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class LinkTest {
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
	
	private String[] linkToStringArray(Link l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getName(), String.valueOf(l.getSize()),
				String.valueOf(l.getCreationTime()), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void CheckifDirectoyTestingWithP() {
		assertFalse(p.isDirectory());
	}
	
	@Test
	public void CheckifFileTestingWithP() {
		assertFalse(p.isFile());
	}
	
	@Test
	public void CheckifLinkTestingWithP() {
		assertTrue(p.isLink());
	}
	
	@Test
	public void TestgetTargetWithP() {
		assertSame(bin, p.getTarget());
	}
	
	@Test
	public void TestsetTargetWithP() {
		p.setTarget(apps);
		assertSame(apps, p.getTarget());
	}

}