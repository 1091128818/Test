package 实验四;
/*
 * 定义一个类无参喊参构造器，一门默认课程，一门可选课程，课程名事件类中包括招生限额课程
 * 对象调用监听器中的方法来处理事件
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
			System.out.println("无法加入学生");
			System.out.println("当前加入学生人数：" + student_num);
			System.out.println("当前学生人数上限：" + student_max);
			return false;
		}
	}
	
}

class course {
	private String course_name;//课程名
	private int student_max = 2;//招生限额
	private int student_num = 0;//现招入学生数
	private List<String> students = new ArrayList();//选课的学生
	
	private Collection listeners;//监听事件池

	
	//无参构造方法
	course() {
		course_name = "java组件实验";
	}
	
	//有参的构造方法
	course(String course) {
		this.course_name = course;
	}
	
	//设置招生限额
	public void Setstudent_name(int student_max) {
		this.student_max = student_max;
	}
	
	//返回课程名
	public String Getcourse_name() {
		return course_name;
	}
	
	//返回选课的人数
	public int Getstudent_num() {
		return student_num;
	}
	
	//返回招生限额
	public int Getstudent_max() {
		return student_max;
	}
	
	//返回学生信息
	public void Getstudents() {
		for(String stu:students){
            System.out.println(stu);
        }
	}
	
	//添加新学生
	public void Addstudent(String student_name) {
		Excess_Event event = new Excess_Event(this,student_max);
		conc_Listener m = new conc_Listener(this);
		if(m.MaxListener(event)) {
		students.add(student_name);
		student_num++;
		System.out.println("已加入的学生" + student_name);
		}else {
			//这里什么都不干，交给监听类
		}

	}
	
	//设置新的限额
	public void Setstudent_max(int student_max) {
		this.student_max = student_max;
	}
	
	//添加监听器
	synchronized public void AddListener(Max_studentListener listener) {
		if(listeners == null) {
			listeners = new HashSet();
		}
		listeners.add(listener);
	}
	
	//删除监听器
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
			M.Addstudent("学生:" + (i+1));
		}
		System.out.println("");
		System.out.println("");
		//course中的方法
		System.out.println("返回课程名：" + M.Getcourse_name());
		System.out.println("返回选课的人数：" + M.Getstudent_num());
		System.out.println("返回招生限额：" + M.Getstudent_max());
		System.out.println("返回学生信息：");
		M.Getstudents();
	}

}
