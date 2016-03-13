package nju.simulation.experiment6;

import nju.simulation.experiment6.AgentWorldSimpleTest;

public class Main6 {

	private static final double KUPPER = 250;//k值的上限
	private static final double KLOWER = 1;//k值的下限
	private static final double KINCREMENT = 0.5;//k值的增量
	
	private final static int SIMULATION_TIMES = 500;//每个α值模拟次数
	private final static int INIT_BANKRUPT_NUMBER = 1;//初始破产结点数量
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		AgentWorldSimpleTest agentWorld = new AgentWorldSimpleTest(KUPPER, KLOWER, KINCREMENT, 50);
		agentWorld.simulate(INIT_BANKRUPT_NUMBER, SIMULATION_TIMES);
	}

}
