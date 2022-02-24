package model.bean;

public class PhiBD {
	private String name;
	private String cost;
	public String getname() {
		return name;
	}
	public String getcost() {
		return cost;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setcost(String cost) {
		this.cost = cost;
	}
	public PhiBD(String name, String cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
}
