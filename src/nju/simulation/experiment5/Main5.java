package nju.simulation.experiment5;

import nju.simulation.experiment5.AgentWorldSimpleTest;

public class Main5 {

	private static final double EUPPER = 250;//e值的上限
	private static final double ELOWER = 1;//e值的下限
	private static final double EINCREMENT =0.5;//e值的增量
	
	private final static int SIMULATION_TIMES = 500;//每个e值模拟次数
	private final static int INIT_BANKRUPT_NUMBER = 1;//初始破产结点数量
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		AgentWorldSimpleTest agentWorld = new AgentWorldSimpleTest(EUPPER, ELOWER, EINCREMENT, 50);
		agentWorld.simulate(INIT_BANKRUPT_NUMBER, SIMULATION_TIMES);
	}

}
