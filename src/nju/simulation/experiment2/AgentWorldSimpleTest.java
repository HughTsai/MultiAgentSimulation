package nju.simulation.experiment2;

import java.io.IOException;
import java.util.ArrayList;

import nju.agent.AgentRelations;
import nju.agent.FirmAgent;
import nju.simulation.experiment2.ExperimentData;
import nju.simulation.util.AgentsWorld;
import nju.simulation.util.Logger;
import nju.simulation.util.OutboundException;
/**
 * 用户模拟实验2的实现类
 * 其中包含每次模拟的实现method；
 * @author HUGH
 *
 */
public class AgentWorldSimpleTest extends AgentsWorld {
	public static long INTERVAL = 0;
	//该次实验中，模拟次数
	private int simulateNum = 0;
	//该次实验的agent数量
	private int agentNum = -1;
	//存放该次实验的所有结果
	private ExperimentData results;
	
	
	public AgentWorldSimpleTest(int simulateNum, int agentNum) {
		super();
		this.simulateNum = simulateNum;
		this.agentNum = agentNum;
		this.results = new ExperimentData(simulateNum, agentNum);
	}
	@Override
	protected void initRelations() {
		// TODO 自动生成的方法存根
		int len = agents.length;//agent的数量
		double[][] relations = getEmptyRelations(len);
		
		//下面手动输入边之间的关系
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
	protected void initAgents() {
		// TODO 自动生成的方法存根
		double u = 15;// 破产阈值，u >0 , 
		double aerfa = 0.6;//破产传染逆向影响系数，  0<=aerfa<=1
		double e = 2;// 周期回复最小值
		double k = 4;// 周期回复速率指标。k越大，回复越慢(周期回复的值越小）。
		
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
			agents[i] = new FirmAgent("Agent "+i, c[i]*0.2, aerfa, c[i], e, k);
		}
		//下面手动输入agent
//		agents = new FirmAgent[agentNum]; 
//		agents[0] = new FirmAgent("Agent 0", u, aerfa, 100, e, k);
//		agents[1] = new FirmAgent("Agent 1", u, aerfa, 15, e, k);
//		agents[2] = new FirmAgent("Agent 2", u, aerfa, 30, e, k);
//		agents[3] = new FirmAgent("Agent 3", u, aerfa, 45, e, k);
//		agents[4] = new FirmAgent("Agent 4", u, aerfa, 35, e, k);
//		agents[5] = new FirmAgent("Agent 5", u, aerfa, 20, e, k);
//		agents[6] = new FirmAgent("Agent 6", u, aerfa, 30, e, k);
//		agents[7] = new FirmAgent("Agent 7", u, aerfa, 28, e, k);
//		agents[8] = new FirmAgent("Agent 8", u, aerfa, 25, e, k);
//		agents[9] = new FirmAgent("Agent 9", u, aerfa, 20, e, k);
//		agents[10] = new FirmAgent("Agent 10", u, aerfa, 25, e, k);
//		agents[11] = new FirmAgent("Agent 11", u, aerfa, 28, e, k);
//		agents[12] = new FirmAgent("Agent 12", u, aerfa, 20, e, k);
//		agents[13] = new FirmAgent("Agent 13", u, aerfa, 5, e, k);
//		agents[14] = new FirmAgent("Agent 14", u, aerfa, 5, e, k);
//		agents[15] = new FirmAgent("Agent 15", u, aerfa, 10, e, k);
//		agents[16] = new FirmAgent("Agent 16", u, aerfa, 15, e, k);
//		agents[17] = new FirmAgent("Agent 17", u, aerfa, 5, e, k);
//		agents[18] = new FirmAgent("Agent 18", u, aerfa, 20, e, k);
//		agents[19] = new FirmAgent("Agent 19", u, aerfa, 45, e, k);
//		agents[20] = new FirmAgent("Agent 20", u, aerfa, 35, e, k);
//		agents[21] = new FirmAgent("Agent 21", u, aerfa, 5, e, k);
//		agents[22] = new FirmAgent("Agent 22", u, aerfa, 30, e, k);
//		agents[23] = new FirmAgent("Agent 23", u, aerfa, 50, e, k);
//		agents[24] = new FirmAgent("Agent 24", u, aerfa, 60, e, k);
//		agents[25] = new FirmAgent("Agent 25", u, aerfa, 25, e, k);
//		agents[26] = new FirmAgent("Agent 26", u, aerfa, 40, e, k);
//		agents[27] = new FirmAgent("Agent 27", u, aerfa, 25, e, k);
//		agents[28] = new FirmAgent("Agent 28", u, aerfa, 35, e, k);
//		agents[29] = new FirmAgent("Agent 29", u, aerfa, 5, e, k);
//		agents[30] = new FirmAgent("Agent 30", u, aerfa, 10, e, k);
//		agents[31] = new FirmAgent("Agent 31", u, aerfa, 25, e, k);
//		agents[32] = new FirmAgent("Agent 32", u, aerfa, 20, e, k);
//		agents[33] = new FirmAgent("Agent 33", u, aerfa, 10, e, k);
//		agents[34] = new FirmAgent("Agent 34", u, aerfa, 19, e, k);
//		agents[35] = new FirmAgent("Agent 35", u, aerfa, 25, e, k);
//		agents[36] = new FirmAgent("Agent 36", u, aerfa, 35, e, k);
//		agents[37] = new FirmAgent("Agent 37", u, aerfa, 2, e, k);
//		agents[38] = new FirmAgent("Agent 38", u, aerfa, 10, e, k);
//		agents[39] = new FirmAgent("Agent 39", u, aerfa, 15, e, k);
//		agents[40] = new FirmAgent("Agent 40", u, aerfa, 35, e, k);
//		agents[41] = new FirmAgent("Agent 41", u, aerfa, 50, e, k);
//		agents[42] = new FirmAgent("Agent 42", u, aerfa, 15, e, k);
//		agents[43] = new FirmAgent("Agent 43", u, aerfa, 20, e, k);
//		agents[44] = new FirmAgent("Agent 44", u, aerfa, 25, e, k);
//		agents[45] = new FirmAgent("Agent 45", u, aerfa, 100, e, k);
//		agents[46] = new FirmAgent("Agent 46", u, aerfa, 50, e, k);
//		agents[47] = new FirmAgent("Agent 47", u, aerfa, 25, e, k);
//		agents[48] = new FirmAgent("Agent 48", u, aerfa, 18, e, k);
//		agents[49] = new FirmAgent("Agent 49", u, aerfa, 50, e, k);
		
		//上面创建agent
	}
	
	@Override //废弃的函数
	public  void startSimulation(){
	}
	/**
	 * 破产传递的“一次”模拟（只适用于实验二，比起实验一已经改造过）
	 * @param num 该次模拟的序号
	 */
	private void startSimulation(int num) {
		// TODO 自动生成的方法存根
		int turnbefore_bankruptNums = 0;
		timestep = 0;
		OnceSimuResult onceExptRst = new OnceSimuResult(num);
		onceExptRst.add(new PointResult(timestep, AgentsWorld.bankruptNum));//加入初始时的破产情况PointResult
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
			onceExptRst.add(new PointResult(timestep, AgentsWorld.bankruptNum));//该周期结束时的破产情况
			
		}
		
		
		timestep = 0;
		
		System.out.println("第"+(num+1)+"次模拟结束");
		results.addData(onceExptRst);
	}
	/**
	 * 实验模拟
	 * @param simulateNum 该次实验需要模拟破产传递的次数
	 * @param initBankruptNumP 设置初始破产结点数量
	 */
	public void simulate(int initBankruptNumP){
		int initBankruptNum = initBankruptNumP;
		
		results.clean();//实验前结果集清空
		

//		try {
//			Logger.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		for(int i = 0 ; i < simulateNum ; i++){
			init();
			if(initBankruptNum > agents.length)
				break;
			//Logger.log_startSimulation();//日志开始记录
			
			initBankruptcySource(initBankruptNum);
			
			startSimulation(i);
			
			//Logger.log_endSimulation();//日志结束记录
		}
		
//		Logger.stop();
		
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

	
}
