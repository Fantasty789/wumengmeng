package proxy;

public class CREmoPic implements IShowPic {

	@Override
	public void ShowPic(String picname) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			System.out.println(i+1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
