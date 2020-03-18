package command;

import java.util.HashMap;

public class Order {
	private int id;
	private HashMap<String, Integer> fruitmap;

	public Order() {
		// TODO Auto-generated method stub
		fruitmap = new HashMap<String, Integer>();
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, Integer> getFruitmap() {
		return fruitmap;
	}

	public void setFruitmap(String fruitkind, int quantity) {
		this.fruitmap.put(fruitkind, quantity);
	}

}
