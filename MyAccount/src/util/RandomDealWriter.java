package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import model.*;


public class RandomDealWriter {
	//随机日期生成器
	private static Date randomDate(String beginDate,String endDate ){    
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
	
		
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				DataOutputStream out = new DataOutputStream( new BufferedOutputStream(
                                       new FileOutputStream( "deal.dat"  )));
				for(int i=0;i<10;i++) {
				out.writeBytes( x[i].getDealType() ); //本例中用writeBytes写的信息并不会失真
				out.writeBytes( "\t" );
				out.writeBytes( sdf.format(x[i].getDealDate()) );
				out.writeBytes( "\t" );
				out.writeBytes( x[i].getAmount() );
				out.writeBytes( "\r\n" );
				}
				out.close();
			}
			catch ( IOException iox ){
					System.out.println("Problem writing deal.dat" );   }
	
		System.out.println("随机数组:");
		for(int i=0;i<10;i++)
			System.out.println(x[i].ToPlainText());
		System.out.println("\n");
}
}
