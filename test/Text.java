package shiyan1;

public class Text extends CShape{
	int width;
	//�����ֶ�����߼�����
	Text(){}
	Text(int x,int y)
	{
		OrgX=x;
		OrgY=y;
			System.out.println("Text Initialized");
	}
	//��ͼ 
	void Draw(/* CDC* pDC */)
	{
	   System.out.println("Text Draw");
	}
    //�Ƿ���������ͼ�ε�������
	boolean IsMatched()
	{
		System.out.println("Text IsMatched");
		return true;
	}
	//��¼���������
	void Serialize()
	{
		System.out.println("Text Serialize");
	}
	void Set()
	{
		System.out.println("Text Pass Parament");
		
	}
	

}
