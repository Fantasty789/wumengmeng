package shiyan1;

public class CSquare extends CShape
{
	CSquare()
	{}
	int width;
	//求正方形顶点的逻辑坐标
	CSquare(int x,int y)
	{
		OrgX=x;
		OrgY=y;
	    System.out.println("Initialize Square");
	}
	//画图 
	

	void Draw(/* CDC* pDC */)
	{
	   System.out.println("Square Draw");
	}
    //是否落在正方形矩形图形的区域内
	boolean IsMatched()
	{
		System.out.println("Square_IsMatched");
		return true;
	}
	//记录输入的数据
	void Serialize()
	{
		System.out.println("Square Serialize");
	}
	void Set()
	{
		System.out.println("Square Pass Parament");
		
	}
}
