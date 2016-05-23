#ElGamal-Cracker

###Introduction
An ElGamal Cracker used to retrieve the encrypted message.

This code takes in the Public Key and Ciphers in Space seperated command line input and uses BigInteger's to do all of the calculations.

The findPrivateKey() Method takes in 3 BigInteger's which are the Public Key

It calculates the Private key using the following:

```java
private static BigInteger findPrivateKey(BigInteger p, BigInteger g, BigInteger GXModP){

			for(BigInteger i = BigInteger.ONE;; i = i.add(BigInteger.ONE)){

				BigInteger guess = g.modPow(i, p);
				if(guess.compareTo(GXModP) == 0)
					return i;
	}
}
```

After calculating the Private Key the Message is obtained using the findMessage() function

```java
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
```

###Future Plans

I plan to enhance the algorithm to accept Bigger Private Keys and Ciphers by implementing a Baby Steps Giant Steps approach and allowing the Private Keys and Ciphers to be read in from a .txt file and outputted to a text file.