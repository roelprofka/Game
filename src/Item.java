import java.io.Serializable;

public class Item implements Serializable {
	private String name;
	private String desc;
	private boolean heavy;
	private boolean used;
	public Item(String n) {
		name = n;
		heavy = false;
		used = false;
	}
	public void setHeavy(boolean b) {
		heavy = b;
	}
	public boolean isHeavy() {
		return heavy;
	}
	public void setDesc(String d) {
		desc = d;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean b) {
		used = b;
	}
	public void look() {
		System.out.println(desc);
	}
	public void take() {
		if (isHeavy())
			System.out.println("That's too heavy to carry around!");
		else {
			Game.inventory.add(Game.getCurrentRoom().removeItem(name));
			System.out.println("You pick up the " +name + ".");
		}
	}
	public void use() {
		System.out.println("You can't use the " + name + ", yet...");
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name;
	}
}