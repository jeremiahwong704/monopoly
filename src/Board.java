
public class Board {
	
		Location[] properties = new Location[] {
		new Card("Go"), //0
		new Location(100, "Parking Lot"), //1
		new Location(100, "Bike Racks"),//2
		new Location(150, "Mandarin Room"),//3
		new Location(200, "Spanish Room"),//4
		new Card("Chance"),//5
		new Location(250, "French room"),//6
		new Card("Principle's Office"),//7
		new Location(300, "Portables"),//8
		new Location(350, "MEHAP Room"),//9
		new Card("Chance"),//10
		new Location(400, "Locker Rooms"),//11
		new Location(450, "Gym"),//12
		new Location(500, "Football Field"),//13
		new Card("Lunchtime"),//14
		new Location(550, "Bruhrivar's Lair"),//15
		new Card("Chance"),//16
		new Location(600, "ASB Room"),//17
		new Location(650, "Robotics Room"),//18
		new Card("Bathroom"),//19
		new Location(700, "School Library"),//20
		new Card("Go to Principle's Office"),//21
		new Location(750, "Trig/Stats Room"),//22
		new Location(800, "Eagle Theatre"),//23
		new Card("Chance"),//24
		new Location(850, "Chem/ASI Room"),//25
		new Location(900, "Comp Sci Room"),//26
		new Location(1000, "Home"),//27
	};
	public Location getProperties(int i) { return properties[i];}
}
