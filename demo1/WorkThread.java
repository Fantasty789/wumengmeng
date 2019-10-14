package demo1;

public class WorkThread implements Runnable{
	private int start;
	private int A[][];
	private int B[][];
	private int C[][];

	/*
	 * public WorkThread1 (int start,int [][]A,int [][]B,int [][]C) {
	 * this.start=start; this.A=A; this.B=B; this.C=C; }
	 */
public WorkThread(int start,int [][]A,int [][]B,int [][]C) {
		// TODO 自动生成的构造函数存根
	this.start=start;
	this.A=A;
	this.B=B;
	this.C=C;
	}
@Override
	public void run() {
	// TODO 自动生成的方法存根
	int i,j,k;
	for(i=start; i<Driver.M; i +=Driver.NUM_THREADS)      
	{      
		for(j=0;j<Driver.N;j++)      
		{           
			for( k=0; k< Driver.K;k++)         
				C[i][j]+=A[i][k]*B[k][j];         
		}
	}
}
}
