package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static BigInteger hashOf(String entity) {
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		// we use MD5 with 128 bits digest
		BigInteger hashint = null;
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		// we use MD5 with 128 bits digest
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			// compute the hash of the input 'entity'
			// convert the hash into hex format
			byte[] hash = md.digest(entity.getBytes());
			String hex = toHex(hash);
			// Convert message digest into hex value
			// convert the hex into BigInteger
			hashint = new BigInteger(hex,16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return the BigInteger
		return hashint;
	}

	public static BigInteger addressSize()  {
		int length = 0;
		// Task: compute the address size of MD5
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			// get the digest length (Note: make this method independent of the class
			// variables)
			length = md.getDigestLength();
			// compute the number of bits = digest length * 8
			// compute the address size = 2 ^ number of bits
			// return the address size
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BigInteger("2").pow(length*8);

		
	}	
	
	public static int bitSize() {

		int digestlen = 0;
		// find the digest length
		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return digestlen * 8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}