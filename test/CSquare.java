package shiyan1;

public class CSquare extends CShape
{
	CSquare()
	{}
	int width;
	//�������ζ�����߼�����
	CSquare(int x,int y)
	{
		OrgX=x;
		OrgY=y;
	    System.out.println("Initialize Square");
	}
	//��ͼ 
	

	void Draw(/* CDC* pDC */)
	{
	   System.out.println("Square Draw");
	}
    //�Ƿ����������ξ���ͼ�ε�������
	boolean IsMatched()
	{
		System.out.println("Square_IsMatched");
		return true;
	}
	//��¼���������
	void Serialize()
	{
		System.out.println("Square Serialize");
	}
	void Set()
	{
		System.out.println("Square Pass Parament");
		
	}
}
