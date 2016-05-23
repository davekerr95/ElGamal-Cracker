import java.math.BigInteger;
import java.util.Scanner;

public class ElGamal_BruteForce_Cracker {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {


		System.out.println("Please enter a Public Key in the form P G GXModP");
		String[] inputPublicKey = (in.nextLine()).split(" ");

		BigInteger publicKey [] = {

				(new BigInteger(inputPublicKey[0])),
				(new BigInteger(inputPublicKey[1])),
				(new BigInteger(inputPublicKey[2]))

			};


		System.out.println("Please enter a Cipher in the form C1 C2");
		String inputCipherKey [] = (in.nextLine()).split(" ");

		BigInteger cipherKey [] = {

				(new BigInteger(inputCipherKey[0])),
				(new BigInteger(inputCipherKey[1]))
		};


		System.out.println('\n' + "The message is: " + findMessage(publicKey[0], findPrivateKey(publicKey[0], publicKey[1], publicKey[2]), cipherKey[0], cipherKey[1]));



	}


	private static BigInteger findPrivateKey(BigInteger p, BigInteger g, BigInteger GXModP){

			for(BigInteger i = BigInteger.ONE;; i = i.add(BigInteger.ONE))
			{
				BigInteger guess = g.modPow(i, p);
				if(guess.compareTo(GXModP) == 0)
					return i;
			}

		}

	private static BigInteger findMessage(BigInteger p, BigInteger x, BigInteger C1, BigInteger C2){

		// Calculating the C1 / C2 Formula
		BigInteger p1x = BigInteger.ZERO;
		p1x = p.subtract(x);
		p1x = p1x.subtract(BigInteger.ONE);

		C1 = C1.modPow(p1x, p);
		C2 = C2.mod(p);

		BigInteger message = BigInteger.ZERO;
		message = C1.multiply(C2);
		message = message.mod(p);

		return message;

	}

}
