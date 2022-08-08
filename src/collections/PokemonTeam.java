package collections;

public class PokemonTeam {
    private Pokemon headPokemon;
    private int teamSize;

    public PokemonTeam(Pokemon headPokemon) {
        this.headPokemon = headPokemon;
        this.teamSize = 1;
    }

    public PokemonTeam() {
        this.headPokemon = null;
        this.teamSize = 0;
    }

    public static void main(String[] args) {
        PokemonTeam team = new PokemonTeam();
        team.addPokemon(new Pokemon("Glaceon", new String[]{ "Ice" }, 25));
        team.addPokemon(new Pokemon("Chandelure", new String[]{ "Ghost", "Fire" }, 25));
        team.addPokemon(new Pokemon("Froslass", new String[]{ "Ice", "Ghost" }, 25));
        team.addPokemon(new Pokemon("Alolan Raichu", new String[]{ "Electric", "Psychic" }, 25));
        team.addPokemon(new Pokemon("Pumpkaboo", new String[]{ "Ghost", "Grass" }, 25));

        team.insertPokemon(new Pokemon("Rowlett", new String[]{ "Grass" }, 5), 0);
        team.printTeam();

        team.storePokemon(10);
        team.printTeam();

        team.sendHeadPokemonOut();
        team.dequeue();
        team.printTeam();
    }

    public void enqueue(Pokemon newPokemon) {
        this.insertPokemon(newPokemon, 0);
    }

    public Pokemon dequeue() {
        // If the team is empty, then return null
        if (this.teamSize == 0) return null;

        return this.storePokemon(this.teamSize - 1);
    }

    public Pokemon sendHeadPokemonOut() {
        // If the team is empty, then return null
        if (this.teamSize == 0) return null;

        System.out.printf("%s, I choose you!\n", this.headPokemon.getName());

        // And we can simply just "store" the first Pokemon
        // This takes care of all the operations that we need
        return this.storePokemon(0);
    }

    public Pokemon storePokemon(int index) {
        // NOTE: equivalent to deleteNode() in a traditional linked-list
        if (index >= this.teamSize) {
            // If the index is larger than our actual team, then return null
            System.out.printf("ERROR: Your team only contains %d Pokémon.\n", this.teamSize);
            return null;
        } else if (index == 0) {
            // If we want to store the first Pokemon, isolate it
            Pokemon storedPokemon = this.headPokemon;

            // Then simply make the headPokemon pointer point to the next in line
            this.headPokemon = this.headPokemon.getNextInTeam();
            this.teamSize--;

            // Sever its ties to the team
            storedPokemon.setNextInTeam(null);

            // And return it
            return storedPokemon;
        }

        // In all other situations, we need to make sure that the Pokemon flanking the one that is leaving
        // connect to each other after the removal, so we need to keep pointers to both of them
        Pokemon current = this.headPokemon;
        Pokemon previous = current;

        // Traverse the list until we flank the Pokemon that is leaving
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.getNextInTeam();
        }

        // Isolate the Pokemon being stored
        Pokemon storedPokemon = current;

        // Have the Pokemon to its left connect to the Pokemon to its right;
        previous.setNextInTeam(current.getNextInTeam());
        this.teamSize--;

        // Sever the stored Pokemon's connection to the team (optional)
        storedPokemon.setNextInTeam(null);

        // And return it
        return storedPokemon;
    }

    public void insertPokemon(Pokemon pokemon, int index) {
        // Of course, we can't add a null Pokemon to our team
        if (pokemon == null) throw new NullPointerException();

        if (index > this.teamSize) {
            // If the index is larger than our actual team, just put the pokemon at the back
            this.addPokemon(pokemon);
            this.teamSize++;
            return;
        } else if (index == 0) {
            // If we want the new Pokemon to be the new head
            // We simply need to make the previous head its next-in-line
            // And make the headPokemon pointer point to the new Pokemon instead
            pokemon.setNextInTeam(this.headPokemon);
            this.headPokemon = pokemon;
            this.teamSize++;
            return;
        }

        // In all other cases
        Pokemon current = this.headPokemon;

        // We need to find the location where we want this new Pokemon to be
        for (int i = 0; i < index - 1; i++) current = current.getNextInTeam();

        // Make sure that the Pokemon in that location's next-in-line is now the new Pokemon's next-in-line
        pokemon.setNextInTeam(current.getNextInTeam());

        // And the previous Pokemon's new next-in-line is the new Pokemon
        current.setNextInTeam(pokemon);

        // Don't forget to increase the size!
        this.teamSize++;
    }

    public void addPokemon(Pokemon pokemon) {
        // Of course, we can't add a null Pokemon to our team
        if (pokemon == null) throw new NullPointerException();

        // We need to find the next available spot in our team
        Pokemon current = this.headPokemon;

        // If it's the head, then just make this new Pokémon the new head and increase the size
        if (current == null) {
            this.headPokemon = pokemon;
            this.teamSize++;
            return;
        }

        // Iterate through the team until you find the last Pokémon
        while (current.getNextInTeam() != null) current = current.getNextInTeam();

        // And make the new Pokémon its next-in-line
        current.setNextInTeam(pokemon);

        // Don't forget to increase the size!
        this.teamSize++;
    }

    public void printTeam() {
        // Create a separate reference to the current object
        Pokemon current = this.headPokemon;

        do {
            System.out.printf("%s", current.getName());  // Print its name
            current = current.getNextInTeam();       // And change the value of the reference to the next pokemon

            if (current != null) System.out.print(" || ");
        } while (current != null);  // Repeat this until there is no pokemon left

        System.out.println();
    }

    public int getTeamSize() {
        return this.teamSize;
    }

    public Pokemon getHeadPokemon() {
        return this.headPokemon;
    }
}
