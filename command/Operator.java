package command;

public class Operator {

	//»ìºÏ¹ûÖ­
	public void MarkFruit(Order order) {
		// TODO Auto-generated method stub
		String str="";
		for(String key:order.getFruitmap().keySet()) {
			str+=key+order.getFruitmap().get(key);
		}
		System.out.println("ºÚ°µ»ìºÏÖ­£º"+str);
	}
	//System.out.println();

}
