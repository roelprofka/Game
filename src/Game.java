import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Game {
	public static HashMap<Room, String> rooms = 
			new HashMap<Room, String>();
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	public static void setcurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public static void move(char direction) {
		Room nextRoom = currentRoom.getExit(direction);
		if (nextRoom != null) {
			if (nextRoom.isLocked()) {
				System.out.println("The room is locked!");
			} else {
				currentRoom = nextRoom;
				System.out.println(currentRoom);
			}
		} else {
			System.out.println("You can't go that way!");
		}
	}
	public static Item getItem(String name) {
		for (Item i : inventory)
			if (i.getName().equals(name))
				return i;
		return null;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playerCommand = "a";
		String itemName;
		Item i;
		currentRoom = World.buildWorld();
		System.out.println(currentRoom);
		while (!playerCommand.equals("x")) {
			System.out.print("What do you want to do? ");
			playerCommand = scan.nextLine();
			String[] words = playerCommand.split(" ");
			switch (words[0]) {
			case "n":
			case "s":
			case "e":
			case "w":
			case "u":
			case "d":
				move(playerCommand.charAt(0));
				break;
			case "save":
				saveGame();
				break;
			case "take":
				itemName = words[1];
				if (currentRoom.hasItem(itemName)) {
					Item item = currentRoom.getItem(itemName);
					item.take();
				} else {
					System.out.println("There is no " + itemName + "!");
				}
				break;
			case "look":
				i = getItem(words[1]);
				if (i == null)
					i = currentRoom.getItem(words[1]);
				if (i == null)
					System.out.println("There is no " + words[1] + "!");
				else
					i.look();
				break;
			case "use":
				i = getItem(words[1]);
				if(currentRoom.hasItem("Chain")) {
					inventory.add(currentRoom.removeItem(words[1]));
					i=getItem(words[1]);
					inventory.remove(i);
					currentRoom.addItem(i);

				}
				else if(currentRoom.hasItem("Shower")) {
					if(inventory.contains(getItem("goo"))) {
						inventory.add(currentRoom.removeItem(words[1]));
						i=getItem("Shower");
						currentRoom.addItem(i);
						inventory.remove(i);
						i = getItem("goo");
						inventory.remove(getItem("goo"));
						}
					}
					
				if (i == null )
					System.out.println("You don't have the "+words[1]+".");
				else
					i.use();
				break;
			case "i":
				if (inventory.isEmpty()) {
					System.out.println("You are carrying nothing!");
				} else {
					for (Item it : inventory) {
						System.out.println(it);
					}
				}
				break;
			case "x":
				System.out.println("Okay. Bye!");
				break;
			default:
				System.out.println("Invalid command.");
			}
		}
		scan.close();
	}
	public static void saveGame() {
		try {
		File saveFile = new File("save");
		saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new
			FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(rooms);
			stream.close();
			Game.print("Game saved.");
		} catch (FileNotFoundException ex) {
			Game.print("Error accessing save file.");
		} catch (IOException ex) {
			Game.print("Error creating save file.");
			ex.printStackTrace();
			}
		}
	public static void loadGame() {
		try {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(saveFile));
		currentRoom = (Room) stream.readObject();		
		inventory = (ArrayList<Item>) stream.readObject();
		rooms = (HashMap<Room, String>)stream.readObject();
		}
		catch(FileNotFoundException ex) {
			Game.print("Error accessing save file.");
		}
	}
	// include game.populatemap from readfiledemo.java
	public static void readFile() {
		try {
			Scanner scan = new Scanner(new File("rooms"));
		}
		catch(IOException ex) {
			Game.print("Can not find game descriptions");
		}
	}
	public static void print(String message) {
		System.out.println(message +"\n");
	}
}