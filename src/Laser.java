public class Laser extends Item {
	public Laser() {
		super("Laser");
	}
	public void use() {
		if(Game.getCurrentRoom().equals("bar")) {
			if(isUsed()) {
				System.out.println("You already heated the bar");
		}
			else {
				System.out.println("You just heated the bar's ice machine and a gold nugget appeared.");
				Item gold_nugget = new Item("Gold Nugget");
				gold_nugget.setDesc("This could be used to bribe a poor man");
				Game.getCurrentRoom().addItem(gold_nugget);
				setUsed(true);
			}
		}
		else{
			System.out.println("Wrong room!");
		}
	}
}
