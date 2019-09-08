package shiyan1;

abstract public class CShape
{
		CShape()
		{
			
		}
		abstract boolean IsMatched();
		abstract void Serialize();
		abstract void Draw();
		abstract void Set();
		int OrgX;
		int OrgY;
		String BorderColor;
		int BorderType;
		int BorderWidth;
		String FillColor;
		int FillType;
		String Font;
		public static void main(String[] arg)
		{
			CShape a =new CSquare();
			a.Draw();
			CShape b=new Text();
			b.Draw();
		}
}
