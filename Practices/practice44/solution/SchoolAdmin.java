
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Wang YanHao
 *
 */
public class SchoolAdmin {
	public static ArrayList<Module> allModules = new ArrayList<Module>(); 
	public static ArrayList<Student> allStudents = new ArrayList<Student>();

	public void run() {
		Scanner sc = new Scanner(System.in);

		// read in modules
		while (sc.hasNext()) {
			String temp = sc.next();
			if (temp.equals("-1")) {
				sc.nextLine();
				break;
			} else {
				allModules.add(new Module(temp, sc.nextInt()));
				// next line
				sc.nextLine();
			}
		}

		// read in students' info
		int studentNo = sc.nextInt();
		while (studentNo-- > 0) {
			sc.nextLine();
			allStudents.add(new Student(sc.nextLine(), sc.nextLine()));
			// read in modules this student has been enrolled into
			while (sc.hasNext()) {
				String temp = sc.next();;
				if (temp.equals("-1")) {
					break;
				} else {
					allStudents.get(allStudents.size() - 1).addModule(temp, sc.next());
					sc.nextLine();
				}
			}
		}

		// calculate each student's CAP and output
		for (Student student: allStudents) {
			student.calcCAP();
			System.out.print(student.getName() + " with matric number " + student.getMatricNo() + " has enrolled in " + student.getMc() + "MC courses");
			System.out.printf(" and has a CAP of %.2f\n", student.getCAP());
		}
	}

	public static void main(String[] args) {
		SchoolAdmin sa = new SchoolAdmin();
		sa.run();
	}
}

class Student {
	private String name;
	private String MatricNo;
	private ArrayList<ModulePair> modules;
	private int mc;
	private double cap;

	public Student(String MatricNo, String name) {
		this.name = name;
		this.MatricNo = MatricNo;
		modules = new ArrayList<ModulePair>();
	}

	/**
	 * calculate student's CAP based on current modules he has enrolled into
	 */
	public void calcCAP() {
		double sumGrade = 0;
		int sumMC = 0;

		for (ModulePair modulePair: modules) {
			sumMC += modulePair.getModule().getMC();
			sumGrade += modulePair.getModule().getMC() * modulePair.getGrade();
		}

		mc = sumMC;
		cap = sumGrade / sumMC;
	}

	/**
	 * add a new module to the student's profile
	 */
	public void addModule(String moduleCode, String gradeLetter) {
		modules.add(new ModulePair(findModule(moduleCode), gradeLetter));
	}

	/**
	 * find the correct module based on the input module code
	 */
	private Module findModule(String moduleCode) {
		for (Module module: SchoolAdmin.allModules) {
			if (module.getCode().equals(moduleCode)) {
				return module;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}
	public String getMatricNo() {
		return MatricNo;
	}
	public double getCAP() {
		return cap;
	}
	public int getMc() {
		return mc;
	}
}

class ModulePair {
	private Module module;
	private String gradeLetter;
	private double grade;

	public ModulePair(Module module, String gradeLetter) {
		this.module = module;
		this.gradeLetter = gradeLetter;
		calcGrade();
	}

	/**
	 * convert grade letter to corresponding grade point
	 */
	private void calcGrade() {
		switch (gradeLetter) {
			case "A+": case "A":
				grade = 5.0;
			break;
			case "A-":
				grade = 4.5;
			break;
			case "B+":
				grade = 4.0;
			break;
			case "B":
				grade = 3.5;
			break;
			case "B-":
				grade = 3.0;
			break;
			case "C+":
				grade = 2.5;
			break;
			case "C":
				grade = 2.0;
			break;
			case "D+":
				grade = 1.5;
			break;
			case "D":
				grade = 1.0;
			break;
			case "F":
				grade = 0.0;
			break;
			default:
			assert false : "gradeLetter " + gradeLetter + " unrecognized!"; 
		}
	}

	public Module getModule() {
		return module;
	}
	public String getGradeLetter() {
		return gradeLetter;
	}
	public double getGrade() {
		return grade;
	}
}

class Module {
	private String code;
	private int MC;

	public Module(String code, int MC) {
		this.code = code;
		this.MC = MC;
	}

	public int getMC() {
		return MC;
	}
	public String getCode() {
		return code;
	}
}

