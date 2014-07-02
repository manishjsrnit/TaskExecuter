package com.smanish.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.smanish.consumer.Consumer;
import com.smanish.consumer.ConsumerImpl;
import com.smanish.consumer.Item;

public class Test  
{  
	public static void main(String[] args) throws Exception  
	{  
		Consumer consumer = new ConsumerImpl(5);  
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("F:\\Job.csv"))));  
			String line = "";  
			while((line = br.readLine()) != null)  
			{  
				System.out.println(  
						"TaskProducer producing: " + line);  
				consumer.consume(new TaskItem(line));  
			}  

			consumer.finishConsumption(); 
		} finally {
			if(br != null)
				br.close();
		}
	}  
}  

class TaskItem implements Item  
{  
	private String line;  

	public TaskItem(String s)  
	{  
		line = s;  
	}  

	public void process()  
	{  
		String[] tokens = this.line.split(",");
		double result = 0.0;
		String operation = tokens[0];
		String op1 = tokens[1];
		String op2 = tokens[2];
		switch(operation){
		case("+"): result = Double.parseDouble(op1) + Double.parseDouble(op2);break;
		case("-"): result = Double.parseDouble(op1) - Double.parseDouble(op2);break;
		case("/"): result = Double.parseDouble(op1) / Double.parseDouble(op2);break;
		case("*"): result = Double.parseDouble(op1) * Double.parseDouble(op2);break;
		case("%"): result = Double.parseDouble(op1) % Double.parseDouble(op2);break;
		}
		synchronized(this){
			System.out.println("-------------------------------------------------" + "\n"+
					Thread.currentThread().getName() +   
					" consuming : " + line + " And result of operation is : " + result);  
		}
	}  
}  
