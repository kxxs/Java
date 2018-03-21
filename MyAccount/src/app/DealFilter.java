package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import model.Deal;
import model.NormalDeal;
import model.StockDeal;
import model.TransferDeal;

public class DealFilter extends TestDeal {

	public static void Filter(Deal[] deal)
	{
		ArrayList<Deal> list=new ArrayList<Deal>();
		for (int i=0;i<deal.length;i++)
		list.add(deal[i]);
		Iterator<Deal> iter1 = list.iterator();  //用于打印原始数据
		System.out.println("原数组：");
		 while(iter1.hasNext()){
		  Deal temp = (Deal)iter1.next();
		  System.out.println(temp.ToPlainText());
		 }
		 System.out.println("\n");
		 
		 Iterator<Deal> iter2 = list.iterator(); //用于筛选
		 while(iter2.hasNext()){
			  if(Integer.parseInt(((Deal)iter2.next()).getAmount())<500)
			     iter2.remove();
			 }
		 
		 Iterator<Deal> iter3 = list.iterator(); //用于打印结果数据
		 System.out.println("结果数组：");
		 while(iter3.hasNext()){
		  Deal temp = (Deal)iter3.next();
		  System.out.println(temp.ToPlainText());
		 }
	}
	
	
	public static void main(String[] args) {
		Deal[] x=new Deal[10];
		int[] typeLabel=new int[10];
		String[] amount=new String[10];
		Date[] date=new Date[10];
		Random r1=new Random();
		Random r2=new Random();
		for(int i=0;i<10;i++)
			{
		 	  typeLabel[i]=r1.nextInt(3);
		 	  amount[i]=Integer.toString(r2.nextInt(1000));
		 	  date[i]=randomDate("2010-01-01","2017-01-01");
		 	  switch(typeLabel[i]) {
		 			  case 0: x[i]=new StockDeal(date[i],amount[i],""); break;
		 			  case 1: x[i]=new NormalDeal(date[i],amount[i],""); break;
		 			  case 2: x[i]=new TransferDeal(date[i],amount[i],""); break;
		 	  }
			}
			Filter(x);
	}
}
