package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest=students[0];
        for(int i=0;i<students.length;i++){
                if (oldest.getAge()<students[i].getAge()){
                    oldest=students[i];
                }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count=0;
        for(int i=0;i<students.length;i++){
            if (students[i].isAdult()){
                count++;
            }
        }
        return count;

    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double sum=0;
        int count=students.length;
        for(int i=0;i<students.length;i++){
            sum+=students[i].getGrade();
        }
        return sum/count;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student : students) {
            if (student.getName()==name) {
                return student;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
         Arrays.sort(students,(s1,s2)-> s2.getGrade()-s1.getGrade());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for  (Student student : students) {
            if (student.getGrade()>=15) {
                System.out.println(student.getName()+" : "+student.getGrade());
            }
        }

    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for  (Student student : students) {
            if (student.getId()==id) {
                student.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
            for (int i=0;i<students.length;i++) {
                for (int j=i+1;j<students.length;j++) {
                    if (students[i].getName()==students[j].getName()) {
                        return true;
                    }
                }
            }
            return false;

    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents=new Student[students.length+1];
        for (int i=0;i<students.length;i++){
            newStudents[i]=students[i];
        }
        newStudents[students.length]=newStudent;
        return newStudents;
    }

    //11) the top student in each class
    public static Student topClassStudent(Student[] students) {
            Student top=students[0];
            for (Student student : students ) {
                if (student.getGrade()>top.getGrade()) {
                    top=student;
                }
            }
            return top;

    }
    public static void printClass(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }


    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0]=new Student(1, "Ali", 20, 17);
        arr[1]=new Student(2, "Sara", 19, 14);
        arr[2]=new Student(3, "Rachid", 17, 18);
        arr[3]=new Student(4, "Omar", 21, 12);
        arr[4]=new Student(5, "Sara", 18, 16);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("\nOldest student: "+oldest);

        // 3) Count adults
        int adults=countAdults(arr);
        System.out.println("Number of adult students: "+adults);

        // 4) Average grade
        double avg=averageGrade(arr);
        System.out.println("Average grade: "+avg);


        // 5) Find by name
        Student stdToFind = findStudentByName(arr, "Sara");
        System.out.println("Found by name : " + stdToFind);

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated=updateGrade(arr,4,15);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Omar"));

        // 9) Duplicate names
        boolean duplicates=hasDuplicateNames(arr);
        System.out.println("\nDuplicate names? " + duplicates);


        // 10) Append new student
        System.out.println("\nAfter appending new student:");

        Student newStudent = new Student(6, "Khalid", 19, 14);
        arr=appendStudent(arr,newStudent);
        for (Student s:arr) System.out.println(s);


        //11) Top student in each class of a school
        System.out.println("\nWelcome to the school .");

        Student[][] School =new Student[2][3];
        School[0][0]=new Student(1, "Amine", 20, 17);
        School[0][1]=new Student(2, "Mehdi", 19, 14);
        School[0][2]=new Student(3, "Simo", 17, 18);
        School[1][0]=new Student(4, "Abdo", 21, 12);
        School[1][1]=new Student(5, "Youssef", 18, 16);
        School[1][2]=new Student(6, "Anouar", 22, 13);

        for (int i=0;i<School.length;i++){
            System.out.println("\nThe students of class "+(i+1)+": ");
            printClass(School[i]);
        }
        System.out.println("\nThe top student in each class :");

        for (int i=0;i<School.length;i++){
            Student topClass=topClassStudent(School[i]);
            System.out.println("Top student of class "+(i+1)+": "+topClass.getName());
        }






}}

