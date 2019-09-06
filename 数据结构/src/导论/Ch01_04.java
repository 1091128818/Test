package µ¼ÂÛ;

abstract class autoMobile {
	
	abstract public void setData();
	abstract public void showData();
	
}

class BENZ_Serial extends autoMobile{
	public BENZ_Serial(String modelName) {
		System.out.println("BENZ:"+modelName);
	}

	private int carLength, engCC, maxSpeed;

	@Override
	public void setData() {
		carLength = 400;
		engCC = 3200;
		maxSpeed = 280;
		
	}

	@Override
	public void showData() {
		System.out.println(carLength);
		System.out.println(engCC);
		System.out.println(maxSpeed);
		
	} 
}

public class Ch01_04 {

	public static void main(String[] args) {
		
		autoMobile myCar = null;
		BENZ_Serial SLK2000 = new BENZ_Serial("SLK2000");
		myCar = SLK2000;
		myCar.setData();
		myCar.showData();

	}

}
