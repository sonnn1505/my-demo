package entity;

public class Employee {
	private int id;
	private String name;
	private int tuoi;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int tuoi) {
		super();
		this.id = id;
		this.name = name;
		this.tuoi = tuoi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

}
