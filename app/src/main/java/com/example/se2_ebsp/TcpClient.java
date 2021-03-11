package com.example.se2_ebsp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public  class TcpClient {

    String ServerAnswer;
    String matrikelnummer;

    public TcpClient( String matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    public String run() {
        try {

            Socket clientSocked = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocked.getOutputStream());
            BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocked.getInputStream()));

            outToServer.writeBytes(matrikelnummer +"\n");

            ServerAnswer = inFormServer.readLine();

            return ServerAnswer;

        } catch (IOException e) {
            e.printStackTrace();
            return "FAIL";
        }
    }

    public String getServerAnswer(){
        return ServerAnswer;
    }

}
