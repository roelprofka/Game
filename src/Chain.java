public class Chain extends Item {
	public Chain() {
		super("Chain");
	}
	public void use() {
		if (Game.getCurrentRoom().getName().equals("hall2")){
			if(isUsed()) {
				System.out.println("You got gooed already!");
			}				
		else {
			System.out.println("The Chain is used");
			Item goo = new Item("goo");
			goo.setDesc("You got gooed");
			Game.getCurrentRoom().addItem(goo);
			setUsed(true);
		}
	}
		else {
			System.out.println("Chain is not in this Room.");
		}
	
	}
}
