package nju.simulation.experiment6;

import java.util.ArrayList;

import expt6.DotGraph;

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
	//存放每次k值及其对应的平均BN值
	private ArrayList<RecoverRateRstData> results = new ArrayList<RecoverRateRstData>();
	//存放所有的k值
	private double[] kValues = null;
	//存放所有k值对应的BN/SN值
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
	 * 将一个k的结果计入result
	 * @param oneKValueRst 该alpha的结果
	 */
	public void addData(RecoverRateRstData oneKValueRst){
		results.add(oneKValueRst);
	}
	/**
	 * 清空该次实验的结果
	 */
	public void clean(){
		results.clear();
	}
	/**
	 * 计算所有BN/SN的值，并初始化k与BN_SNs数组
	 */
	private void calResult(){
		int len = results.size();
		kValues = new double[len];
		BN_SNs = new double[len];
		
		for(int i = 0;i < len;i++){
			RecoverRateRstData temp = results.get(i);
			kValues[i] = temp.getK();
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
			ax[i] = this.kValues[i];//将k作为横坐标
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
