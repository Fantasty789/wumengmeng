package proxy;

public class CLocalPic implements IShowPic, Runnable {
	private IShowPic pic;
	private String picname;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		pic.ShowPic(picname);
		System.out.println(picname + "ͼƬ�������");
	}

	@Override
	public void ShowPic(String picname) {
		// TODO Auto-generated method stub
		pic = new CREmoPic();
		this.picname = picname;
		System.out.println("׼������ͼƬ" + picname);
		Thread th = new Thread(this);
		th.start();
	}

}