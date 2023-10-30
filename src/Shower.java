public class Shower extends Item {
	public Shower() {
		super("Shower");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("restroom")) {
			if(isUsed()) {
				System.out.println("You already got rid of your goo");
			}
			else {
				System.out.println("The goo is removed");
				setUsed(true);
			}
		}
		else {
			System.out.println("There is no shower in this room");
		}
	}

}
