package ����;

public class Ch01_01 {

	//��Ա����
	private int carLength, engCC, maxSpeed;
	private String modelName;
	
	//���캯��
	public Ch01_01(String name) {
		carLength = 423;
		engCC = 3000;
		maxSpeed = 250;
		modelName = name;
	}
	
	//�෽��
	public void ShowData() {
		System.out.println(modelName);
	}
	
	public void setSpeed(int setSpeed) {
	System.out.println("ʹ�ö�����");
		maxSpeed = setSpeed;
		System.out.println(setSpeed);
		System.out.println(maxSpeed);
		
	}
	
	//������
	public static void main(String[] args) {
	
		//ʵ�ֶ���
		Ch01_01 BMW318 = new Ch01_01("BMW 318i");
		//���÷���
		BMW318.ShowData();
		BMW318.setSpeed(160);
	}

}
