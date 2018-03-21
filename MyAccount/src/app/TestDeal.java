package app;
import java.text.SimpleDateFormat;
import java.util.*;
import model.Deal;
import model.NormalDeal;
import model.StockDeal;
import model.TransferDeal;
import util.DealAmountComparator;

public class TestDeal {
	public static Date randomDate(String beginDate,String endDate ){    
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse(beginDate);//构造开始日期  
            Date end = format.parse(endDate);//构造结束日期  
           if(start.getTime() >= end.getTime()){  
                return null;  
            } 
            long date = random(start.getTime(),end.getTime());  
            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
	
    private static long random(long begin,long end){  
        long rtn = begin + (long)(Math.random() * (end - begin));  
        //如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if(rtn == begin || rtn == end){  
            return random(begin,end);  
        }  
        return rtn;  
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
	 	  amount[i]=Integer.toString(r2.nextInt(10000));
	 	  date[i]=randomDate("2010-01-01","2017-01-01");
	 	  switch(typeLabel[i]) {
	 			  case 0: x[i]=new StockDeal(date[i],amount[i],""); break;
	 			  case 1: x[i]=new NormalDeal(date[i],amount[i],""); break;
	 			  case 2: x[i]=new TransferDeal(date[i],amount[i],""); break;
	 	  }
		}
	
		System.out.println("随机数组:");
		for(int i=0;i<10;i++)
			System.out.println(x[i].ToPlainText());
		System.out.println("\n");
		
		//日期排序
		System.out.println("日期排序:");
		Arrays.sort(x);
		for(int i=0;i<10;i++)
			System.out.println(x[i].ToPlainText());
		System.out.println("\n");
		
		//金额排序
		System.out.println("金额排序:");
		Arrays.sort(x,new DealAmountComparator());
		for(int i=0;i<10;i++)
			System.out.println(x[i].ToPlainText());
		System.out.println("\n");
		
	}
	
}
 