package problem4;

import java.util.Scanner;

public class ChangeCalculator {
	double price;
	public static void Change(double price) throws WrongFormatException,InputOutOfRangeException {
		if(price==0){
			System.out.println("程序退出");
			System.exit(0);
			}
		else if(Double.toString(price).length()-Double.toString(price).indexOf(".")>3) 
			throw new WrongFormatException("WrongFormatException");
		else if((price>5)||(price<0))
			throw new InputOutOfRangeException("InputOutOfRangeException");
		else {
			double change=5-price;
			int yy=0,ly = 0,yj=0,lj=0,wj=0,yf=0,lf=0,wf=0; //一元，两元，一角，两角。。。
			int yuan=(int)change;
			int jiao=(int)(change*10)%10;
			int fen =(int)(change*100)%10;
			StringBuffer output=new StringBuffer("");
			
			if(price==5)
			{output.append("无需找零的方案");
			System.out.println(output);}
			
			else
			{
				//计算各货币数量
			while(yuan>1)
			{
				ly++;
				yuan=yuan-2;
			}
			if(yuan>0)
				yy=1;
			
			if(jiao>=5){
				wj=1;
				jiao=jiao-5;
				}
			while(jiao>1)
			{
				lj++;
				jiao=jiao-2;
			}
			if(jiao>0)
				yj=1;
			
			if(fen>=5){
				wf=1;
				fen=fen-5;
				}
			while(fen>1)
			{
				lf++;
				fen=fen-2;
			}
			if(fen>0)
				yf=1;
			
			//整理输出字符串
			if(ly!=0)
				output.append("2元"+ly+"张,");
			if(yy!=0)
				output.append("1元"+yy+"张,");
			if(wj!=0)
				output.append("5角"+wj+"个,");
			if(lj!=0)
				output.append("2角"+lj+"个,");
			if(yj!=0)
				output.append("1角"+yj+"个,");
			if(wf!=0)
				output.append("5分"+wf+"个,");
			if(lf!=0)
				output.append("2分"+lf+"个,");
			if(yf!=0)
				output.append("1分"+yf+"个,");
			
			output.deleteCharAt(output.length() - 1);
			output.append("的方案");
			System.out.println(output);
			
		 }	
		}
		
	}
	
	public static void main(String[] args) {
		boolean valid=false;
		Scanner in=new Scanner(System.in); //注：当输入结果合适时还可以接着输入，以便助教检查~~
		while(!valid)
		{try{
			double price=in.nextDouble();
			Change(price);
		  }
		catch(WrongFormatException e) {
			System.out.println("输入位数不对，请重新输入：");
		  }
		catch(InputOutOfRangeException e) {
			System.out.println("输入越界，程序退出");
			valid=false;
			System.exit(-1);
		  }	
		}
		in.close();
	}
}
