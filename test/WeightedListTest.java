import javafx.util.Pair;

public class WeightedListTest {
	public static void main(String[] args) {
		WeightedList<String> testList = new WeightedList<>();
		testList.add(50, "Hello World.");
		testList.add(10, "Why so serious?");
		testList.getListCopy().add(new Pair<>(100, "This should do nothing."));
		for(int i=0;i<60;i++)
			System.out.println(testList.getObjectFromList());
		testList.clear();
		System.out.println();
		testList.add(5, "Five");
		testList.add(4, "Four");
		testList.add(3, "Three");
		testList.add(2, "Two");
		testList.add(1, "One");
		//Improper usage handling test
		testList.add(null);
		testList.add(-18, "Eighteen");
		for(int i=0;i<60;i++)
			System.out.println(testList.getObjectFromList());
	}
}
