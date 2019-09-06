
package 课设;
import java.util.Scanner;
public class Banker {
	static Scanner input =new Scanner(System.in);
	int a=0;//进程数量
	int b=0;//资源种类数
	int[][] Max;//最大矩阵
    int[][] Allocation;// 已分配矩阵
    int[][] Need;// 需求矩阵
    int[] Available;// 可用资源数
    int[] work;// Available的试分配向量
    boolean[] Finish;// 试分配结果标识向量
    int[] Request;//请求
    boolean flag;
    int p=0;//控制Finish的输出
	private void info(){//初始化
		System.out.println("请输入进程个数：");
		a=input.nextInt();
		System.out.println("请输入系统资源种类个数：");
		b=input.nextInt();
        Max = new int[a][b];
        Allocation = new int[a][b];
        Need = new int[a][b];
        Available = new int[b];
	    System.out.println("请输入最大需求矩阵Max：");
        for (int i = 0; i < a; i++) {
            System.out.println("请输入进程P" + i + "的最大资源需求量：");
            for (int j = 0; j < b; j++) {
                Max[i][j] = input.nextInt();
            }
        }
        System.out.println("请输入分配矩阵Alloction：");
        for (int i = 0; i < a; i++) {
            System.out.println("请输入进程P" + i + "的分配资源量：");
            for (int j = 0; j < b; j++) {
                Allocation[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                Need[i][j] = Max[i][j] - Allocation[i][j];
            }
        }
        System.out.println("请输入系统可利用资源Available：");
        for (int i = 0; i ==0; i++) {
            for (int j = 0; j < b; j++) {
            	Available[j] = input.nextInt();
            }
        }
	}
	public void Safe(){//安全算法
		if(a==0){
			System.out.println("未初始化！请初始化！");
		}else{
		int[] safe=new int[a];//安全序列
		int c;//控制比较过的资源种类的数目，只有当所有的资源种类都满足时才进入if
		int d=0;//安全序列safe的下标safe[d]
		p=1;
		Finish=new boolean[a];
		for(int i=0;i<a;i++){//先赋值状态为false
			Finish[i]=false;
		}
		work=new int[b];
		for(int i=0;i<b;i++){//把可利用的给work
			work[i]=Available[i];
		}
		for(int i=0;i<a;i++){//循环选择控制循环次数最多a次
			c=0;
			for(int j=0;j<b;j++){//进程判断
				if(Finish[i]==false&&Need[i][j]<=work[j]){
					c++;
					if(c==b){
						for(int k=0;k<b;k++){//新的work 银行家思想剩余加利息
							work[k]=work[k]+Allocation[i][k];
						}
						safe[d]=i;
						Finish[i]=true;
						i=-1;//每找到一个可分配的，再从头开始查找，即把i变为0
						d++;
					}
				}
			}
		}
			flag=true;
			for(int i=0;i<a;i++){
				if( Finish[i]==true){
					//e++;
					if(i==(a-1)){
						System.out.print("系统是安全的，安全序列为：");
						for( i=0;i<a;i++){
							System.out.print(safe[i]+"--");
						}   
						flag=true;
					}
				}
				else
				{
					System.out.println("系统不安全");
					flag=false;
					for( i=0;i<a;i++){
						System.out.print(safe[i]+"--");
					} 		
				}			
			}
			}				
	}
	public void show(){//输出
		if(a==0){
		}else{
		 System.out.println("此时资源分配量如下：");
	        System.out.println("进程  "+"   Max   "+"   Alloction "+"    Need  "+"     Available ");
	        for(int i=0;i<a;i++){
	            System.out.print("P"+i+"  ");
	            for(int j=0;j<b;j++){
	               System.out.print(Max[i][j]+"  "); 
	            }
	            System.out.print("|  ");
	            for(int j=0;j<b;j++){
	               System.out.print(Allocation[i][j]+"  "); 
	            }
	            System.out.print("|  ");
	            for(int j=0;j<b;j++){
	               System.out.print(Need[i][j]+"  "); 
	            }
	            System.out.print("|  ");
	            if(i==0){
	                for(int j=0;j<b;j++){
	                    System.out.print(Available[j]+"  ");
	                }
	            }else{
	            	for(int j=0;j<b;j++){
	                    System.out.print("   ");
	                }
	            }
	            if(p==1){
	            	System.out.print("|  ");
	                System.out.print(Finish[i]);
	            }
	            System.out.println();
	        }
		}
	    }
	public void bank(){//银行家算法
		if(a==0){
			System.out.println("未初始化！请初始化！");
		}else{
		Request=new int[b];
		int i=0;//输入的进程号
		int s=0;
		while(s==0){
			 System.out.println("请输入请求资源的进程编号：(0~"+(a-1)+")");
		        i= input.nextInt();
		        if(i>=0||i<a){
		        	s=1;
		        }else{
		        	System.out.println("输入错误，请重新输入！");
		        }
			}
		        System.out.println("请输入请求各资源的数量：");
		        for (int j = 0; j < 3; j++) {
		            Request[j] = input.nextInt();
		        }
		        for(int j=0;j<b;j++){
					if(Request[j]>Need[i][j]){    
						System.out.println("进程"+i+"申请的资源大于它所需要的资源");
						System.out.println("分配不合理，不予分配");
						p=2;
						break;
					}else if(Request[j]>Available[j]){
							System.out.println("进程"+i+"申请的资源大于现在系统可利用的资源");
							System.out.println("分配不合理，不予分配");
							p=2;
							break;
					}else if(j==(b-1)){
						changedata(i);
						Safe();	
						if(flag==false){
							show();
							reset(i);
							p=2;
						}
					}	
				}
	}
	}
	public void changedata(int i){//试分配数据转换
		for(int j=0;j<b;j++){
			Available[j]=Available[j]-Request[j];
			Allocation[i][j]=Allocation[i][j]+Request[j];
			Need[i][j]=Need[i][j]-Request[j];	
		}		
	}
	public void reset(int i){//试分配失败数据复原
		for(int j=0;j<b;j++){
			Available[j]=Available[j]+Request[j];
			Allocation[i][j]=Allocation[i][j]-Request[j];
			Need[i][j]=Need[i][j]+Request[j];	
		}
	}
	
     public static void main(String[] args) {
		Banker ban = new Banker();
		String choose="y";
		while(choose.equals("y")){
			System.out.println("***********************************");
			System.out.println("*********1.初始化********************");
			System.out.println("*********2.安全检查*******************");
			System.out.println("*********3.分配资源*******************");
			System.out.println("*********4.退出**********************");
			System.out.println("************************************");
			String num= input.next();
			switch(num){
			case "1":
				ban.info();
				ban.show();
				break;
			case "2":
				ban.Safe();
				ban.show();
				break;
			case "3":
				ban.bank();
				ban.show();
				break;
			case "4":
				choose="n";
				break;
			default:
				System.out.println("输入错误请重新输入！");
				break;
			}

		}
	    }
}

