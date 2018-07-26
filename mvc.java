//java mvc design pattern

//model
public class Student {
	private String rollNo;
	private String name;
	public void setName(String name){
		this.name = name;
	}
	public void setRollNo(String rollNo){
		this.rollNo = rollNo;
	}
	public String getName(){
		return name;
	}
	public String getRollNo(){
		return rollNo;
	}
}

//view
public class StudentView {
	public void printStudentDetail(String name, String rollnum){
		System.out.println("Student");
		System.out.println("Name " + name);
		System.out.println("Num" + rollNum);
	}
}

public class Client {
    public static void main(String[] args) {
        // 从数据库获取学习记录
        Student model = retriveStudentFromDatabase();
        
        // 创建一个视图: 把学习详细信息输出到控制台
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(model, view);
        
        controller.updateView();
        
        // 更新模型数据
        controller.setStudentName("John");
        
        controller.updateView();
        
    }

    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}


//control has the control of view(update view) and models.
public class StudentController {
	private Student model;
	private StudentView view;

	public StudentController(Student model, StudentView view){
		this.model  = model;
		this.view = view;
	}
	public void setStudentName(String name){
		model.setName(name);
	}
	public void setStudentNum(String num){
		model.setRollNo(num);
	}
	public String getStudentName(){
        return model.getName();
    }
    public String getStudentRollNo(){
        return model.getRollNo();
    }
    public void updateView(){
        view.printStudentDetail(model.getName(), model.getRollNo());
    }
}

