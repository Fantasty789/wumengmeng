package shiyan1;

public class Text extends CShape{
	int width;
	//求文字顶点的逻辑坐标
	Text(){}
	Text(int x,int y)
	{
		OrgX=x;
		OrgY=y;
			System.out.println("Text Initialized");
	}
	//画图 
	void Draw(/* CDC* pDC */)
	{
	   System.out.println("Text Draw");
	}
    //是否落在文字图形的区域内
	boolean IsMatched()
	{
		System.out.println("Text IsMatched");
		return true;
	}
	//记录输入的数据
	void Serialize()
	{
		System.out.println("Text Serialize");
	}
	void Set()
	{
		System.out.println("Text Pass Parament");
		
	}
	

}
