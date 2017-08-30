import java.util.*;

class ScoreComparator implements Comparator<Reading> {

	public int compare(Reading r1, Reading r2) {
		double diff = r1.getScore() - r2.getScore();
		if (diff > 0)
			return 1;
		else if (diff < 0)
			return -1;
		else 
			return 0;
	}

	public boolean equals(Object obj) {
		return this == obj;
	}
}

