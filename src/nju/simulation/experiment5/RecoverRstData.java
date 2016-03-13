package nju.simulation.experiment5;

import java.util.ArrayList;

/**
 * 当不同e值时，用于存放每次模拟结果
 * @author HUGH
 *
 */
public class RecoverRstData {
	//保存当下的e值
	private double e;
	//用于保存该e值时，每一次模拟的结果，即最终破产agent数量
	private ArrayList<Double> BNs = new ArrayList<Double>();
	//总共模拟的次数
	private int num;
	//破产agent数量的平均值
	private double avgBN = -1;
	
	
	
	public RecoverRstData(double e){
		this.e = e;
	}
	/**
	 * 用于将一次模拟的BN结果值，添加进BNs集合
	 * @param BN
	 */
	public void addData(double BN){
		BNs.add(BN);
	}
	
	/**
	 * 获取所有模拟结果的平均值
	 * @return BNs的平均值
	 */
	public double getAvgBN(){
		if(this.avgBN == -1){
			this.num = BNs.size();//获取该alpha值的模拟次数
			int sum = 0;
			for(double i:BNs){
				sum += i;
			}
			this.avgBN = ((double)sum)/((double)this.num);
		}
		return this.avgBN;
	}
	public double getE(){
		return this.e;
	}
}
