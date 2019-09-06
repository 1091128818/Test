package ʵ����;
/*
 * ����һ�����޲κ��ι�������һ��Ĭ�Ͽγ̣�һ�ſ�ѡ�γ̣��γ����¼����а��������޶�γ�
 * ������ü������еķ����������¼�
 * */
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;


class Excess_Event extends EventObject{
	private int student_max = 0;
	public Excess_Event(Object source,int student_max) {
		super(source);
		this.student_max = student_max;
	}
	
	public void Setstudent_max(int student_max) {
		this.student_max = student_max;
	}
	
	public int Getstudent_max() {
		return student_max;
	}
}

interface Max_studentListener extends EventListener {
	public boolean MaxListener(Excess_Event event);
}

class conc_Listener implements Max_studentListener {
	private int student_num =  0;
	private int student_max =  0;
	
	public conc_Listener(course Obj) {
		this.student_num = Obj.Getstudent_num();
	}
	public boolean MaxListener(Excess_Event event) {
		this.student_max = event.Getstudent_max();
		if(student_num < student_max) {
			return true;
		}else {
			System.out.println("�޷�����ѧ��");
			System.out.println("��ǰ����ѧ��������" + student_num);
			System.out.println("��ǰѧ���������ޣ�" + student_max);
			return false;
		}
	}
	
}

class course {
	private String course_name;//�γ���
	private int student_max = 2;//�����޶�
	private int student_num = 0;//������ѧ����
	private List<String> students = new ArrayList();//ѡ�ε�ѧ��
	
	private Collection listeners;//�����¼���

	
	//�޲ι��췽��
	course() {
		course_name = "java���ʵ��";
	}
	
	//�вεĹ��췽��
	course(String course) {
		this.course_name = course;
	}
	
	//���������޶�
	public void Setstudent_name(int student_max) {
		this.student_max = student_max;
	}
	
	//���ؿγ���
	public String Getcourse_name() {
		return course_name;
	}
	
	//����ѡ�ε�����
	public int Getstudent_num() {
		return student_num;
	}
	
	//���������޶�
	public int Getstudent_max() {
		return student_max;
	}
	
	//����ѧ����Ϣ
	public void Getstudents() {
		for(String stu:students){
            System.out.println(stu);
        }
	}
	
	//�����ѧ��
	public void Addstudent(String student_name) {
		Excess_Event event = new Excess_Event(this,student_max);
		conc_Listener m = new conc_Listener(this);
		if(m.MaxListener(event)) {
		students.add(student_name);
		student_num++;
		System.out.println("�Ѽ����ѧ��" + student_name);
		}else {
			//����ʲô�����ɣ�����������
		}

	}
	
	//�����µ��޶�
	public void Setstudent_max(int student_max) {
		this.student_max = student_max;
	}
	
	//��Ӽ�����
	synchronized public void AddListener(Max_studentListener listener) {
		if(listeners == null) {
			listeners = new HashSet();
		}
		listeners.add(listener);
	}
	
	//ɾ��������
	synchronized public void DelListener(Max_studentListener listener) {
		if(listener == null) {
			return;
		}
		listeners.remove(listener);
	}
	
}


public class Main{

	public static void main(String[] args) {
		course M = new course();
		M.Setstudent_max(2);
		M.AddListener(new conc_Listener(M));
		for(int i=0 ; i < 3 ; i++) {
			M.Addstudent("ѧ��:" + (i+1));
		}
		System.out.println("");
		System.out.println("");
		//course�еķ���
		System.out.println("���ؿγ�����" + M.Getcourse_name());
		System.out.println("����ѡ�ε�������" + M.Getstudent_num());
		System.out.println("���������޶" + M.Getstudent_max());
		System.out.println("����ѧ����Ϣ��");
		M.Getstudents();
	}

}
