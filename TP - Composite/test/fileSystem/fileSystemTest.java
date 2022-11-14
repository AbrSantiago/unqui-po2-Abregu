package fileSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class fileSystemTest {
	private Directory folder1;
	private Directory folder2;
	private Directory folder3;
	private File	  file1;
	private File	  file2;
	private File	  file3;
	
	@BeforeEach
	public void setUp() {
		folder1 = new Directory("Folder1");
		folder2 = new Directory("Folder2");
		folder3 = new Directory("Folder3");
		file1	= new File("File1", 10);
		file2	= new File("File2", 30);
		file3	= new File("File3", 25);
	}

	@Test
	void test01_ADirectoryIsEmpty() {
		assertTrue(folder1.getContent().isEmpty());
	}

	@Test
	void test02_ADirectoryIsNotEmpty() {
		folder1.addFileSystem(file1);
		assertFalse(folder1.getContent().isEmpty());
		assertTrue(folder1.getContent().contains(file1));
		assertEquals(folder1.getContent().size(), 1);
	}

	@Test
	void test03_ADirectoryHasNotDuplicatedFileSystems() {
		folder1.addFileSystem(file1);
		folder1.addFileSystem(file1);
		assertFalse(folder1.getContent().isEmpty());
		assertTrue(folder1.getContent().contains(file1));
		assertEquals(folder1.getContent().size(), 1);
	}

	@Test
	void test04_ADirectoryHasSize() {
		folder1.addFileSystem(file1);
		folder1.addFileSystem(file2);
		assertEquals(folder1.getContent().size(), 2);
		assertEquals(folder1.totalSize(), 40);
	}

	@Test
	void test05_ADirectoryHasSize() {
		folder1.addFileSystem(file1);
		folder1.addFileSystem(file2);
		folder2.addFileSystem(file3);
		folder1.addFileSystem(folder2);
		assertEquals(folder1.getContent().size(), 3);
		assertEquals(folder1.totalSize(), 65);
	}

	@Test
	void test06_ADirectoryPrintsThemselves() {
		folder1.addFileSystem(folder2);
		folder1.addFileSystem(folder3);
		folder1.addFileSystem(file1);
		folder1.addFileSystem(file2);
		folder2.addFileSystem(file3);
		folder1.printStructure();
	}
}


