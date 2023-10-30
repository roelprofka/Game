public class World {
	public static Room buildWorld() {
		Room lobby = new Room("lobby", "The hotel's lobby. Doorways lead east" +
				"to a lounge" + 
				" and west to a bar. There is a hallway to the north and" +
				"a " +
				" staircase up to the second floor.");
		Room lounge = new Room("lounge", "A comfortable lounge with armchairs,a couch, and" +
				" a delightful fire. An old man with a newspaper in his " +
				"lap" +
				" sleeps in one of the armchairs.");
		Room bar = new Room("bar", "The hotel bar! There is a long bar along " +
				"the west wall" +
				" and a door labelled 'Rest Room' to the north. A doorway " +
				"to the" +
				" east leads back to the lobby.");
		Room hall = new Room("hall", "A dead-end hallway. There are doors in " +
				"the east and" +
				" west walls. You can return south to the lobby.");
		Room hall2 = new Room("hall2", "You on the hotel's second floor! A " +
				"staircase leads" +
				" back down to the lobby.");
		Room restroom = new Room("restroom", "What a pleasant rest room! So " +
				"clean! So fresh!");
		lobby.addExit(lounge, 'e');
		lobby.addExit(bar, 'w');
		lobby.addExit(hall, 'n');
		lobby.addExit(hall2, 'u');
		lounge.addExit(lobby, 'w');
		Item newspaper = new Item("newspaper");
		newspaper.setDesc("It's a newspaper. Made of paper. What's up withthat?");
		lounge.addItem(newspaper);
		lounge.setLocked(true);
		Item key = new Key();
		key.setDesc("It's an ornate key. Looks old.");
		lounge.addItem(key);
		bar.addExit(lobby, 'e');
		bar.addExit(restroom, 'n');
		Item bottle = new Item("bottle");
		bottle.setDesc("An opaque glass bottle. Feels empty.");
		bar.addItem(bottle);
		restroom.addExit(bar, 's');
		Item wand = new Wand();
		wand.setDesc("The wand glows with an eerie light.");
		restroom.addItem(wand);
		hall.addExit(lobby, 's');
		Item chest = new Item("chest");
		chest.setDesc("It is a large, heavy chest.");
		chest.setHeavy(true);
		hall.addItem(chest);
		Item Chain = new Chain();
		hall2.addItem(Chain);
		Chain.setHeavy(true);
		hall2.addExit(lobby, 'd');
		Item Shower = new Shower();
		Shower.setDesc("A disgusting shower. A rational person wouldn't use this");
		restroom.addItem(Shower);
		Shower.setHeavy(true);
		Item BoltCutter = new BoltCutter();
		BoltCutter.setDesc("A rusty pair of BoltCutters lies on the ground here. ");
		hall.addItem(BoltCutter);
		Item Safe = new Item("Safe");
		lounge.addItem(Safe);
		Safe.setHeavy(true);
		Safe.setDesc("A gigantic safe exists in this lounge with a lockbox preventing access.");
		Item Laser = new Laser();
		Laser.setDesc("A heated laser, using this could heat up even the coldest of bar rooms");
		lounge.addItem(Laser);
		return lobby;
	}
}