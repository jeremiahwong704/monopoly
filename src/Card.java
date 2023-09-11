public class Card extends Location{
	public Card(String name) {
		super(0, name);
	}
	public void buy() {}
	
	public int payRent() {
		return 0;
	}
	
	public void whichAction(int a, Player player) {
		switch (a) {
		case 0:
			go(player);
			break;
		case 1:
			goToJail(player);
			break;
		case 2:
			getOutOfJailFree(player);
			break;
		case 3:
			loseGraphingCalculator(player);
			break;
		case 4:
			sickness(player);
			break;
		case 5:
			economicsClass(player);
			break;
		case 6:
			badPerson(player);
			break;
		case 7:
			christmas(player);
			break;
		case 8:
			lunchMoney(player);
			break;
		case 9:
			timeMachine(player);
			break;
		case 10:
			sellingStuff(player);
			break;
		case 11:
			bathroom(player); // not a chance card
		default:
			break;
		}
	}
	
	private void bathroom(Player player) {
		System.out.println("The bathrooms are a dangerous place. You never know what you will fidn here. Pay 5% of your money.");
		player.loseMoney(player.getMoney()/20);
	}
	private void sellingStuff(Player player) {
		System.out.println("You try out capitalism for yourself after seeing a video about it on youtube. You manage to make 100 dollars before you are kicked out\n");
		player.gainMoney(100);
		
	}
	private void timeMachine(Player player) {
		System.out.println("You've had a bad day. You take out your time machine and restart the day, sending you all the way back to square one. Do not pass GO");
		player.setLocation(1);
	}
	private void lunchMoney(Player player) {
		System.out.println("You left your lunch at home and have to buy school lunch, which is only SLIGHTLY overpriced. Pay 50 dollars"); 
		player.loseMoney(50);
	}
	private void christmas(Player player) {
		System.out.println("It's Christmastime! You get a lot of free money from people who are too lazy to buy you gifts so they just\n"
				+ "gave you cash. No one is complaining though. College 200 dollars");
		player.gainMoney(200);
	}
	private void go(Player player) {
		System.out.println("Advance to Go! Collect 200 dollars");
		player.gainMoney(200);
	}
	
	private void loseGraphingCalculator(Player player) {
		System.out.println("Unfortunately for you, you have lost your 150 dollasr TI-420 graphing calculator, and you have a math test tomorrow\n"
				+ "so you have to get a new one right now or you fail your test. Pay 150 dollars");
		player.loseMoney(150);
	}

	private void goToJail(Player player) {
		System.out.println("Your friends are snitches, and report you for kidnapping your math teacher's dog. Now you're in the principal's office!");
		player.setLocation(7);
		if (!player.isGetOutOfJailFree()) player.setInJail(true);
		else System.out.print("Just kidding! You have a get of out jail alibi!");
	}

	private void getOutOfJailFree(Player player) { //modify this later so it can be held
		System.out.println("Your parents wrote you an alibi for the crime you allegedly commited. You keep it in your pocket and will show it to the principal\n"
				+ "if you ever get reported and sent to the office.");
		if (player.isInJail()) player.setInJail(false);
		else player.setGetOutOfJailFree(true);
	}

	private void sickness(Player player) {
		System.out.println("You get a cold. Advance to home, but pay 50 dollars for your medical fees.\n"
				+ "If home is owned, pay rent as well"); //note: might get rid of this later
		player.loseMoney(50);
		//player.payRent(location);
	}
	
	private void economicsClass(Player player) {
		System.out.println("Today in school your teacher teaches you about economics. This teacher likes hands on learning, and uses a little demonstration,\n"
				+ "telling you to give them 10% of your money. However, they convinently forgot where they put it. Pay 10% of all your money.");
		player.loseMoney(player.getMoney()/10);
	}

	private void badPerson(Player player) {
		System.out.println("You're walking to school when you see a 100 dollar bill on the floor. You decide to be a bad person and keep it for yourself");
		player.gainMoney(100);
	}
}
