package Battleships2;

import java.util.ArrayList;

import Battleships.GameHelper;

public class StartupBust {

    // 1. Declare and initialize vthe ariables we'll need
    private GameHelper helper = new GameHelper;
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // 2. Make three Startup objects, give them names, and stick them in the ArrayList
        Startup one = new Startup();
        one.setName("poniez");
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");

        // add objects to the ArrayList
        startups.add(one);
        startups.add(two);
        startups.add(three);

        // 3. Print bried instructions for user
        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi and cabista");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        // 4. Repeat with each Startup in the list
        for (Startup starttup : startups) {
            // 5. Ask the helper or a Startup location
            ArrayList<String> newLocation = helper.placeStartup(3);
            // 6. Call the setter method on this Startup to give it the location you just got from the helper
            startup.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        // 7. As long as the Startup list is NOT empty
        while (!startups.isEmpty) {
            // 8. Get user input
            String userGuess = helper.getUserInput("Enter your guess: ");
            // 9. Call our own checkUserGuess method
            checkUserGuess(userGuess);
        }

        // 10. Call our own finishGame() method
        finishGame();
    }

    private void checkUserGuess() {
        // 11. Increment the number of guesses the user has made
        numOfGuesses ++;
        // 12. Assume it's a "miss" unless told otherwise
        String result = "miss";

        // 13. Repeat with all Startups in the list
        for (Startup startupToTest : startups) {
            // 14. Ask the Startup to check the user guess looking for a hit (or kill)
            result = startupToTest.checkYourself(userGuess);

            if (result.equals("hit")) {
                // 15. Get out of the loop early, no point in testing the other
                break;
            }

            if (result.equals("kill")) {
                // 16. This one's dead so take it out of the Startups list then get out of the loop
                startups.remove(startupToTest);
                break;
            }
        }

        // 17. Print the result for the user
        System.out.println(result);
    }

    // 18. Print a message telling the user how they did in the game
    private void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
        } else {
            System.out.println("Took long enough. " + numOfGuesses + "guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        // 19. Create the game object
        StartupBust game = new StartupBust();
        // 20. Tell the game object to set up the game
        game.setUpGame();
        // 21. Tell the game object to start the main game play loop (keep asking for user input and checking the guess)
        game.startPlaying();
    }
}
