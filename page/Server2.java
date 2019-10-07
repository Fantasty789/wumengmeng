package page;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;
public class Server2
{
	public static void main(String []args) throws Exception
	{
		ServerSocket server=new ServerSocket(888);
		while(true)
		{
			Socket socket=server.accept();
			SocketHandler handler=new SocketHandler(socket);
			Thread thread=new Thread(handler);
			thread.start();
		}
}
}
