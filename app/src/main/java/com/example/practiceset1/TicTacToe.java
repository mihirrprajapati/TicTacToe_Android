package com.example.practiceset1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToe extends AppCompatActivity {

    int n = 3;
    int chance = 0;
//    Button[][] button;
    Button[][] button = new Button[n][n];
    Button onReset;
    TextView playerTurn, playerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);


        button[0][0] = findViewById(R.id.btn00);
        button[0][1] = findViewById(R.id.btn01);
        button[0][2] = findViewById(R.id.btn02);
        button[1][0] = findViewById(R.id.btn10);
        button[1][1] = findViewById(R.id.btn11);
        button[1][2] = findViewById(R.id.btn12);
        button[2][0] = findViewById(R.id.btn20);
        button[2][1] = findViewById(R.id.btn21);
        button[2][2] = findViewById(R.id.btn22);
        playerTurn = findViewById(R.id.txtview3);
        playerText = findViewById(R.id.txtview2);
        onReset = findViewById(R.id.btnReset);

        onReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        button[i][j].setText("");
                    }
                }
                playerText.setText("Player Turn");
                playerTurn.setText("O");
                chance = 0;
            }
        });

    }

    public void btnClicked(View view) {
        Button clickedButton = (Button)view;
        if(chance < 9) {
            if (chance % 2 == 0) {
                clickedButton.setText("O");
                playerTurn.setText("X");
                checkWinStatus("O");
            } else {
                clickedButton.setText("X");
                playerTurn.setText("O");
                checkWinStatus("X");
            }
            chance++;
        }
    }

    public void checkWinStatus(String player){
        // horizontal
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (button[i][0].getText() == player && button[i][1].getText() == player && button[i][2].getText() == player ||
                    button[0][i].getText() == player && button[1][i].getText() == player && button[2][i].getText() == player) {
                playerText.setText("Player " + player + " won");
                playerTurn.setText("");
                chance = 10;
                break;
            }
        }

        // Check diagonals
        if (button[0][0].getText() == player && button[1][1].getText() == player && button[2][2].getText() == player ||
                button[0][2].getText() == player && button[1][1].getText() == player && button[2][0].getText() == player) {
            playerText.setText("Player " + player + " won");
            playerTurn.setText("");
            chance = 10;
        }

    }

}