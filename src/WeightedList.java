import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WeightedList<T> {
	private ArrayList<Pair<Integer, T>> list;
	private Random rand;

	@SuppressWarnings("WeakerAccess")
	public boolean invalidPair(Pair<Integer, T> pair) {
		return pair == null || pair.getKey() == null || pair.getKey() <= 0;
	}

	@SafeVarargs
	public WeightedList(Pair<Integer, T>... listItems) {
		list = new ArrayList<>();
		rand = new Random();
		if(listItems != null)
			list.addAll(Arrays.asList(listItems));
		list.removeIf(this::invalidPair);
	}

	public T getObjectFromList() {
		int totalWeight = 0;
		for(Pair<Integer, T> pair:list)
			totalWeight += pair.getKey();
		int index = rand.nextInt(totalWeight);
		for (Pair<Integer, T> pair : list) {
			if (index >= pair.getKey())
				index -= pair.getKey();
			else
				return pair.getValue();
		}
		throw new RuntimeException("This should not have happened.");
	}

	public boolean add(Pair<Integer, T> pair) {
		if(invalidPair(pair))
			return false;
		list.add(pair);
		return true;
	}

	public boolean add(int weight, T value) {
		if(weight <= 0)
			return false;
		list.add(new Pair<>(weight, value));
		return true;
	}

	public void clear() {
		list.clear();
	}

	public ArrayList<Pair<Integer, T>> getListCopy() {
		return new ArrayList<>(list);
	}

	public boolean remove(Pair<Integer, T> pair) {
		return list.remove(pair);
	}
}
