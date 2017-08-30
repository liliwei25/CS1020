import java.util.*;

class Digit {

	// Data attributes
	private int digit;
	private Digit next;

	// Constructors
	// This default constructor has an empty body
	public Digit() {
	}

	public Digit(int digit, Digit next) {
		this.digit = digit;
		this.next = next;
	}

	// Accessors
	public int getDigit() {
		return digit;
	}

	public Digit getNext() {
		return next;
	}

	public void setDigit(int digit) {
		this.digit = digit;
	}

	public void setNext(Digit next) {
		this.next = next;
	}
}

// Added the tail attribute and updated the methods accordingly
// Added a recursive version of sum
class BigNumber {
	private Digit head = null;
	private Digit tail = null;
	private int length = 0;

	// Constructors
	// This default constructor has an empty body
	public BigNumber() {

	}

	// Build a linked list of digits
	public BigNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			add(Character.getNumericValue(number.charAt(i)));
		}
	}

	public Digit getHead() {
		return head;
	}

	public void remove() {
		head = head.getNext();
		length--;
		if (head == null){
			tail = null;
		}
	}

	public int getLength() {
		return length;
	}

	// Append a digit to the linked list
	public void add(int digit) {
		Digit newHead = new Digit(digit, null);
		newHead.setNext(head);
		head = newHead;
		length++;
		if (length==1){
			tail = newHead;
		}
	}

	public void addLast(int digit) {
		if (tail == null){
			tail = new Digit(digit, null);
			head = tail;
		} else {
			tail.setNext(new Digit(digit, null));
			tail=tail.getNext();
		}
		length++;
	}

	public Digit getTail() {
		return tail;
	}

	// Sum two big numbers and return its sum
	public static String sum(BigNumber n1, BigNumber n2) {
		int carry = 0;
		Digit cur1 = n1.getHead();
		Digit cur2 = n2.getHead();
		BigNumber result = new BigNumber();

		// Keep adding digit by digit until we reach the end of either number.
		for (int i = 0; i < n1.getLength() && i < n2.getLength(); i++) {
			int newNum = carry + cur1.getDigit() + cur2.getDigit();
			result.add(newNum % 10);
			carry = newNum / 10;
			cur1 = cur1.getNext();
			cur2 = cur2.getNext();
		}

		// In case the lengths are the same, we are done when the carry is added.
		// If one number is longer than the other, we will have to add the remaining digits to the final result.
		if (n1.getLength() == n2.getLength()) {
			result.add(carry);
		}
		else if (n1.getLength() > n2.getLength()) {
			for (int i = 0; i < n1.getLength() - n2.getLength(); i++) {
				int newNum = cur1.getDigit();
				if (newNum + carry > 9) {
					result.add(0);
				}
				else {
					result.add(newNum + carry);
					carry = 0;
				}
				cur1 = cur1.getNext();
			}
			if (carry == 1) {
				result.add(carry);
			}
		}
		else {
			for (int i = 0; i < n2.getLength() - n1.getLength(); i++) {
				int newNum = cur2.getDigit();
				if (newNum + carry > 9) {
					result.add(0);
				}
				else {
					result.add(newNum + carry);
					carry = 0;
				}
				cur2 = cur2.getNext();
			}
			if (carry == 1) {
				result.add(carry);
			}
		}

		// Remove extra zeros from the front.
		int originalLength = result.getLength();
		for (int i = 0; i < originalLength; i++) {
			if (result.getHead().getDigit() == 0 && result.getLength() > 1)
				result.remove();
			else
				break;
		}
		return result.toString();
	}

	// Sum two big numbers recursively and return its sum
	public static String sumRecursive(BigNumber n1, BigNumber n2) {
		BigNumber result = sumRecursiveHelper(n1.getHead(), n2.getHead(), 0);

		// Remove extra zeros from the front.
		int originalLength = result.getLength();
		for (int i = 0; i < originalLength; i++) {
			if (result.getHead().getDigit() == 0 && result.getLength() > 1)
				result.remove();
			else
				break;
		}
		return result.toString();
	}

	public static BigNumber sumRecursiveHelper(Digit d1, Digit d2, int carry){
		int total, digit, digit1, digit2;
		Digit nextD1, nextD2;
		BigNumber result = new BigNumber();

		if (d1 == null && d2 == null){
			if (carry == 1){
				result.add(carry);
			}
		} else {
			digit1 = (d1 != null)?d1.getDigit():0;
			digit2 = (d2 != null)?d2.getDigit():0;
			total = digit1 + digit2 + carry;
			digit = total % 10;
			carry = total / 10;
			nextD1 = (d1 != null)?d1.getNext():null;
			nextD2 = (d2 != null)?d2.getNext():null;

			result = sumRecursiveHelper(nextD1, nextD2, carry);
			result.addLast(digit);
		}

		return result;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Digit cur = head;
		for (int i = 0; i < length; i++) {
			sb.append(Integer.toString(cur.getDigit()));
			cur = cur.getNext();
		}
		return sb.toString();
	}
}

public class TestBigNumber {

	public static void main(String[] args) {
		// Declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// Declare the necessary variables
		int lines = 0;
		//String[] numbers = new String[40];
		BigNumber[] bigNumbers = new BigNumber[40];

		// Read input and process them accordingly
		lines = sc.nextInt();
		for (int i = 0; i < lines; i++) {
			bigNumbers[i*2] = new BigNumber(sc.next());
			bigNumbers[i*2+1] = new BigNumber(sc.next());
		}

		// Output the result
		// Ensure your output is in the right format
		for (int i = 0; i < lines; i++) {
			System.out.println(BigNumber.sumRecursive(bigNumbers[i*2], bigNumbers[i*2+1]));
		}

		sc.close();
	}
}
