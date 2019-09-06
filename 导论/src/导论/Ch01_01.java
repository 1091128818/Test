package 导论;

public class Ch01_01 {

	//成员数据
	private int carLength, engCC, maxSpeed;
	private String modelName;
	
	//构造函数
	public Ch01_01(String name) {
		carLength = 423;
		engCC = 3000;
		maxSpeed = 250;
		modelName = name;
	}
	
	//类方法
	public void ShowData() {
		System.out.println(modelName);
	}
	
	public void setSpeed(int setSpeed) {
	System.out.println("使用定速器");
		maxSpeed = setSpeed;
		System.out.println(setSpeed);
		System.out.println(maxSpeed);
		
	}
	
	//主程序
	public static void main(String[] args) {
	
		//实现对象
		Ch01_01 BMW318 = new Ch01_01("BMW 318i");
		//调用方法
		BMW318.ShowData();
		BMW318.setSpeed(160);
	}

}
