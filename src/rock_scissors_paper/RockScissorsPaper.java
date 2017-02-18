/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_scissors_paper;

/**
 *
 * @author emil
 */
public class RockScissorsPaper {

    public final static String[] HANDS = new String[]{"Sten", "Saks", "papir"};

    private String aiSign;
    private String playerSign;

    public String getAiSing() {
        return aiSign;
    }

    public String getplayerSign() {
        return playerSign;
    }

    public void play(String playerHand) {
        playerSign = playerHand;
        aiSign = HANDS[(int) (Math.random() * 3)];
    }

    public String getWinner() {
        if (playerSign.equals(aiSign)) {
            return "Uafgjort!";
        } else if ((playerSign.equals("Sten") && aiSign.equals("Saks"))
                || (playerSign.equals("Papir") && aiSign.equals("Sten"))
                || (playerSign.equals("Saks") && aiSign.equals("Papir"))) {
            return "Du Vinder!";

        } else {
            return "Computeren Vinder";
        }
    }

}
