package polymorphism.interfaces;

public class UnitedNationsGeneralAssembly implements CooperativelyDoable {

    public void createCommittee(String committeeName) {
        System.out.printf("Creating the %s...", committeeName);
    }

    @Override
    public void addParticipant(String participantName) {
        System.out.println("Ratifying %s's application to the UN...");
    }

    @Override
    public void begin() {
        System.out.println("DIPLOMACY!");
    }
}
