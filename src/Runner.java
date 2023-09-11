
public class Runner {
	private final static PairOfDice gameDice = new PairOfDice();
	private static Player[] players;
	private final static Board gameBoard = new Board();
	private static boolean gameContinues = true;
	public static void main (String[]args) {
		initialize();
		while (gameContinues) {
			printBoard();
			printCurrentStatus(gameBoard);
		}
	}
	
	public static void printBoard() {
		System.out.println("|     GO     |    Parking Lot   |   Bike Racks   |   Mandarin   |   Spanish  |   Chance   |    French    |Principle's Office|");
		System.out.println("|   Office   |     Portables    |   MEHAP Room   |    Chance    |Locker Rooms|     Gym    |Foorball Field|    Lunch Time    |");
		System.out.println("| Lunch Time | Bruhrivar's Lair |     Chance     |   ASB Room   |  Robotics  |  Bathroom  |School Library| Go to the Office |");
		System.out.println("|Go to Office|  Trig/Stats Room |  EagleTheatre  |    Chance    |  Chem/ASI  |  Comp Sci  |     HOME     |         GO       |\n");
	}

	public static void initialize() {
		int numPlayers = 0;
		System.out.println("Hi! Welcome to (fake bad) Monopoly");
		while (numPlayers < 2 || numPlayers > 8) {
			System.out.println("How many total players? Please have 2-8");
			numPlayers = TextIO.getlnInt();
		}
		players = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			String playerName;
			System.out.println("Name of player " + (i+1) + "?");
			playerName = TextIO.getlnString();
			players[i] = new Player(playerName);
		}
	}
	public static void printCurrentStatus(Board gameBoard) {
		for (int i = 0; i < players.length; i++) {
			gameDice.roll();
			players[i].setLocation(players[i].getLocation()+gameDice.getSum());
			if (players[i].getMoney() < 0) {
				System.out.println("You are bankrupt. Your current turn is over until you have more money.");  
				i++;
			}
			System.out.println("It is " + players[i].getName() + "'s turn\n"
					+ "You rolled a " + gameDice.getSum() + " and landed on " + gameBoard.getProperties(players[i].getLocation()).getName());
			System.out.println("You have " + players[i].getMoney() + " dollars");
			if (!players[i].isInJail()) {
				if (players[i].getLocation() == 5 || players[i].getLocation() == 10 || players[i].getLocation() == 16 || players[i].getLocation() == 24) {
					int random = (int)(Math.random()*10);
					((Card)gameBoard.getProperties(players[i].getLocation())).whichAction(random, players[i]);
				}
				else if (players[i].getLocation() == 0) {
					((Card)gameBoard.getProperties(players[i].getLocation())).whichAction(0, players[i]);
				}
				else if (players[i].getLocation() == 7) {
					System.out.print("You walk past the principles office and you see some of your classmates in there. You laugh.\n");
				}
				else if (players[i].getLocation() == 14) {
					System.out.print("Lunchtime! Yay!\n");
				}
				else if (players[i].getLocation() == 19) {
					((Card)gameBoard.getProperties(players[i].getLocation())).whichAction(11, players[i]);
				}
				else if (players[i].getLocation() == 21) {
					((Card)gameBoard.getProperties(players[i].getLocation())).whichAction(1, players[i]);
				}
				else {
					if (gameBoard.getProperties(players[i].getLocation()).isSold()) {
						System.out.println("You landed on a sold property. Please pay the rent of " + gameBoard.getProperties(players[i].getLocation()).getRent());
						players[i].payRent(gameBoard.getProperties(players[i].getLocation()));
						gameBoard.getProperties(players[i].getLocation()).getOwner().gainMoney(gameBoard.getProperties(players[i].getLocation()).getRent());
					}
					else if (!gameBoard.getProperties(players[i].getLocation()).isSold() && gameBoard.getProperties(players[i].getLocation()).getOwner() != players[i]) {
						System.out.println("Do you want to buy " + gameBoard.getProperties(players[i].getLocation()).getName() + " for "
								+ gameBoard.getProperties(players[i].getLocation()).getCost() + " dollars?");
						System.out.println("1 = Yes, 2 = No");
						int decision = TextIO.getlnInt();
						while(decision != 1 && decision != 2) {
							System.out.println("Please type in 1 or 2");
							decision = TextIO.getlnInt();
						}
						if (decision == 1) {
							if (players[i].getMoney() < gameBoard.getProperties(players[i].getLocation()).getCost()) System.out.println("You do not have enough money to buy this property. Your turn is over.");
							else gameBoard.getProperties(players[i].getLocation()).buy(players[i]);
						}
						if (decision == 2) {
							System.out.println("Your turn is over");
						}
					}
				}
			}
			else System.out.println("Sorry, you are in jail. Wait till the next turn");
			players[i].setInJail(false);
		}
	}
}


