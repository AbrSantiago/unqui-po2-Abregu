package fileSystem;

import java.time.LocalDateTime;

public class File implements FileSystem{
	private String		  name;
	private int			  size;
	private LocalDateTime lastModification;

	// ============================ OVERRIDES =============================
	@Override
	public int totalSize() {
		return this.getSize();
	}

	@Override
	public void printStructure() {
		System.out.println(this.getName());
	}

	@Override
	public FileSystem lastModified() {
		return this;
	}

	@Override
	public FileSystem oldestElement() {
		return this;
	}
	
	// =========================== CONSTRUCTOR ===========================
	public File(String name, int size) {
		this.setName(name);
		this.setSize(size);
		this.setLastModification(LocalDateTime.now());
	}
	
	// ======================== GETTERS & SETTERS ========================
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public LocalDateTime getLastModification() {
		return lastModification;
	}
	public void setLastModification(LocalDateTime lastModification) {
		this.lastModification = lastModification;
	}
}
