/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

public class CeasarCipher extends AbstractCipher {

    private final char[] rotALPHABETH;

    public CeasarCipher(int rotFactor) {
        if (!(rotFactor > 0 && rotFactor <= ALPHABETH.length)) {
            throw new IllegalArgumentException("Make sure you are not entering a negative value or value larger than the ALPHABET");
        }

        // Rotate Alphabeth by rotfactor
        rotALPHABETH = ALPHABETH.clone();
        for (int i = 0; i < ALPHABETH.length; i++) {
            rotALPHABETH[(i + rotFactor) % ALPHABETH.length] = ALPHABETH[i];
        }
    }

    @Override
    public String encrypt(String original) {
        char[] chars = original.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = rotALPHABETH[findCharIndex(chars[i], ALPHABETH)];
            }
        }
        return new String(chars);
    }

    @Override
    public String decrypt(String encrypted) {
        char[] chars = encrypted.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = ALPHABETH[findCharIndex(chars[i], rotALPHABETH)];
            }
        }
        return new String(chars);
    }
}
