package nju.simulation.experiment3;

import nju.simulation.experiment3.AgentWorldSimpleTest;

public class Main3 {

	private static final double ALPHAUPPER = 1;//α值的上限
	private static final double ALPHALOWER = 0;//α值的下限
	private static final double ALPHAINCREMENT = 0.01;//α值的增量
	
	private final static int SIMULATION_TIMES = 1000;//每个α值模拟次数
	private final static int INIT_BANKRUPT_NUMBER = 1;//初始破产结点数量
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		AgentWorldSimpleTest agentWorld = new AgentWorldSimpleTest(ALPHAUPPER, ALPHALOWER, ALPHAINCREMENT, 50);
		agentWorld.simulate(INIT_BANKRUPT_NUMBER, SIMULATION_TIMES);
	}

}
