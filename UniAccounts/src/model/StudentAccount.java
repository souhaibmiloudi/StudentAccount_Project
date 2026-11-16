package model;

import java.util.ArrayList;
import java.util.List;

public class StudentAccount implements Cloneable {

    // Student information
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String level;
    private String major;

    private boolean scholarship;
    private List<String> courses;
public StudentAccount(
        String id,
        String fullName,
        String email,
        String phone,
        String level,
        String major,
        boolean scholarship,
        List<String> courses) {

    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.phone = phone;
    this.level = level;
    this.major = major;
    this.scholarship = scholarship;
    this.courses = new ArrayList<>(courses);
}
public String getId() {
    return id;
}

public String getFullName() {
    return fullName;
}

public String getEmail() {
    return email;
}

public String getPhone() {
    return phone;
}

public String getLevel() {
    return level;
}

public String getMajor() {
    return major;
}

public boolean isScholarship() {
    return scholarship;
}

public List<String> getCourses() {
    return new ArrayList<>(courses);
}
public StudentAccount clone() {
    try {
        StudentAccount copy = (StudentAccount) super.clone();
        copy.courses = new ArrayList<>(this.courses);
        return copy;
    } catch (CloneNotSupportedException e) {
        throw new AssertionError(e);
    }
}
public StudentAccount CloneWithIdentify(
        String id,
        String fullName,
        String email) {

    StudentAccount copy = this.clone();

    copy.id = id;
    copy.fullName = fullName;
    copy.email = email;

    return copy;
}
}
