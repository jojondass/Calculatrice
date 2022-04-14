package fr.doranco.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
    buttonC, buttonVirgule, buttonDiv, buttonMultiplication, buttonAddition, buttonSoustraction, buttonEgal;
    EditText ecran;

    private double chiffre;
    private boolean clickOperateur = false;
    private boolean update = false;
    private String operateur = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonVirgule = (Button) findViewById(R.id.buttonVirgule);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonSoustraction = (Button) findViewById(R.id.buttonSoustraction);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        ecran = (EditText) findViewById(R.id.ecran);

        //ClickListener

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre("9");
            }
        });

        buttonVirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCiffre(".");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDiv();
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickMultiplication();
            }
        });

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAddition();
            }
        });

        buttonSoustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSoustraction();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEffacer();
            }
        });

        buttonEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEgal();
            }
        });

    }




        // methodes click
        public void clickCiffre(String str) {
            if(update) {
                update = false;
            }
            else if (!ecran.getText().equals("0")) {
                    str=ecran.getText()+str;
            }
            ecran.setText(str);
        }

    public void clickDiv() {
        if(clickOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre));
        }
        else {
            chiffre = Double.parseDouble(ecran.getText().toString());
            clickOperateur = true;
        }
        operateur = "/";
        update = true;
    }

    public void clickMultiplication() {
        if(clickOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre));
        }
        else {
            chiffre = Double.parseDouble(ecran.getText().toString());
            clickOperateur = true;
        }
        operateur = "*";
        update = true;
    }



    public void clickAddition() {
            if(clickOperateur) {
                calcul();
                ecran.setText(String.valueOf(chiffre));
            }
            else {
                chiffre = Double.parseDouble(ecran.getText().toString());
                clickOperateur = true;
            }
            operateur = "+";
            update = true;
        }

    public void clickSoustraction() {
        if(clickOperateur) {
            calcul();
            ecran.setText(String.valueOf(chiffre));
        }
        else {
            chiffre = Double.parseDouble(ecran.getText().toString());
            clickOperateur = true;
        }
        operateur = "-";
        update = true;
    }

    public void clickEffacer() {
        clickOperateur = false;
        update = true;
        chiffre = 0;
        operateur = "";
        ecran.setText("");
    }

    public void clickEgal() {
        calcul ();
        update = true;
        clickOperateur = false;
    }




    //methodes calcul

    private void calcul() {
        if (operateur.equals("*")) {
            chiffre = chiffre * Double.parseDouble(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre));
        }
        if (operateur.equals("+")) {
            chiffre = chiffre + Double.parseDouble(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre));
        }
        if (operateur.equals("-")) {
            chiffre = chiffre - Double.parseDouble(ecran.getText().toString());
            ecran.setText(String.valueOf(chiffre));
        }
        if (operateur.equals("/")) {
            try {
                chiffre = chiffre / Double.parseDouble(ecran.getText().toString());
                ecran.setText(String.valueOf(chiffre));
            } catch (Exception e) {
                ecran.setText(0);
            }
        }


    }




}