package interfaces.interfaces;

public class CorAnglais implements MusicalInstrument {
    private final String reedMaterial;

    public CorAnglais(String reedMaterial) {
        this.reedMaterial = reedMaterial;
    }

    @Override
    public void play() {
        System.out.printf("Our Cor Anglais is playing with a %s reed.", reedMaterial);
    }
}
