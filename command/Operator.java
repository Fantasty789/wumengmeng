package command;

public class Operator {

	//��Ϲ�֭
	public void MarkFruit(Order order) {
		// TODO Auto-generated method stub
		String str="";
		for(String key:order.getFruitmap().keySet()) {
			str+=key+order.getFruitmap().get(key);
		}
		System.out.println("�ڰ����֭��"+str);
	}
	//System.out.println();

}
