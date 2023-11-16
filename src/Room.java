import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.io.Serializable;
public class Room implements Serializable {
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private String desc;
	private boolean locked; // Is the room locked?
	private String name;
	private String roomID;
	private HashMap<String, Item> roomItems;
	public Room(String n, String d) {
		name = n;
		roomID = n;
		locked = false;
		roomItems = new HashMap<String, Item>();
		World.rooms.put(name,this);
	}
	public String getName() {
		return name;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean b) {
		locked = b;
	}
	public Item getItem(String item) {
		return roomItems.get(item);
	}
	public Item removeItem(String name) {
		return roomItems.remove(name);
	}
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	public void addExit(Room r, char direction) {
		switch(direction) {
		case 'e': east = r; break;
		case 'w': west = r; break;
		case 'n': north = r; break;
		case 's': south = r; break;
		case 'u': up = r; break;
		case 'd': down = r; break;
		}
	}
	public void setRoomID(String Id) {
		roomID = Id;
	}	
		public Room getExit(char direction) {
		switch(direction) {
		case 'e': return east;
		case 'w': return west;
		case 'n': return north;
		case 's': return south;
		case 'u': return up;
		case 'd': return down;
		default : return null;
		}
	}
	public String getDesc() {
		for(Room a: Game.rooms.keySet()){
			desc = a.getName();
			return desc;

		}
		return null;
		}
	public String toString() {
		return desc;
	}
}