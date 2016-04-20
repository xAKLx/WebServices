package com.example.xaklx.myapplication;

public class Caller  extends Thread
{
    public CallSoap cs;
    public String celsius;
    public boolean isActive;

    public void run(){
        MainActivity.rslt = "START";
        try{
            cs=new CallSoap();
            String resp=cs.Call(celsius);
            MainActivity.rslt=resp;
        }catch(Exception ex)
        {MainActivity.rslt=ex.toString();}
    }


}