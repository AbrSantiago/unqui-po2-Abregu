package fileSystem;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Directory implements FileSystem {
	private String		 	name;
	private LocalDateTime	creationDate;
	private Set<FileSystem> content;
	
	// ============================= METHODS =============================
	public void addFileSystem(FileSystem fileSystem) {
		this.getContent().add(fileSystem);
	}

	// ============================ OVERRIDES =============================
	@Override
	public int totalSize() {
		int size = 0;
		for (FileSystem fileSystem : this.getContent()) {
			size += fileSystem.totalSize();
		}
		return size;
	}

	@Override
	public void printStructure() { // REVISAR
		System.out.println(this.getName());
		for (FileSystem fileSystem : this.getContent()) {
			System.out.print(" ");
			fileSystem.printStructure();
		}
	}

	@Override
	public FileSystem lastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileSystem oldestElement() {
		// TODO Auto-generated method stub
		return null;
	}

	// =========================== CONSTRUCTOR ===========================
	public Directory(String name) {
		this.setName(name);
		this.setCreationDate(LocalDateTime.now());
		this.setContent(new HashSet<FileSystem>());
	}
	
	// ======================== GETTERS & SETTERS ========================
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	LocalDateTime getCreationDate() {
		return creationDate;
	}
	void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	Set<FileSystem> getContent() {
		return content;
	}
	void setContent(Set<FileSystem> content) {
		this.content = content;
	}
}
