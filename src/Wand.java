public class Wand extends Item {
	public Wand() {
		super("wand");
	}

	public void take() {
		super.take(); // Calls item's take method
		Game.getCurrentRoom().setRoomID("RESTROOM A");
	}
	public void use() {
		if (Game.getCurrentRoom().getName().equals("lobby")) {
			System.out.println("You wave the wand and the lounge magically unlocks!");
			Room lounge = Game.getCurrentRoom().getExit('e');
			lounge.setLocked(false);
		} else {
			System.out.println("You wave the wand around.");
			// Room Bar
			Room bar = World.rooms.get("BAR");
			Game.setcurrentRoom(bar);
			//Game.print(bar.getdesc());
		}
}
}