import builder.StudentAccountBuilder;
import model.StudentAccount;
import model.UniversitySystem;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // BUILDER
        StudentAccount student = new StudentAccountBuilder(
            "39", "Souhaib", "Souhaib@gmail.com"
        )
        .phone("0666666666")
        .level("L3")
        .major("Informatique")
        .scholarship(true)
        .build();

        System.out.println("===== BUILDER =====");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Name: " + student.getFullName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Level: " + student.getLevel());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Scholarship: " + student.isScholarship());

        // SINGLETON
        System.out.println("\n===== SINGLETON =====");

        UniversitySystem system = UniversitySystem.getInstance();
        UniversitySystem system2 = UniversitySystem.getInstance();

        System.out.println("Same instance: " + (system == system2));

        // PROTOTYPE
        System.out.println("\n===== PROTOTYPE =====");

        StudentAccount studentClone = student.clone();

        System.out.println("Original: " + student.getFullName());
        System.out.println("Clone: " + studentClone.getFullName());
        System.out.println("Same object: " + (student == studentClone));

        // PROTOTYPE: CREATE FROM TEMPLATE
        System.out.println("\n===== PROTOTYPE TEMPLATE =====");

        StudentAccount template = new StudentAccountBuilder(
            "T39", "Template", "template@gmail.com"
        )
        .level("L1")
        .major("Informatique")
        .courses(List.of("GL", "PL", "SE2"))
        .build();

        StudentAccount student1 = template.CloneWithIdentify(
            "40", "Mouhamed", "Mouhamed@gmail.com"
        );

        System.out.println("Student ID: " + student1.getId());
        System.out.println("Name: " + student1.getFullName());
        System.out.println("Level: " + student1.getLevel());
        System.out.println("Major: " + student1.getMajor());
        System.out.println("Courses: " + student1.getCourses());

        // REPOSITORY AND AUDIT LOG
        System.out.println("\n===== REPOSITORY =====");

        system.addAccount(student1);

        StudentAccount duplicate = new StudentAccountBuilder(
            "40", "Another Student", "another@gmail.com"
        ).build();

        try {
            system.addAccount(duplicate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        StudentAccount found = system.getAccount("40");

        System.out.println("Found student: " + found.getFullName());

        System.out.println("\n===== AUDIT LOG =====");
        System.out.println(system.getAuditLog());
    }
}
