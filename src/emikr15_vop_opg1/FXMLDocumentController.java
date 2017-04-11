/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emikr15_vop_opg1;

import ancient_encryption.AtbashCipher;
import ancient_encryption.CeasarCipher;
import ancient_encryption.CipherInterface;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import rock_scissors_paper.RockScissorsPaper;
import rock_scissors_paper.RockScissorsPaper.Hand;

/**
 *
 * @author emil
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField inputTF;
    @FXML
    private RadioButton atbshRB;
    @FXML
    private ToggleGroup cipherGroup;
    @FXML
    private RadioButton ceasarRB;
    @FXML
    private Spinner<Integer> rotSpinner;
    @FXML
    private Button encryptBtn;
    @FXML
    private TextField encryptTF;
    @FXML
    private Button decryptBtn;
    @FXML
    private TextField decryptTF;
    @FXML
    private ImageView playerIW;
    @FXML
    private ImageView computerIW;
    @FXML
    private Button rockBtn;
    @FXML
    private Button scissorsBtn;
    @FXML
    private Button paperBtn;
    @FXML
    private Label computerLabel;
    @FXML
    private Label winLabel;

    // private CipherInterface cipher;
    private Map<Hand, Image> picMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        picMap.put(Hand.ROCK, new Image(new File("Rock.png").toURI().toString()));
        picMap.put(Hand.SCISSORS, new Image(new File("Scissors.png").toURI().toString()));
        picMap.put(Hand.PAPER, new Image(new File("Paper.png").toURI().toString()));

        rotSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                0,
                CipherInterface.ALPHABETH.length - 1,
                CipherInterface.ALPHABETH.length / 2
        ));
    }

    @FXML
    private void encryptDecrypt(ActionEvent event) {
        CipherInterface cipher = null;

        System.out.println(cipherGroup.getSelectedToggle());

        if (cipherGroup.getSelectedToggle() == atbshRB) {
            cipher = new AtbashCipher();
        } else if (cipherGroup.getSelectedToggle() == ceasarRB) {
            cipher = new CeasarCipher(rotSpinner.getValue());
        }
        System.out.println(event.getSource());
        if (event.getSource() == encryptBtn) {
            encryptTF.setText(cipher.encrypt(inputTF.getText()));
        } else if (event.getSource() == decryptBtn) {
            decryptTF.setText(cipher.decrypt(encryptTF.getText()));
        }
    }

//    // old not used
//    @FXML
//    private void encryptText(ActionEvent event) {
//        encryptTF.setText(cipher.encrypt(inputTF.getText()));
//    }
//
//    // old not used
//    @FXML
//    private void decryptText(ActionEvent event) {
//        decryptTF.setText(cipher.decrypt(encryptTF.getText()));
//    }
//
//    // old not used
//    @FXML
//    private void selectCipher(ActionEvent event) {
//        if (cipherGroup.getSelectedToggle() == atbshRB) {
//            cipher = new AtbashCipher();
//        } else if (cipherGroup.getSelectedToggle() == ceasarRB) {
//            cipher = new CeasarCipher(rotSpinner.getValue());
//        }
//    }
    @FXML
    private void rockPaperScissor(ActionEvent event) {
        Hand hand;
        RockScissorsPaper game = new RockScissorsPaper();
        if (event.getSource() == rockBtn) {
            hand = Hand.ROCK;
        } else if (event.getSource() == paperBtn) {
            hand = Hand.PAPER;
        } else if (event.getSource() == scissorsBtn) {
            hand = Hand.SCISSORS;
        } else {
            hand = null;
        }
        game.play(hand);
        computerLabel.setText("Computer: " + game.getComputerHand());
        computerIW.setImage(picMap.get(game.getComputerHand()));
        playerIW.setImage(picMap.get(hand));
        winLabel.setText(game.getWinner());
    }

}
