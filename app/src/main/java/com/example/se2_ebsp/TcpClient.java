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
    String ServerAnswer;
    String matrikelnummer;

    public TcpClient(long minPrime, String serverAnswer, String matrikelnummer) {
        this.minPrime = minPrime;
        ServerAnswer = serverAnswer;
        this.matrikelnummer = matrikelnummer;
    }

    public String run(InputStream matrikelnummer) {
        try {

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

    public String getServerAnswer(){
        return ServerAnswer;
    }

}
