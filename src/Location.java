
public class Location {
	private int cost;
	private String name;
	private boolean sold;
	private int rent;
	private int houses;
	private Player owner;
	
	public Location(int cost, String name) {
		this.cost = cost;
		this.name = name;
		this.rent = cost/10;
		this.sold = false;
		this.houses = 0;
		this.owner = null;
	}
	
	public void buy(Player owner) {
		this.owner = owner;
		sold = true;
		owner.loseMoney(cost);
	}
	
	public int PayRent(Player tresspasser) {
		if (sold && tresspasser!=owner) {
			for (int i = 0; i < 5; i++)
				if (houses == i) return (int)(rent * Math.pow(2, i));
		}
		return 0;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
