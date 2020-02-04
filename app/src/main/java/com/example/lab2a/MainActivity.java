package com.example.lab2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int userWins = 0, oppWins = 0;
    public Weapon userWeapon, compWeapon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateGreeting();
    }

    public void rockClick(View v){
        userWeapon = Weapon.ROCK;
        goToWar(userWeapon, Weapon.values()[new Random().nextInt(3)]);
    }

    public void paperClick(View v){
        userWeapon = Weapon.PAPER;
        goToWar(userWeapon, Weapon.values()[new Random().nextInt(3)]);
    }

    public void scissorsClick(View v){
        userWeapon = Weapon.SCISSORS;
        goToWar(userWeapon, Weapon.values()[new Random().nextInt(3)]);
    }
    public void goToWar(Weapon usrWpn, Weapon oppWeapon){
        boolean userWon = false;
        boolean isTie = false;
        if((usrWpn == Weapon.SCISSORS && oppWeapon == Weapon.PAPER) || (usrWpn == Weapon.ROCK && oppWeapon == Weapon.SCISSORS) || (usrWpn == Weapon.PAPER && oppWeapon == Weapon.ROCK)){
            userWins += 1;
            userWon = true;
        }
        else if((usrWpn == Weapon.SCISSORS && oppWeapon == Weapon.SCISSORS) || (usrWpn == Weapon.ROCK && oppWeapon == Weapon.ROCK) || (usrWpn == Weapon.PAPER && oppWeapon == Weapon.PAPER)){
            isTie = true;

        }
        else{
            oppWins +=1;
            userWon = false;
        }

        String resultString = "";

        if(userWon){
            resultString += "Player wins... ";
            if(usrWpn == Weapon.ROCK){
                resultString += "Rock blunts scissors";
            }
            else if(usrWpn == Weapon.PAPER){
                resultString += "Paper covers rock";
            }
            else{
                resultString += "Scissors cuts Paper";
            }
        }
        else if(isTie){
            resultString += "Draw!! Both player's chose the same weapon";
        }
        else{
            resultString += "Opponent wins... ";
            if(oppWeapon == Weapon.ROCK){
                resultString += "Rock blunts scissors";
            }
            else if(oppWeapon == Weapon.PAPER){
                resultString += "Paper covers rock";
            }
            else{
                resultString += "Scissors cuts Paper";
            }
        }

        TextView t = (TextView) findViewById(R.id.scoreView);
        TextView u = (TextView) findViewById(R.id.playerWpnView);
        TextView v = (TextView) findViewById(R.id.oppWpnView);
        TextView w = (TextView) findViewById(R.id.resultView);
        t.setText("Player: " + Integer.toString(userWins) + ", Opponent: " + Integer.toString(oppWins));
        u.setText("Player's Weapon: " + usrWpn.toString());
        v.setText("Opponent's Weapon: " + oppWeapon.toString());
        w.setText(resultString);
    }

    public void rockBtnClick(){
        int i =0;
    }

    public void generateGreeting(){
        TextView t = (TextView) findViewById(R.id.greeting);
        t.setText("Welcome to Rock,Paper,Scissors!\nPlease choose your weapon:");
    }
    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        Weapon genRandomWeapon(){
            Weapon[] weapons = Weapon.values();
            Random rand = new Random();
            int rand_int = rand.nextInt(2);
            return weapons[rand_int];
        }

        @Override
        public String toString() { return message; }

    };
}
