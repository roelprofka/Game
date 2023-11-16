public class BoltCutter extends Item {
	public BoltCutter() {
		super("Boltcutter");
	}
	public void use() {
		if(Game.getCurrentRoom().equals("Lounge")) {
			if(isUsed()) {
				System.out.println("You have already opened the safe");
			}
			else {
				System.out.println("There is a flame resistant jacket here.");
				Item Flame_Jacket = new Item("FLAME RESISTOR!");
				Game.getCurrentRoom().addItem(Flame_Jacket);
				Flame_Jacket.setDesc("This item could be useful to get through fire");
				setUsed(true);
			}
		}
		else {
			System.out.println("Your BoltCutter can't be used here");
		}
	}

}