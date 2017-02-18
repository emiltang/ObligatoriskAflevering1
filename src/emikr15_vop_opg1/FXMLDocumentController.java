/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emikr15_vop_opg1;

import ancient_encryption.AtbashCipher;
import ancient_encryption.CeasarCipher;
import ancient_encryption.CipherInterface;
import java.net.URL;
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

/**
 *
 * @author emil
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
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

    private CipherInterface cipher;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rotSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
                CipherInterface.ALPHABETH.length - 1,
                CipherInterface.ALPHABETH.length / 2
        ));
    }

    @FXML
    private void encryptText(ActionEvent event) {
        encryptTF.setText(cipher.encrypt(inputTF.getText()));
    }

    @FXML
    private void decryptText(ActionEvent event) {
        decryptTF.setText(cipher.decrypt(encryptTF.getText()));
    }

    @FXML
    private void selectCipher(ActionEvent event) {
        if (cipherGroup.getSelectedToggle() == atbshRB) {
            cipher = new AtbashCipher();
        } else if (cipherGroup.getSelectedToggle() == ceasarRB) {
            cipher = new CeasarCipher(rotSpinner.getValue());
        }
    }
}
