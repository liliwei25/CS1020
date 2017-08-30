import java.util.*;

/* Service class representing the employee management system */
class Employee {    

    private String name;
    private int rank;

    public Employee(String aName, int aRank) {
        name = aName;
        rank = aRank;
    }

    public String getName() {return name;}

    public int getRank() {return rank;} 

    public void setRank(int newRank) {rank = newRank;}

    public String toString() { return new String(name+" "+rank);}
}

/* Client class to simulate the employee management system */
public class EmpManagement {

    private Stack<Employee> empList;    
    
    public EmpManagement() {
        empList = new Stack<Employee>();
    }

    public void simulate(Scanner sc) {
        int numOperations = Integer.parseInt(sc.nextLine());

        for (int i=0; i < numOperations; i++) {
	    String line = sc.nextLine(); // read line
	    Scanner sc1 = new Scanner(line); // scan the line
            String operation = sc1.next();

            if (operation.equals("hire")) {
                Employee emp = new Employee(sc1.next(), sc1.nextInt());

                hire(emp);
            }
            else if (operation.equals("fire")) {
                int numToFire = sc1.nextInt();
                
                fire(numToFire);
            }
            else if (operation.equals("promote")) {             
                Employee emp = new Employee(sc1.next(), sc1.nextInt());

                promote(emp);
            }
	    // print out operation & resulting employees in company
	    System.out.println(line+"\n"+toString()); 
        }
    }

    /*
	pre: emp must not already exist in empList (that is no employee of
	     same name in empList)
	post: emp is added to empList as most recent employee at his/her rank.
    */
    public void hire(Employee emp) {
        Stack<Employee> temp = new Stack<Employee>();

	// pop all employees before emp onto temp        
        while (!empList.empty() && (empList.peek().getRank() < emp.getRank()))
            temp.push(empList.pop());
        empList.push(emp); // push employess into its correct position in empList
        while (!temp.empty()) // pop back all employess in temp into empList
            empList.push(temp.pop());
    }

    /*
	pre: numToFire must be > 0 and <= number of employees
	post: numToFire number of employees are removed from empList
              starting from lowest to highest rank and at each rank 
	      from most recent to least recent
    */
    public void fire(int numToFire) {
        for (int i=0; i < numToFire; i++)
            empList.pop();      
    }   

    /*
	pre: emp must already exist in empList (must have employee with same
             name in empList)
	post: emp is made most recent employee at his/her new rank.
    */
    public void promote(Employee emp) {
        Stack<Employee> temp = new Stack<Employee>();

	// pop all employees before emp onto temp
        while (!empList.peek().getName().equals(emp.getName())) 
            temp.push(empList.pop());
        empList.pop(); // remove employee to be promoted
        hire(emp); // treat employee as newly hired employee at the new rank
        while (!temp.empty()) // pop back employees in temp onto empList
            empList.push(temp.pop());
    }

    public String toString() {
        String strToPrint = "";
	Stack<Employee> temp = new Stack<Employee>();

	if (empList.empty())
	    strToPrint += "@\n";
        while (!empList.empty()) {
            temp.push(empList.pop()); // pop empList onto temp
            strToPrint += temp.peek()+"\n"; // concatenate top of temp to strToPrint
	}
	while (!temp.empty()) // pop all of temp back to empList
	    empList.push(temp.pop());	

        return strToPrint;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpManagement em = new EmpManagement();

        em.simulate(sc);
    }
}
