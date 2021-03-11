package com.example.se2_ebsp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public  class TcpClient {

    long minPrime;

    public TcpClient(long minPrime) {
        this.minPrime = minPrime;
    }

    public String run(InputStream matrikelnummer) {
        try {
            /* String sentence;
            String modifiedSentence;
            BufferedReader inFormUser = new BufferedReader(new InputStreamReader(matrikelnummer));
            Socket clientSocked = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocked.getOutputStream());
            BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocked.getInputStream()));
            sentence = inFormUser.readLine();
            outToServer.writeBytes(sentence + "\n");
            modifiedSentence = inFormServer.readLine();
            clientSocked.close();*/

            String sentence;
            BufferedReader inFormUser = new BufferedReader(new InputStreamReader(matrikelnummer));
            Socket clientSocked = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocked.getOutputStream());
            BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocked.getInputStream()));
            sentence = inFormUser.readLine();
            outToServer.writeBytes(sentence + "\n");

            return inFormServer.readLine();

        } catch (IOException e) {
            e.printStackTrace();
            return "FAIL";
        }
    }

}
