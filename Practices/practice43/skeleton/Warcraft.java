import java.util.Scanner;

/**
 * CS1020 (AY2014/5 Semester 2)
 * Name:
 * Matric. No.:
 * Lab group:
 * Write the program description below.
 * It is mandatory to write program description at the top of every program.
 *
 */
public class Warcraft {
	private Scanner sc = new Scanner(System.in);
	
	public void run() {
		readUnitsStats();
		battle();
	}
	
	/**
	 * unitOne and unitTwo will attack each other and winner will be printed out
	 */
	private void battle() {
	}

	private void readUnitsStats() {
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
}