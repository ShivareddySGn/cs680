package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.FileSystem;

public class FileSystemTest {

	@Test
	public void getFileSystemReturnNonNullValue() {
		assertNotNull(FileSystem.getFileSystem());
	}

	@Test
	public void getFileSystemReturnIdenticalInstance() {
		FileSystem f1 = FileSystem.getFileSystem();
		FileSystem f2 = FileSystem.getFileSystem();
		assertSame(f1, f2);
	}
	
	@Test
	public void TestappendRootDir() {
		FileSystem sys = FileSystem.getFileSystem();
		Directory root1 = new Directory(null, "root1", 0, LocalDateTime.now());
		Directory root2 = new Directory(null, "root2", 0, LocalDateTime.now());
		Directory root3 = new Directory(null, "root3", 0, LocalDateTime.now());
		sys.appendRootDir(root1);
		sys.appendRootDir(root2);
		sys.appendRootDir(root3);
		Directory[] expected = new Directory[3];
		expected[0] = root1;
		expected[1] = root2;
		expected[2] = root3;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> rootDirs = sys.getRootDirs();
		actual[0] = rootDirs.get(0);
		actual[1] = rootDirs.get(1);
		actual[2] = rootDirs.get(2);
		assertArrayEquals(expected, actual);
		
	}
	
	

}
