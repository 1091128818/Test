package ����;

//����
class myComputer{
	//�෽��
	public void Run() {};
}

//������
class myScanner extends myComputer {

	//��Ա����
	private String paperScan;
	//���캯��

	public myScanner(String inData) {
		this.paperScan = new String(inData);
	}
	
	//���¶��巽��
	public void Run () {
		System.out.println("ʹ��ɨ����"+paperScan+"���");
	}
}

//������2
class myPrinter extends myComputer{
	
	private String paperPrint;
	public myPrinter(String inData) {
		this.paperPrint = new String(inData);
	}
	
	//���¶��巽��
	public void Run () {
		System.out.println("ʹ�ô�ӡ��"+paperPrint+"���");
	}
}
//��Ҫ��
public class Ch01_03 {
 
	

	//��Ա����
	private String inputData;
	
	//���캯��
	public Ch01_03() {
		System.out.println("��Ҫ��ɨ��A���ٽ��ļ�A��ӡ����");
		System.out.println("���̣�");
		inputData = "�ļ�A";
	}
	
	public static void main(String[] args) {
		//ʵ�ֶ���
		Ch01_03 computerUser = new Ch01_03();
		myComputer MyComputer;
		myScanner MyScanner = new myScanner("����A");
		myPrinter MyPinter = new myPrinter("����A");
		System.out.println("����������ת��Ϊ����ɨ����ִ��run����");
		
		//ʵ�ֶ�̬
		MyComputer = MyScanner;
		MyComputer.Run();
		System.out.println("����������ת��Ϊ�����ӡ��ִ��run����");
		//ʵ�ֶ�̬
		MyComputer = MyPinter;
		MyComputer.Run();
	}

}
