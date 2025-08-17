class Department {
    private String departmentName;
    private Professor []professors;
    private int professorCount;

    public Department(String name) {
        this.departmentName = name;
        this.professors = new Professor[5];
        this.professorCount = 0;
    }

    public void addProfessor(Professor professor) {
        this.professors[this.professorCount++] = professor;
    }

    public void display() {
        System.out.println("Department Name: " + this.departmentName);
        System.out.println("Faculties:- ");
        for (int i = 0; i < this.professorCount; i++) {
            this.professors[i].display();
        }
    }

}

class Professor {
    private String professorName;
    private Department department;
    
    public Professor(String name, Department department) {
        this.professorName = name;
        this.department = department;
        department.addProfessor(this);
    }

    public void display() {
        System.out.println("Professor Name: " + this.professorName);
    }
}

public class Main {
    public static void main(String[] args) {
        Department dept1 = new Department("Department of Botany");
        Department dept2 = new Department("Department of Computer Science");

        Professor prof1 = new Professor("Jatin Shah", dept1);
        Professor prof2 = new Professor("Kyora Sazanami", dept2);
        Professor prof3 = new Professor("Parth Patil", dept2);

        dept1.display();
        System.out.println("\n");
        dept2.display();
    }
}
