package 导论;

//基类
class myComputer{
	//类方法
	public void Run() {};
}

//派生类
class myScanner extends myComputer {

	//成员变量
	private String paperScan;
	//构造函数

	public myScanner(String inData) {
		this.paperScan = new String(inData);
	}
	
	//重新定义方法
	public void Run () {
		System.out.println("使用扫描仪"+paperScan+"完成");
	}
}

//派生类2
class myPrinter extends myComputer{
	
	private String paperPrint;
	public myPrinter(String inData) {
		this.paperPrint = new String(inData);
	}
	
	//重新定义方法
	public void Run () {
		System.out.println("使用打印机"+paperPrint+"完成");
	}
}
//主要类
public class Ch01_03 {
 
	

	//成员数据
	private String inputData;
	
	//构造函数
	public Ch01_03() {
		System.out.println("想要先扫描A！再将文件A打印！！");
		System.out.println("流程：");
		inputData = "文件A";
	}
	
	public static void main(String[] args) {
		//实现对象
		Ch01_03 computerUser = new Ch01_03();
		myComputer MyComputer;
		myScanner MyScanner = new myScanner("对象A");
		myPrinter MyPinter = new myPrinter("对象A");
		System.out.println("将对象计算机转变为对象扫描仪执行run方法");
		
		//实现多态
		MyComputer = MyScanner;
		MyComputer.Run();
		System.out.println("将对象计算机转变为对象打印机执行run方法");
		//实现多态
		MyComputer = MyPinter;
		MyComputer.Run();
	}

}
