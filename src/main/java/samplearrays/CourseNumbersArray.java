package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses={1010, 1020, 2080, 2140, 2150, 2160};


        //update the courses array
        int[] updatedCourses=new int[registeredCourses.length+1];
        for  (int i=0;i<registeredCourses.length;i++) {
            updatedCourses[i]=registeredCourses[i];
        }

        // add a course to the array
        int newCourseNumber=2170;// the course to be added
        updatedCourses[updatedCourses.length-1] = newCourseNumber;
        System.out.println("Updated course: ");
        for (int course:updatedCourses) {
            System.out.println(course);
        }


        //check if updated courses contains a specific course number
        int courseToSearch=2180;
        int found=0;
        for (int course:updatedCourses) {
            if (courseToSearch==course) {
                System.out.println("The updated courses contain the course "+courseToSearch);
                found=1;
            }
        }
        if (found==0) {
            System.out.println("The course "+courseToSearch+" does not exist");
        }



    }
}
