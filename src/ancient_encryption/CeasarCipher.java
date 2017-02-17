/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

public class CeasarCipher extends AbstractCipher {

    private int rotFactor;

    public CeasarCipher(int rotFactor) {
	if (rotFactor > 0 && rotFactor <= ALPHABETH.length) {
	    this.rotFactor = rotFactor;
	} else {
	    throw new IllegalArgumentException("Make sure you are not entering a negative value or value larger than the ALPHABET");
	}
    }

    @Override
    public String encrypt(String original) {
	char[] rotALPHABETH = ALPHABETH.clone();
	for (int i = 0; i < ALPHABETH.length; i++) {
	    rotALPHABETH[(i + rotFactor) % ALPHABETH.length] = ALPHABETH[i];
	}

	char[] chars = original.toCharArray();
	for (int i = 0; i < ALPHABETH.length; i++) {
	    chars[i] = ALPHABETH[findCharIndex(chars[i])];
	}
	return new String(chars);
    }

    @Override
    public String decrypt(String encrypted) {
	char[] rotALPHABETH = ALPHABETH.clone();
	for (int i = 0; i < ALPHABETH.length; i++) {
	    rotALPHABETH[(i - rotFactor) % ALPHABETH.length] = ALPHABETH[i];
	}

	char[] chars = encrypted.toCharArray();
	for (int i = 0; i < ALPHABETH.length; i++) {
	    chars[i] = ALPHABETH[findCharIndex(chars[i])];
	}
	return new String(chars);
    }

}
