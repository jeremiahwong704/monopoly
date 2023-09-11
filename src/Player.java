
public class Player {
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation() {
		return location;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public void setLocation(int location) {
		if (location < 28) this.location = location;
		else {
			while (location > 27) {
				location -= 28;
			}
		}
	}

	private int money;
	private String name;
	private int location;
	private boolean inJail;
	private boolean getOutOfJailFree;
	
	public boolean isGetOutOfJailFree() {
		return getOutOfJailFree;
	}

	public void setGetOutOfJailFree(boolean getOutOfJailFree) {
		this.getOutOfJailFree = getOutOfJailFree;
	}

	public Player(String name) {
		this.money = 1500;
		this.name = name;
		this.location = 0;
		this.inJail = false;
		this.getOutOfJailFree = false;
	}
	
	public void move(PairOfDice dice) {
		if (!inJail) this.location += dice.getSum();
	}
	
	public void payRent(Location location) {
		this.money -= location.PayRent(this);
		if (money - location.PayRent(this) < 0) {
			System.out.println("You are bankrupt loser");
		}
	}
	
	public void loseMoney(int money) {
		this.money -= money;
	}
	
	public void gainMoney(int money) {
		this.money += money;
	}
}
