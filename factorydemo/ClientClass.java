package factorydemo;

import pro.*;
import pro.Apple;
import pro.Banana;

public class ClientClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFruit fru1 = new Apple();
		MyFruit fru2 = new Banana();
		MyFruitStore mfs=MyFruitStore.GetFruitStore();
		mfs.Add(1,fru1);
		mfs.Add(2,fru2);
		mfs.Add(3,new Apple());
		mfs.Add(4,new Banana());
		
		MyFruitStore mfs2=MyFruitStore.GetFruitStore();
		MyFruit fru=(MyFruit)mfs2.Get(4);
		fru.Display();
		System.out.println("mfs:"+mfs.toString());
		System.out.println("mfs2:"+mfs2.toString());
		/*
		 * fru1.Display(); fru2.Display(); System.out.println("fru1:"+fru1.hashCode());
		 * System.out.println("fru2:"+fru2.hashCode());
		 */

		/*
		 * Factory factory = new Factory(); Fruit fruit = factory.CreateFruit("B");
		 * fruit.eat();
		 */
	}

	public String Factory(String fruitname) {
		if (fruitname.equals("Apple"))
			return "Apple";
		if (fruitname.equals("Banana"))
			return "Banana";
		return null;
	}
}
