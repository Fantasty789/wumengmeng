package proxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IShowPic cls = new CLocalPic();
		cls.ShowPic("photo");
	}

}
