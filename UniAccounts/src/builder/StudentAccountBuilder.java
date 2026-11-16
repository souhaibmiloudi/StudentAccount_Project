package builder;

import model.StudentAccount;
import java.util.ArrayList;
import java.util.List;

public class StudentAccountBuilder {

    // Mandatory information
    private String id;
    private String fullName;
    private String email;

    // Optional information
    private String phone = null;
    private String level = "L1";
    private String major = null;
    private boolean scholarship = false;
    private List<String> courses = new ArrayList<>();

    public StudentAccountBuilder(String id, String fullName, String email) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID is required");
        }

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }

        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public StudentAccountBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentAccountBuilder level(String level) {
        if (!List.of("L1", "L2", "L3", "M1", "M2").contains(level)) {
            throw new IllegalArgumentException("Invalid level");
        }
        this.level = level;
        return this;
    }

    public StudentAccountBuilder major(String major) {
        this.major = major;
        return this;
    }

    public StudentAccountBuilder scholarship(boolean scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public StudentAccountBuilder courses(List<String> courses) {
        this.courses = new ArrayList<>(courses);
        return this;
    }

    public StudentAccount build() {
        return new StudentAccount(
            id, fullName, email, phone,
            level, major, scholarship, courses
        );
    }
}
