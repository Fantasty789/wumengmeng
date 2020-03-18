package chain;

import java.util.Random;

public class ClientClass {
	public static void main(String[] args) {
		AbstractFruitSort bfs, mfs, sfs;
		bfs = new BigFruitSorting(9);
		mfs = new MiddleFruitSorting(5);
		sfs = new SmallFruitSorting(3);

		//…Ë÷√÷∞‘¡¥
		bfs.setNextSort(mfs);
		mfs.setNextSort(sfs);

		Random rm = new Random();
		for (int i = 0; i < 1000; i++) {
			int weight = rm.nextInt(10);
			bfs.sendFruit(weight, "orange");

		}
		bfs.getFruitBox();
		mfs.getFruitBox();
		sfs.getFruitBox();
	}
}
