package polymorphism.interfaces;

public class SuperSmashBros implements CooperativelyDoable {

    public static void main(String[] args) {
        CooperativelyDoable meeting = new UnitedNationsGeneralAssembly();
        CooperativelyDoable game = new SuperSmashBros();

//        ((SuperSmashBros) game).chooseStage("Final Destination");

        CooperativelyDoable[] thing = new CooperativelyDoable[] { new SuperSmashBros(), new UnitedNationsGeneralAssembly() };
    }

    public void chooseStage(String stageName) {
        System.out.printf("Stage %s chosen!", stageName);
    }

    @Override
    public void addParticipant(String participantName) {
        System.out.printf("Adding character %s to the roster.", participantName);
    }

    @Override
    public void begin() {
        System.out.println("FIGHT!");
    }
}