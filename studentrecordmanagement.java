import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class studentrecordmanagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        while (true) {
            System.out.println("1:Add  2:Display  3:Search by ID  4:Exit");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Marks: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    double marks = sc.nextDouble();
                    students.add(new Student(id, name, marks));
                    break;
                case 2:
                    for (Student s : students) s.display();
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.id == searchId) {
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found.");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}