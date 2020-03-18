package chain;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFruitSort {
	private int weight;
	protected List<String> fruitBox;
	private AbstractFruitSort nextFuritSort;

	public void getFruitBox() {
		System.out.println("Weight:" + weight);
		System.out.println("¸öÊý£º" + fruitBox.size());
		for (String t : fruitBox) {
			System.out.print(t + ",");
		}
		System.out.println(" ");
	}

	public void setNextSort(AbstractFruitSort nextFuritSort) {
		this.nextFuritSort = nextFuritSort;

	}

	public AbstractFruitSort(int weight) {
		// TODO Auto-generated constructor stub
		this.weight = weight;
		fruitBox = new ArrayList<String>();

	}

	public void sendFruit(int weight,String fruit) {
		if(this.weight<=weight) {
			pushBox(fruit);
		}
		else
			if(nextFuritSort!=null)
				nextFuritSort.sendFruit(weight, fruit);
	}

	protected abstract void pushBox(String fruit);

}
