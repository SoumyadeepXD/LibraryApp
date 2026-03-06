package model;

public class PremiumMember extends LibraryMemberBase {
    private int priorityLevel;

    public PremiumMember(String id, String name, int level) {
        super(id, name);
        this.priorityLevel = level;
    }

    @Override
    public String getMemberDetails() {
        return "[Premium Member]\n" +
                "Name: " + name +
                "\nPriority Level: " + priorityLevel +
                "\nID: " + memberId;
    }
}