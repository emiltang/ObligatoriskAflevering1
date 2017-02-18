/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

public abstract class AbstractCipher implements CipherInterface {

    @Override
    public abstract String encrypt(String original);

    @Override
    public abstract String decrypt(String encrypted);

    protected int findCharIndex(char ch, char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (ch == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
