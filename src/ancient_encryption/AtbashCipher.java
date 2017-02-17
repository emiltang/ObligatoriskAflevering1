/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ancient_encryption;

public class AtbashCipher extends AbstractCipher {

    @Override
    public String encrypt(String original) {
	char[] chars = original.toCharArray();
	System.out.println(chars.length -1);
	for (int i = 0; i < chars.length; i++) {
	    if (Character.isLetter(chars[i])) {
		chars[i] = ALPHABETH[(ALPHABETH.length - 1) - findCharIndex(chars[i])];
	    }
	}
	return new String(chars);
    }

    @Override
    public String decrypt(String encrypted) {
	return encrypt(encrypted);
    }

}
