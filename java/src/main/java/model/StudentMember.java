package model;

public class StudentMember extends LibraryMemberBase {
    private String course;

    public StudentMember(String id, String name, String course) {
        super(id, name);
        this.course = course;
    }

    @Override
    public String getMemberDetails() {
        return "[Student Member]\n" +
                "Name: " + name +
                "\nCourse: " + course +
                "\nID: " + memberId;
    }
}// Auto-generated file: StudentMember.java