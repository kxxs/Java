package util;
import java.util.*;
import model.Deal;

public class DealAmountComparator implements Comparator<Deal>{

	public int compare(Deal a, Deal b) {
		return Integer.parseInt(a.getAmount())-Integer.parseInt(b.getAmount());
	}
	
}
