package ����;
//����
class BWM_Serial{

	//���ݳ�Ա
	private int carLength, engCC, maxSpeed;
	public String modelName;
	//�෽��
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
//������

public class Ch01_02 extends BWM_Serial{

	public Ch01_02(String name) {
		modelName = name;
	}

	public static void main(String[] args) {

		Ch01_02 BMW318 = new Ch01_02("BMW 318i");
		BMW318.ShowDate();
	}

}
