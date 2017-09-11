package generic;

class Student{
    public String  getName(){
        System.out.println("张三");
		return null;
    }
}
class TestStudent <T extends Student>{
    private T t;
    public TestStudent(T t){
        this.t = t;
    }
    public void getStudent(){
        t.getName();//这里不能编译
    }
}
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        TestStudent <Student> testStudent = new TestStudent<Student>(student);
        testStudent.getStudent();
    }
}
