package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SAtsp {

	private int cityNum; // 城市数量，编码长度
	private int N;// 每个温度迭代步长
	private int T;// 降温次数
	private float a;// 降温系数
	private float t0;// 初始温度

	private int[][] distance; // 距离矩阵
	private int bestT;// 最佳长度迭代次数

	private int[] Ghh;// 初始路径编码
	private int GhhEvaluation;
	private int[] bestGh;// 最好的路径编码
	private int bestEvaluation;
	private int[] tempGhh;// 存放临时编码
	private int tempEvaluation;

	private Random random;
	
	public SAtsp(int cn, int n, int t, float tt, float aa) {
		cityNum = cn;
		N = n;
		T = t;
		t0 = tt;
		a = aa;
	}

	@SuppressWarnings("resource")
	
	private void init(String filename) throws IOException {
		// 读取数据
		double[] x;
		double[] y;
		String strbuff;
		BufferedReader data = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename)));
		distance = new int[cityNum][cityNum];
		x = new double[cityNum];
		y = new double[cityNum];
		for (int i = 0; i < cityNum; i++) {
			// 读取一行数据，数据格式1 6734 1453
			// 字符分割
			strbuff=data.readLine();
			String[] strcol=strbuff.split(" ");
			x[i]=Double.valueOf(strcol[1]);
			y[i]=Double.valueOf(strcol[2]);
			
			}
		// 计算距离矩阵
		for (int i = 0; i < cityNum - 1; i++) {
			distance[i][i] = 0; // 对角线为0
			for (int j = i + 1; j < cityNum; j++) {
			double rij = Math
						.sqrt(((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])
								* (y[i] - y[j]))/10.0);
				// 四舍五入，取整
				int tij = (int) Math.round(rij);
				if (tij < rij) {
					distance[i][j] = tij + 1;
					distance[j][i] = distance[i][j];
				} else {
					distance[i][j] = tij;
					distance[j][i] = distance[i][j];
				}
			}
				
			}
			
		distance[cityNum - 1][cityNum - 1] = 0;

		Ghh = new int[cityNum];
		bestGh = new int[cityNum];
		bestEvaluation = Integer.MAX_VALUE;
		tempGhh = new int[cityNum];
		tempEvaluation = Integer.MAX_VALUE;
		bestT = 0;
		random = new Random(System.currentTimeMillis());
		
		System.out.println("城市数量： "+cityNum+","+"每个温度的最大迭代次数： "+N+","+"降温次数： "+T+","+"降温速度： "+a+","+"初始温度： "+t0);
	//	for(int i=0;i<cityNum;i++)
		//	System.out.println(Arrays.toString(distance[i]));

	}

	// 初始化编码Ghh
	void initGroup() {
		int i, j;
		Ghh[0] = random.nextInt(65535) % cityNum;
		for (i = 1; i < cityNum;)// 编码长度
		{
			Ghh[i] = random.nextInt(65535) % cityNum;
			for (j = 0; j < i; j++) {
				if (Ghh[i] == Ghh[j]) {
					break;
				}
			}
			if (j == i) {
				i++;
			}
		}
	}

	// 复制编码体，复制编码Gha到Ghb
	public void copyGh(int[] Gha, int[] Ghb) {
		for (int i = 0; i < cityNum; i++) {
			Ghb[i] = Gha[i];
		}
	}

	public int evaluate(int[] chr) {
		int len = 0;
		// 编码，起始城市,城市1,城市2...城市n
		for (int i = 1; i < cityNum; i++) {
			len += distance[chr[i -1]][chr[i]];
		}
		// 城市n,起始城市
		len += distance[chr[cityNum - 1]][chr[0]];
		return len;
	}

	// 邻域交换，得到邻居
	public void neighbor(int[] Gh, int[] tempGh) {
		int i, temp;
		int ran1, ran2;

		for (i = 0; i < cityNum; i++) {
			tempGh[i] = Gh[i];
		}
		ran1 = random.nextInt(65535) % cityNum;
		ran2 = random.nextInt(65535) % cityNum;
		while (ran1 == ran2) {
			ran2 = random.nextInt(65535) % cityNum;
		}
		temp = tempGh[ran1];
		tempGh[ran1] = tempGh[ran2];
		tempGh[ran2] = temp;
	}

	public void solve() {
		// 初始化编码Ghh
		initGroup();
		copyGh(Ghh, bestGh);// 复制当前编码Ghh到最好编码bestGh
		bestEvaluation = evaluate(Ghh);
		GhhEvaluation = bestEvaluation;
		int k = 0;// 降温次数
		int n = 0;// 迭代步数
		float t = t0;
		float r = 0.0f;
		
		while (k < T) {
			n = 0;
			while (n < N) {
				neighbor(Ghh, tempGhh);// 得到当前编码Ghh的邻域编码tempGhh
				tempEvaluation = evaluate(tempGhh);
                if (tempEvaluation < bestEvaluation)
                {
                    copyGh(tempGhh, bestGh);
                    bestT = k;
                    bestEvaluation = tempEvaluation;
                }
				r = random.nextFloat();
				if (tempEvaluation < GhhEvaluation
						|| Math.exp((GhhEvaluation - tempEvaluation) / t) > r) {
					copyGh(tempGhh, Ghh);
					GhhEvaluation = tempEvaluation;
				}
				n++;
			}
			t = a * t;
			k++;
		}
		
		System.out.println("最佳长度迭代次数：");
		System.out.println(bestT);
		System.out.println("最佳长度");
		System.out.println(bestEvaluation);
		System.out.println("最佳路径：");
		for (int i = 0; i < cityNum; i++) {
			
			if (i % 10 == 0 && i != 0 || i==cityNum-1) {
				System.out.println(bestGh[i]);
			}
			else
				System.out.print(bestGh[i] + "-->");
		}
	}

	public static void main(String[] args) throws IOException {
		
		SAtsp sa = new SAtsp(48, 300, 1000, 350.0f, 0.99f);
		sa.init("c://data.txt");
		sa.solve();
	}
}