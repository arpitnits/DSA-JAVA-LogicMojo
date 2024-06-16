package HeapsAndPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompPractice {

    static class Student {
        int rollNo;
        String name;
        int age;
        int marks;//<100

        Student(int r, String n, int a, int m) {
            this.rollNo = r;
            this.name = n;
            this.age = a;
            this.marks = m;
        }
    }

    static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age-o2.age;
        }
    }

    static class MarksComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.marks-o2.marks;
        }
    }

    public static void practice(List<Student> students) {
       students.sort(new AgeComparator().thenComparing(new MarksComparator()));
    }


    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1, "A", 19, 98);
        Student s2 = new Student(2, "B", 19, 89);
        Student s3 = new Student(3, "C", 27, 58);

        students.add(s1);
        students.add(s2);
        students.add(s3);

        practice(students);
        for(Student s: students)
            System.out.println(s.rollNo);
    }
}
