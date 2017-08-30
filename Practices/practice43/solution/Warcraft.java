import java.util.Scanner;

/**
 * @author Wang YanHao
 *
 */
public class Warcraft {
	private Scanner sc = new Scanner(System.in);
	private Unit unitOne, unitTwo;
	
	public void run() {
		readUnitsStats();
		battle();
	}
	
	/**
	 * unitOne and unitTwo will attack each other and winner will be printed out
	 */
	private void battle() {
		while (unitOne.isAlive() && unitTwo.isAlive()) {
			unitOne.attack(unitTwo);
			unitTwo.attack(unitOne);
		}
		
		if (unitOne.isAlive()) {
			// unitOne wins
			System.out.println("Winner is " + unitOne.getName() + " with " + unitOne.getCurrentHP() + " HP remaining.");
		} else if (unitTwo.isAlive()) {
			// unitTwo wins
			System.out.println("Winner is " + unitTwo.getName() + " with " + unitTwo.getCurrentHP() + " HP remaining.");
		} else {
			// draw
			System.out.println("Draw.");
		}
	}

	private void readUnitsStats() {
		unitOne = new Unit(sc.next(), sc.nextInt(), sc.nextDouble(), sc.next(), sc.nextDouble(), sc.next());
		sc.nextLine();
		unitTwo = new Unit(sc.next(), sc.nextInt(), sc.nextDouble(), sc.next(), sc.nextDouble(), sc.next());
		sc.close();
	}

	public static void main(String[] args) {
		Warcraft wc = new Warcraft();
		wc.run();
	}
}

class Unit {
	private String name;
	private int maxHP, currentHP;
	private double attack;
	private String attackType;
	private double armor;
	private String armorType;
	
	public Unit() {}
	
	public Unit(String name, int maxHP, double attack, String attackType, double defence, String defenceType) {
		this.name = name;
		this.maxHP = this.currentHP = maxHP;
		this.attack = attack;
		this.attackType = attackType;
		this.armor = defence;
		this.armorType = defenceType;
	}
	
	public void attack(Unit enemy) {
		double damageReduction = (enemy.getArmor() * 0.06) / (1 + 0.06 * enemy.getArmor());
		double attackCoeff = calcAttackCoeff(enemy);
		double damage = this.getAttack() * attackCoeff * (1 - damageReduction);
		enemy.setCurrentHP((int)(enemy.getCurrentHP() - damage));
	}

	private double calcAttackCoeff(Unit enemy) {
		switch (attackType.toLowerCase()) {
			case "normal":
				switch (enemy.getArmorType().toLowerCase()) {
					case "light": case "heavy": case "hero": case "unarmored":
						return 1.0;
					case "medium": 
						return 1.5;
					case "fort":
						return 0.7;
					default:
						assert false: "Invalid armor type!"; 
				}
			case "pierce":
				switch (enemy.getArmorType().toLowerCase()) {
					case "light":
						return 2.0;
					case "medium": 
						return 0.75;
					case "heavy":
						return 1.0;
					case "fort":
						return 0.35;
					case "hero":
						return 0.5;
					case "unarmored":
						return 1.5;
					default:
						assert false: "Invalid armor type!";
				}
			case "siege":
				switch (enemy.getArmorType().toLowerCase()) {
					case "light": case "heavy":
						return 1.0;
					case "medium": case "hero": 
						return 0.5;
					case "fort": case "unarmored":
						return 1.5;
					default:
						assert false: "Invalid armor type!";
				}
			case "magic":
				switch (enemy.getArmorType().toLowerCase()) {
					case "light":
						return 1.25;
					case "medium": 
						return 0.75;
					case "heavy":
						return 2.0;
					case "fort":
						return 0.35;
					case "hero":
						return 0.5;
					case "unarmored":
						return 1.0;
					default:
						assert false: "Invalid armor type!";
				}
			case "chaos":
				switch (enemy.getArmorType().toLowerCase()) {
					case "light": case "medium": case "heavy": case "fort": case "hero": case "unarmored":
						return 1.0;
					default:
						assert false: "Invalid armor type!";
				}
			case "spells":
				switch (enemy.getArmorType().toLowerCase()) {
					case "light": case "medium": case "heavy": case "fort": case "unarmored":
						return 1.0;
					case "hero": 
						return 0.7;
					default:
						assert false: "Invalid armor type!";
				}
			case "hero":
				switch (enemy.getArmorType().toLowerCase()) {
					case "light": case "medium": case "heavy": case "hero": case "unarmored":
						return 1.0;
					case "fort": 
						return 0.5;
					default:
						assert false: "Invalid armor type!";
				}
			default:
				assert false: "Invalid attack type!";
		}
		// should not be executed
		assert false: "Error in method calcAttackCoeff!";
		return -1;
	}
	
	public boolean isAlive() {
		return this.currentHP > 0;
	}

	public String getName() {
		return name;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		if (currentHP > 0 ) {
			this.currentHP = currentHP;
		} else {
			this.currentHP = 0;
		}
	}
	public double getAttack() {
		return attack;
	}
	public String getAttackType() {
		return attackType;
	}
	public double getArmor() {
		return armor;
	}
	public String getArmorType() {
		return armorType;
	}
}