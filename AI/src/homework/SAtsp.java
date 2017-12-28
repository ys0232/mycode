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

	private int cityNum; // �������������볤��
	private int N;// ÿ���¶ȵ�������
	private int T;// ���´���
	private float a;// ����ϵ��
	private float t0;// ��ʼ�¶�

	private int[][] distance; // �������
	private int bestT;// ��ѳ��ȵ�������

	private int[] Ghh;// ��ʼ·������
	private int GhhEvaluation;
	private int[] bestGh;// ��õ�·������
	private int bestEvaluation;
	private int[] tempGhh;// �����ʱ����
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
		// ��ȡ����
		double[] x;
		double[] y;
		String strbuff;
		BufferedReader data = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename)));
		distance = new int[cityNum][cityNum];
		x = new double[cityNum];
		y = new double[cityNum];
		for (int i = 0; i < cityNum; i++) {
			// ��ȡһ�����ݣ����ݸ�ʽ1 6734 1453
			// �ַ��ָ�
			strbuff=data.readLine();
			String[] strcol=strbuff.split(" ");
			x[i]=Double.valueOf(strcol[1]);
			y[i]=Double.valueOf(strcol[2]);
			
			}
		// ����������
		for (int i = 0; i < cityNum - 1; i++) {
			distance[i][i] = 0; // �Խ���Ϊ0
			for (int j = i + 1; j < cityNum; j++) {
			double rij = Math
						.sqrt(((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])
								* (y[i] - y[j]))/10.0);
				// �������룬ȡ��
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
		
		System.out.println("���������� "+cityNum+","+"ÿ���¶ȵ������������� "+N+","+"���´����� "+T+","+"�����ٶȣ� "+a+","+"��ʼ�¶ȣ� "+t0);
	//	for(int i=0;i<cityNum;i++)
		//	System.out.println(Arrays.toString(distance[i]));

	}

	// ��ʼ������Ghh
	void initGroup() {
		int i, j;
		Ghh[0] = random.nextInt(65535) % cityNum;
		for (i = 1; i < cityNum;)// ���볤��
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

	// ���Ʊ����壬���Ʊ���Gha��Ghb
	public void copyGh(int[] Gha, int[] Ghb) {
		for (int i = 0; i < cityNum; i++) {
			Ghb[i] = Gha[i];
		}
	}

	public int evaluate(int[] chr) {
		int len = 0;
		// ���룬��ʼ����,����1,����2...����n
		for (int i = 1; i < cityNum; i++) {
			len += distance[chr[i -1]][chr[i]];
		}
		// ����n,��ʼ����
		len += distance[chr[cityNum - 1]][chr[0]];
		return len;
	}

	// ���򽻻����õ��ھ�
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
		// ��ʼ������Ghh
		initGroup();
		copyGh(Ghh, bestGh);// ���Ƶ�ǰ����Ghh����ñ���bestGh
		bestEvaluation = evaluate(Ghh);
		GhhEvaluation = bestEvaluation;
		int k = 0;// ���´���
		int n = 0;// ��������
		float t = t0;
		float r = 0.0f;
		
		while (k < T) {
			n = 0;
			while (n < N) {
				neighbor(Ghh, tempGhh);// �õ���ǰ����Ghh���������tempGhh
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
		
		System.out.println("��ѳ��ȵ���������");
		System.out.println(bestT);
		System.out.println("��ѳ���");
		System.out.println(bestEvaluation);
		System.out.println("���·����");
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