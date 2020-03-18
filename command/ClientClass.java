package command;

public class ClientClass {
	public static void main(String[] args) {
		// 创建多个订单
		Order order1 = new Order();
		order1.setId(1);
		order1.setFruitmap("apple", 2);
		order1.setFruitmap("banana", 1);
		order1.setFruitmap("peal", 2);

		Order order2 = new Order();
		order2.setId(2);
		order2.setFruitmap("tomato", 3);
		order2.setFruitmap("banana", 1);
		order2.setFruitmap("apple", 2);

		Order order3 = new Order();
		order3.setId(3);
		order3.setFruitmap("pouple", 5);
		order3.setFruitmap("apple", 1);
		order3.setFruitmap("peal", 2);

		// 创建操作者
		Operator op = new Operator();
		// 将多个订单封装成命令对象
		OrderCommand cmd1 = new OrderCommand(op, order1);
		OrderCommand cmd2 = new OrderCommand(op, order2);
		OrderCommand cmd3 = new OrderCommand(op, order3);
		// 创建调用者并加命令
		WaiterInvoker waiter = new WaiterInvoker();
		waiter.setCommands(cmd1);
		waiter.setCommands(cmd2);
		waiter.setCommands(cmd3);

		// 执行命令
		waiter.OrderUp();

	}
}
