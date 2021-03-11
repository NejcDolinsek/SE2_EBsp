package com.example.se2_ebsp;

import android.widget.EditText;

public class PrimeNumbers extends MainActivity {
    public static String matPrimeNumbers(EditText Matrikelnummer ){

        //Converts the Edit text to String
        String matrikelnummerString = Matrikelnummer.getText().toString();

        //Converts the String to Array
        int [] matrikelnummerArray = StringToArray(matrikelnummerString);

        StringBuilder a = new StringBuilder();

        for (int j : matrikelnummerArray) {
            if (isPrime(j)) {
                a.append(j);
            }
        }
        return a.toString();
    }

    public static boolean isPrime(Integer integer) {
        boolean isPrime = false;
        int i = (int) Math.ceil(Math.sqrt(integer));
        if (i > 1) {
            do {
                if ((integer != i) && (integer % i == 0)) {
                    isPrime = false;
                    break;
                } else if (!isPrime)
                    isPrime = true;
                --i;
            } while (i > 1);
        }
        return isPrime;
    }

    public static int[] StringToArray(String x){
        String[] arr = x.split("");

        int [] arrayint = new int[arr.length];

        for (int i = 0; i < arrayint.length; i++) {
            arrayint[i] = Integer.parseInt(arr[i]);
        }
        return arrayint;
    }


}
