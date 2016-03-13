package nju.simulation.experiment5;

import java.util.ArrayList;

import expt5.DotGraph;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;


/**
 * 该类用于存放最终的实验结果
 * @author HUGH
 *
 */
public class ExperimentData {
	//存放每次e值及其对应的平均BN值
	private ArrayList<RecoverRstData> results = new ArrayList<RecoverRstData>();
	//存放所有的e值
	private double[] eValues = null;
	//存放所有alpha值对应的BN/SN值
	private double[] BN_SNs = null;
	//存放所有agent的数量
	private double agentNum = -1;
	
	
	
	/**
	 * 构造对象时，需要传入agentNum的数量
	 * @param agentNum
	 */
	public ExperimentData(double agentNum) {
		super();
		this.agentNum = agentNum;
	}
	/**
	 * 将一个e的结果计入result
	 * @param oneEValueRst 该e的结果
	 */
	public void addData(RecoverRstData oneEValueRst){
		results.add(oneEValueRst);
	}
	/**
	 * 清空该次实验的结果
	 */
	public void clean(){
		results.clear();
	}
	/**
	 * 计算所有BN/SN的值，并初始化e与BN_SNs数组
	 */
	private void calResult(){
		int len = results.size();
		eValues = new double[len];
		BN_SNs = new double[len];
		
		for(int i = 0;i < len;i++){
			RecoverRstData temp = results.get(i);
			eValues[i] = temp.getE();
			BN_SNs[i] = temp.getAvgBN()/this.agentNum;
		}
	}
	
	
	
	
	
	
	//==============================================================
	/**
	 * 显示实验结果的diagram
	 */
	public void showData(){
		System.out.println("开始计算实验结果");
		calResult();
		//printArray();
		System.out.println("开始显示数据图表");
		plot();
	}
	
	private void plot(){
		//get x,y 
		int len = results.size();
		double[] ax = new double[len];
		double[] ay = new double[len];
		
		for(int i = 0 ; i < len ; i++){
			ax[i] = this.eValues[i];//将e作为横坐标
			ay[i] = this.BN_SNs[i];//将BN/SN作为纵坐标
		}
		
		MWNumericArray x = new MWNumericArray(ax, MWClassID.DOUBLE);
		MWNumericArray y = new MWNumericArray(ay, MWClassID.DOUBLE);
		
		try {
			DotGraph figure = new DotGraph();
			figure.Plot(x,y);
			figure.waitForFigures();
			
			figure.dispose();
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MWArray.disposeArray(x);
			MWArray.disposeArray(y);
			System.out.println("Over!!!!!");
		}
	}
	
	
}
