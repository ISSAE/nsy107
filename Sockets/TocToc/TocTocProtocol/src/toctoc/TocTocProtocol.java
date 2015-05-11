/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toctoc;

/**
 *
 * @author pascalfares
 */
public class TocTocProtocol {
    private static final int WAITING = 0;
    private static final int SENTTOCTOC = 1;
    private static final int SENTINDICE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private String[] indices = { "Pascal", "Little Old Lady", "Atch", "Who", "Who" };
    private String[] answers = { "Pascal the heat, it's cold in here!",
                                 "I didn't know you could yodel!",
                                 "Bless you!",
                                 "Is there an owl in here?",
                                 "Is there an echo in here?" };

    public String processInput(String theInput) {
        String theOutput = null;

        //Implémentation d'un automate par programme
        if (state == WAITING) {
            theOutput = "Toc! Toc!";
            state = SENTTOCTOC;
        } else if (state == SENTTOCTOC) {
            if (theInput.equalsIgnoreCase("Who's there?")) {
                theOutput = indices[currentJoke];
                state = SENTINDICE;
            } else {
                theOutput = "You're supposed to say \"Who's there?\"! " +
			    "Try again. Toc! Toc!";
            }
        } else if (state == SENTINDICE) {
            if (theInput.equalsIgnoreCase(indices[currentJoke] + " who?")) {
                theOutput = answers[currentJoke] + " Want another? (y/n)";
                state = ANOTHER;
            } else {
                theOutput = "You're supposed to say \"" + 
			    indices[currentJoke] + 
			    " who?\"" + 
			    "! Try again. Toc! Toc!";
                state = SENTTOCTOC;
            }
        } else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Toc! Toc!";
                if (currentJoke == (NUMJOKES - 1))
                    currentJoke = 0;
                else
                    currentJoke++;
                state = SENTTOCTOC;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
