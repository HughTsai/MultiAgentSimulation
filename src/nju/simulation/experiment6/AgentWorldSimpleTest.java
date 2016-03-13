package nju.simulation.experiment6;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import nju.agent.AgentRelations;
import nju.agent.FirmAgent;
import nju.simulation.util.AgentsWorld;
import nju.simulation.util.Logger;
import nju.simulation.util.OutboundException;

/**
 * 用户模拟实验6的实现类
 * 其中包含每次模拟的实现method；
 * @author HUGH
 *
 */
public class AgentWorldSimpleTest extends AgentsWorld{
	
	public static long INTERVAL = 0;
	//该次实验中，k上限，下限，增量
	private double kUpper;
	private double kLower;
	private double kIncrement;
	//该次实验的agent数量
	private int agentNum = -1;
	//存放该次实验的所有结果
	private ExperimentData results = null;
	
	
	
	public AgentWorldSimpleTest(double kUpper, double kLower, double kIncrement,
			int agentNum) {
		super();
		this.kUpper = kUpper;
		this.kLower = kLower;
		this.kIncrement = kIncrement;
		this.agentNum = agentNum;
		this.results = new ExperimentData((double)agentNum);
		
	}
	@Override
	protected void initRelations() {
		// TODO 自动生成的方法存根
		int len = agents.length;//agent的数量
		double[][] relations = getEmptyRelations(len);
//		//下面手动输入边之间的关系==彭楠的
//		relations[0][1] = 30;
//		relations[1][2] = 40;
//		relations[2][3] = 40;
//		relations[3][4] = 5;
//		relations[4][5] = 3;
//		
//		relations[5][6] = 10;
//		relations[6][7] = 8;
//		relations[7][8] = 10;
//		relations[8][9] = 8;
//		relations[10][1] = 20;
//		
//		relations[10][11] = 10;
//		relations[10][12] = 15;
//		relations[11][13] = 8;
//		relations[12][13] = 10;
//		relations[13][2] = 10;
//		
//		relations[13][18] = 5;
//		relations[18][3] = 3;
//		relations[15][16] = 25;
//		relations[14][17] = 15;
//		relations[16][17] = 20;
//		
//		relations[17][18] = 5;
//		relations[17][20] = 15;
//		relations[20][19] = 10;
//		relations[3][19] = 30;
//		relations[19][5] = 15;
//		
//		relations[19][21] = 15;
//		relations[24][22] = 15;
//		relations[22][21] = 10;
//		relations[23][21] = 30;
//		relations[5][29] = 5;
//		
//		relations[21][29] = 40;
//		relations[29][7] = 10;
//		relations[29][30] = 10;
//		relations[29][31] = 15;
//		relations[7][37] = 5;
//		
//		relations[37][8] = 2;
//		relations[37][39] = 2;
//		relations[23][25] = 50;
//		relations[25][26] = 15;
//		relations[25][27] = 10;
//		
//		relations[25][28] = 10;
//		relations[26][31] = 7;
//		relations[26][32] = 7;
//		relations[27][32] = 2;
//		relations[27][33] = 5;
//		
//		relations[28][33] = 7;
//		relations[31][38] = 10;
//		relations[31][36] = 8;
//		relations[33][36] = 6;
//		relations[33][43] = 4;
//		
//		relations[38][41] = 7;
//		relations[40][41] = 5;
//		relations[40][42] = 5;
//		relations[36][42] = 12;
//		relations[42][43] = 13;
//		
//		relations[23][34] = 30;
//		relations[34][35] = 25;
//		relations[35][44] = 10;
//		relations[35][48] = 10;
//		relations[45][47] = 20;
//		
//		relations[46][47] = 25;
//		relations[47][48] = 15;
//		relations[47][49] = 15;
//		relations[49][48] = 10;
//		
//		//上面是边关系的输入
		
		
		
		//下面手动输入边之间的关系==火山的
		relations[0][7] = 50;
		relations[0][8] = 20;
		relations[0][9] = 30;
		relations[1][0] = 20;
		relations[1][5] = 15;
		relations[2][0] = 40;
		relations[3][0] = 50;
		relations[4][0] = 30;
		relations[4][8] = 10;
		relations[5][10] = 25;
		relations[7][12] = 30;
		relations[7][14] = 5;
		relations[8][14] = 5;
		relations[8][16] = 7;
		relations[8][17] = 6;
		relations[9][10] = 5;
		relations[9][12] = 5;
		relations[9][13] = 10;
		relations[10][30] = 15;
		relations[11][5] = 30;
		relations[12][15] = 18;
		relations[12][18] = 4;
		relations[13][27] = 4;
		relations[13][31] = 4;
		relations[14][12] = 3;
		relations[14][33] = 2;
		relations[15][35] = 10;
		relations[16][33] = 15;
		relations[18][35] = 20;
		relations[19][3] = 25;
		relations[19][4] = 25;
		relations[20][4] = 25;
		relations[20][16] = 13;
		relations[21][3] = 10;
		relations[22][3] = 30;
		relations[23][1] = 5;
		relations[23][2] = 50;
		relations[24][1] = 30;
		relations[24][11] = 10;
		relations[24][43] = 20;
		relations[25][6] = 5;
		relations[25][23] = 25;
		relations[26][10] = 10;
		relations[26][11] = 22;
		relations[27][31] = 30;
		relations[28][11] = 5;
		relations[28][26] = 35;
		relations[29][26] = 10;
		relations[32][27] = 20;
		relations[33][36] = 10;
		relations[33][37] = 5;
		relations[34][18] = 20;
		relations[35][36] = 30;
		relations[37][38] = 2;
		relations[39][20] = 10;
		relations[39][38] = 10;
		relations[40][19] = 30;
		relations[40][20] = 10;
		relations[41][19] = 30;
		relations[41][20] = 20;
		relations[41][22] = 20;
		relations[42][22] = 20;
		relations[44][29] = 10;
		relations[44][32] = 25;
		relations[45][6] = 30;
		relations[45][21] = 20;
		relations[45][42] = 40;
		relations[46][23] = 35;
		relations[46][24] = 25;
		relations[47][24] = 30;
		relations[48][24] = 20;
		relations[49][28] = 50;
		relations[49][29] = 50;
		relations[49][43] = 5;
		//上面是边关系的输入
		
		
		
		AgentRelations.getInstance().initRelations(relations, agents);
	}
	/**
	 * 获取空的边数组
	 * @param len 数组的长度（实际为agent的数量）
	 * @return
	 */
	private double[][] getEmptyRelations(int len){
		double[][] relations = new double[len][len];
		for(int i = 0 ; i < len ; i++){
			for( int j = 0 ; j < len ; j++){
				relations[i][j] = 0;
			}
		}
		
		return  relations;
	}

	@Override
	@Deprecated//方法废弃（过时）
	protected void initAgents(){}
	
	public void init(double u, double aerfa, double e, double k){
		bankruptNum = 0;
		initAgents(u,aerfa,e,k);
		initRelations();
	}
	protected void initAgents(double u, double aerfa, double e, double k) {
		// TODO 自动生成的方法存根
		//double u = 15;// 破产阈值，u >0 , 
		//double aerfa = 0.6;//破产传染逆向影响系数，  0<=aerfa<=1
		//double e = 2;// 周期回复最小值
		//double k = 4;// 周期回复速率指标。k越大，回复越慢(周期回复的值越小）。
		
//		//==========彭楠的结点
//				int[] c = {20,30,30,30,2,
//							10,5,12,5,4,
//							30,5,8,13,10,
//							20,15,15,2,20,
//							8,30,8,80,10,
//							20,10,5,4,25,
//							8,14,5,8,18,
//							15,8,3,5,1,
//							7,8,7,14,8,
//							15,17,19,20,7};
		
		
		//火山的结点
		int[] c = {100,	15,	30,	45,	35,	//第1行
					20,	30,	28,	25,	20,	//第2行
					25,	28,	20,	5,	5,	//第3行
					10,	15,	5,	20,	45,	//第4行
					35,	5,	30,	50,	60,	//第5行
					25,	40,	25,	35,	5,	//第6行
					10,	25,	20,	10,	19,	//第7行
					25,	35,	2,	10,	15,	//第8行
					35,	50,	15,	20,	25,	//第9行
				   100,	50,	25,	18,	50};//第10行
	
		agents = new FirmAgent[50]; 
		for(int i = 0; i < 50 ; i++){
			agents[i] = new FirmAgent("Agent "+i, c[i]*u, aerfa, c[i], e, k);
		}

	}
	
	@Override 
	@Deprecated//方法废弃（过时）
	public  void startSimulation(){}
	/**
	 * 破产传递的“一次”模拟（只适用于实验6）
	 * @param num 该次模拟的序号
	 * @param currentKValue 该次模拟的k值
	 */
	private void startSimulation(int num ,double currentKValue) {
		// TODO 自动生成的方法存根
		int turnbefore_bankruptNums = 0;
		timestep = 0;
		
		while(turnbefore_bankruptNums != AgentsWorld.bankruptNum){
			turnbefore_bankruptNums = AgentsWorld.bankruptNum;
			timestep++;
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			//运行模拟
			for(int i = 0 ; i < agents.length ; i++){
				FirmAgent agent = agents[i];
				if(!agent.isBankruptcy())
					agent.thinking();
			}
		}
		timestep = 0;
		System.out.println("当前k值为："+currentKValue+":第"+(num+1)+"次模拟结束");
	}
	/**
	 * 实验模拟
	 * @param simulateNum 每个k值需要模拟的次数
	 * @param initBankruptNumP 设置初始破产结点数量
	 */
	public void simulate(int initBankruptNumP ,int simulateNum){
		int initBankruptNum = initBankruptNumP;
		RecoverRateRstData recoverRateRstData = null;
		
		results.clean();//实验前结果集清空
		

		try {
			Logger.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//让α值从最小值一直增加到最大值
		for(double kValue = this.kLower;kValue <= this.kUpper;kValue += this.kIncrement){
			kValue = this.round(kValue, 3);
			recoverRateRstData = new RecoverRateRstData(kValue);
			//一个α值，进行多次模拟
			for(int i = 0;i < simulateNum;i++){
				this.init(0.3, 0.5, 2, kValue);
				if(initBankruptNum > agents.length)
					break;
				Logger.log_startSimulation();//日志开始记录
				
				initBankruptcySource(initBankruptNum);
				
				startSimulation(i, kValue);
				recoverRateRstData.addData(AgentsWorld.bankruptNum);
				
				Logger.log_endSimulation();//日志结束记录
			}
			results.addData(recoverRateRstData);
		}
		Logger.stop();
		
		//用图显示结果。
		results.showData();
	}
	
	/**
	 * 随机选择初始破产结点
	 * @param n 初始破产结点的数量
	 * @param len agent的总数量
	 * @return 返回被选择破产的结点list
	 */
	private ArrayList<Integer> selectDistinctNums(final int n, final int len){
		if(n == 0)
			return null;
		if(n == len){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 0 ; i < len; i ++){
				temp.add(i);
			}
			
			return temp;
		}
		
		int count = n;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(count > 0){
			//初始化破产节点
			int d = (int) Math.floor( Math.random() * len );
			if(d == len)
				d = len-1;
			
			if(!list.contains(d)){
				list.add(d);
				count--;
			}
		}
		
		
		return list;
	}
	
	/**
	 * 设置初始破产结点的数量
	 * @param n 初始破产结点的数量
	 */
	public void initBankruptcySource(final int n){
		int len = agents.length;
		if(n > len){
			throw new OutboundException();
		}
		
		if(n < len/2){
			ArrayList<Integer> indexes = this.selectDistinctNums(n, len);
			if(indexes == null)
				return;
			for(int i = 0; i < indexes.size() ;  i++){
				int index = indexes.get(i);
				agents[index].setBankruptcy();
			}
		}else{
			int exclude_nums = len - n;
			ArrayList<Integer> list = this.selectDistinctNums(exclude_nums, len);
			for(int i = 0 ; i < len ; i++){
				if(!list.contains(i)){
					agents[i].setBankruptcy();
				}
			}
		}
		
		AgentsWorld.bankruptNum = n;//与设置多少个破产传染源有关
	}
	/**
	 * 用于将小数平滑至最接近它本身的数，控制double类型的精度
	 * @param source 传入α的值
	 * @param newValue 保留的精度
	 * @return 平滑后的结果
	 */
    private double round(double source,int newValue){
    	DecimalFormat formater = new DecimalFormat();
    	formater.setMaximumFractionDigits(newValue);
    	formater.setRoundingMode(RoundingMode.HALF_DOWN);
    	String result = formater.format(source);
    	
    	return Double.parseDouble(result);
    }
}
