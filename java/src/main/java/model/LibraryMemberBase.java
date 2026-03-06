package model;

public abstract class LibraryMemberBase {
    protected String memberId;
    protected String name;

    public LibraryMemberBase(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public abstract String getMemberDetails();
}