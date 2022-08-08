package collections;

public class Pokemon {
    private final String name;
    private final String[] types;
    private final int level;

    private Pokemon evolution;
    private Pokemon nextInTeam;

    public static void printEvolutionaryChainRecursively(Pokemon first) {
        if (first == null) return;  // If the current pokemon is null, then we're done

        System.out.printf("%s", first.getName()); // If not, print its name
        if (first.getEvolution() != null) System.out.print(" -> "); // And an arrow if it has another evolution

        printEvolutionaryChainRecursively(first.getEvolution());  // Recursive step
    }

    public static void main(String[] args) {
        Pokemon raichu = new Pokemon("Raichu", new String[] { "Electric" }, 50);
        Pokemon pikachu = new Pokemon("Pikachu", new String[] { "Electric" }, 25);
        Pokemon pichu = new Pokemon("Pichu", new String[] { "Electric" }, 5);

        pichu.changeEvolution(pikachu);                 // Change Pichu's evolution
        pichu.getEvolution().changeEvolution(raichu);   // Change Pichu's evolution's evolution

        Pokemon alolanRaichu = new Pokemon("Alolan Raichu", new String[] { "Electric", "Psychic"}, 50);
        pichu.getEvolution().changeEvolution(alolanRaichu);  // Change Pichu's evolution's evolution again

        pichu.printEvolutionaryChain();
        Pokemon.printEvolutionaryChainRecursively(pichu);
    }

    public Pokemon(String name, String[] types, int level) {
        this.name = name;
        this.types = types;
        this.level = level;
        this.evolution = null;
    }

    public void changeEvolution(Pokemon newEvolution) {
        if (newEvolution == null) throw new NullPointerException();

        this.evolution = newEvolution;
    }

    public void setNextInTeam(Pokemon nextInTeam) { this.nextInTeam = nextInTeam; }

    public void printEvolutionaryChain() {
        Pokemon current = this; // Create a separate reference to the current object

        do {
            System.out.printf("%s", current.name);  // Print its name
            current = current.getEvolution();       // And change the value of the reference to the next evolution

            if (current != null) System.out.print(" -> ");
        } while (current != null);  // Repeat this until there is no evolution left
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Pokemon getEvolution() {
        return evolution;
    }

    public String[] getTypes() {
        return types;
    }

    public Pokemon getNextInTeam() {
        return nextInTeam;
    }
}
