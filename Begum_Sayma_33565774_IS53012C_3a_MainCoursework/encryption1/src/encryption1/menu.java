package encryption1;
import java.math.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.*;
import java.io.*;
// Modify the display content to suit your purposes...
class menu {
	double c;
	BigInteger message_back = null;
	int p, q, n, r, d=0, e,i;
	String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
	String msg_m = ""; // this will hold the msg to be encrypted
	int message;
	int message1 = 0; 
private static final String TITLE =
"\n2910326 Computer Security coursework\n"+
" by firstname-FAMILYNAME_SRN\n\n"+
"\t********************\n"+
"\t1. Declaration: Sorry but part of the program was copied from the Internet.\n" +
"\t2. Generate Keys\n"+
"\t3. Encryption \n"+
"\t4. Decryption \n"+
"\t0. Exit \n"+
"\t********************\n"+
"Please input a single digit (0-4):\n";
menu() {
int selected=-1;
while (selected!=0) {
System.out.println(TITLE);
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
// selected = Integer.parseInt(in.readLine());
try {
selected = Integer.parseInt(in.readLine());
switch(selected) {
case 1: q1();
break;
case 2: q2();
break;
case 3: q3();
break;
case 4: q4();
break;} }
catch(Exception ex) {} } // end while
System.out.println("Bye!");
}
// Modify the types of the methods to suit your purposes...
private void q1() {

}
public void q2() {
System.out.println("in q2");

Scanner sc= new Scanner(System.in);

//declaring the required variables
//int p, q, n, r, d=0, e,i;


System.out.println("Enter what you'd like encrypted.");
msg_m += sc.nextLine().toLowerCase();

//Got some code from this website (Only to convert String into a double.):
//Voisard, M. V. (2020, February 1). Java: converting each letter into the number for example a = 1, b = 2, c = 3. 
//Stack Overflow. https://stackoverflow.com/questions/60013228/java-converting-each-letter-into-the-number-for-example-a-1-b-2-c-3


for(int i1 = 0; i1 < msg_m.length(); i1++) {
	
	//Makes a = 0 , b = 1, c = 2. Turns alphabet into numbers in order Starting from 0.
	//msg_m holds the text, what you typed in the console. 
	// message makes the String into a double, so that it could be used for maths.
    System.out.print(alphabet.indexOf(msg_m.charAt(i1)) + "\n");
    
    
    //the message is turned into a string because we want every single index. Without this it will 
    //only label the last index.
    
    String s1= String.valueOf(alphabet.indexOf(msg_m.charAt(i1)));
    
    //The message is then turned into an int again so we can do maths with the number.
    message = Integer.parseInt(message + s1);
}



System.out.println( "\n" +"message = " + message);
// now assigning prime number p and q 


//Reference for implementing the RSA algorithm. 
//GeeksforGeeks & mayanktyagi1709. (2021, January 19). 
//Java Program to Implement the RSA Algorithm. GeeksforGeeks. 
//https://www.geeksforgeeks.org/java-program-to-implement-the-rsa-algorithm/



//Key generation
//now assigning prime number p and q 
System.out.println( "\n" +"Enter 1st prime number p");
p=sc.nextInt();
System.out.println("Enter 2nd prime number q");
q=sc.nextInt();

// checking if what the user types is a prime number or not. 
//if not the message will prompt the user to start the program again.
boolean flag = false;

for (int i2 = 2; i2 <= p / 2; ++i2) {
  // condition for a number that is not prime.
  if (p % i2 == 0) {
    flag = true;
    break;
  }
}

for (int i2 = 2; i2 <= q / 2; ++i2) {
      // condition for a number that is not prime.
      if (q % i2 == 0) {
        flag = true;
        break;
      }
    }

if (!flag) {
	
	
  System.out.println(p  + " is a prime number.");
}
else {
  System.out.println(p + " is not a prime number. Start again.");
}


if (!flag) {
      System.out.println(q  + " is a prime number.");
      
    }
    else {
      System.out.println(q + " is not a prime number. Start again.");
    }

//calculating n and r . 
n= p*q;
r=(p-1)*(q-1);

System.out.println("The value of r is :"+ r);


//working out e 
for(e=2; e < r; e++) {
	
	if (gcd(e,r) ==1) {
		break;
		
	}
}


System.out.println("value of e :" + e);


//working out mod inverse / modular exponentiation to find d.
for(i=0; i<=r ;i++) {
	int x= 1+(i*r);
	if(x%e==0) {
		d=x/e;
		break;
	}
	
}

System.out.println("Public Key (d) :" + d);
System.out.println("Private Key (e,n):" + "(" + e + "," + n + ")");

}
private char[] indexOf(char charAt) {
	// TODO Auto-generated method stub
	return null;
}
public void q3() {
System.out.println("in q3");
//Encryption

		c=(Math.pow(message, e))%n;
		System.out.println("encrypted message is: "+ c);
		

}
public void q4() {
System.out.println("in q4");
//Decryption
		// converting the int value of n into BigInteger
		
		BigInteger N= BigInteger.valueOf(n);
		// converting float value of c into BigInteger
		 BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		 message_back = (C.pow(d)).mod(N);
		 System.out.println("Derypted message is : "+ message_back);
}
public static void main(String[] args) {
new menu();

}

//greatest common divisor 
static int gcd(int e, int r) {
	if(e==0) 
		return r;
	else
		return gcd(r%e, e);	
}

 

}

