/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_scissors_paper;

import java.util.Scanner;

/**
 *
 * @author emil
 */
public class RockScissorsPaper {

    public enum Hand {
        ROCK, PAPER, SCISSORS;

        private Hand loseToHand;

        static {
            ROCK.loseToHand = PAPER;
            PAPER.loseToHand = SCISSORS;
            SCISSORS.loseToHand = ROCK;
        }

        public static Hand getRandom() {
            return values()[(int) (Math.random() * values().length)];
        }

        public boolean loseTo(Hand other) {
            return this.loseToHand == other;
        }
    }

    private Hand computerHand;
    private Hand playerHand;

    public Hand getComputerHand() {
        return computerHand;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void play(Hand playerHand) {
        this.playerHand = playerHand;
        computerHand = Hand.getRandom();
    }

    public String getWinner() {
        if (playerHand == computerHand) {
            return "Uafgjort!";
        } else if (computerHand.loseTo(playerHand)) {
            return "Du Vinder!";
        } else if (playerHand.loseTo(computerHand)) {
            return "Computeren Vinder";
        } else {
            return "Somthing went wrong";
        }
    }

    public static void main(String[] args) {
        RockScissorsPaper game = new RockScissorsPaper();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("[0]Sten, [1]Saks or [2]Papir [3]Stop Playing");
            Hand hand;
            switch (scan.nextInt()) {
                case 0:
                    hand = Hand.ROCK;
                    break;
                case 1:
                    hand = Hand.SCISSORS;
                    break;
                case 2:
                    hand = Hand.PAPER;
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Enter a value between 0 and 3");
                    continue;
            }
            game.play(hand);
            System.out.println("Dig: " + game.getPlayerHand() + " Computer: " + game.getComputerHand());
            System.out.println(game.getWinner());
        }

    }
}
