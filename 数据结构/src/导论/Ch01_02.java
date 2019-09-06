package 导论;
//基类
class BWM_Serial{

	//数据成员
	private int carLength, engCC, maxSpeed;
	public String modelName;
	//类方法
	public void ShowDate() {
		carLength = 423;
		engCC = 3000;
		maxSpeed = 250;
		System.out.println(modelName);
		System.out.println(carLength);
		System.out.println(engCC);
		System.out.println(maxSpeed);
	}
	
}
//派生类

public class Ch01_02 extends BWM_Serial{

	public Ch01_02(String name) {
		modelName = name;
	}

	public static void main(String[] args) {

		Ch01_02 BMW318 = new Ch01_02("BMW 318i");
		BMW318.ShowDate();
	}

}
