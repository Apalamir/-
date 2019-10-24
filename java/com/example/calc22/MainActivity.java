package com.example.calc22;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.udojava.evalex.Expression;


import org.mariuszgromada.math.mxparser.*;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText InText;
    private TextView OutText;
    private Button num, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, res;
    private Button but1, but2, but3, but4, but5;
    private Button butSin, butCos, butTg, butCtg, butX, butKor, butC1, butC2;
    private Double result;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OutText = (TextView) findViewById(R.id.OutText);
        InText = (EditText) findViewById(R.id.InText);
        num = (Button) findViewById(R.id.num);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        num0 = (Button) findViewById(R.id.num0);
        res = (Button) findViewById(R.id.res);
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but3 = (Button) findViewById(R.id.but3);
        but4 = (Button) findViewById(R.id.but4);
        but5 = (Button) findViewById(R.id.but5);

         butSin = (Button) findViewById(R.id.butSin);
         butCos = (Button) findViewById(R.id.butCos);
        butCtg = (Button) findViewById(R.id.butCtg);
         butTg = (Button) findViewById(R.id.butTg);
         butX = (Button) findViewById(R.id.butX);
         butKor = (Button) findViewById(R.id.butKor);
         butC1 = (Button) findViewById(R.id.butC1);
         butC2 = (Button) findViewById(R.id.butC2);


          num.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        num0.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);

        butCos.setOnClickListener(this);
        butSin.setOnClickListener(this);
        butTg.setOnClickListener(this);
        butCtg.setOnClickListener(this);
        butC1.setOnClickListener(this);
        butC2.setOnClickListener(this);
        butKor.setOnClickListener(this);
        butX.setOnClickListener(this);
        res.setOnClickListener(this);

        but5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                InText.setText("");
                OutText.setText("");
                return true;
            }
        });

    }



    @Override
    public void onClick(View v) {
            switch (v.getId()) {
                    case R.id.num:
                        if (InText.getText().length() != 0 ) {
                            InText.setText(InText.getText()+"");
                        }
                        else
                            { InText.setText(InText.getText()+"0");
                            }
                        InText.setText(InText.getText()+".");
                        InText.setSelection(InText.getText().length());

                         break;
                        //InText.setText(InText.getText()+".");
                        //InText.setSelection(InText.getText().length());
                       // break;
                    case R.id.num1:
                        InText.setText(InText.getText()+"1");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num2:
                        InText.setText(InText.getText()+"2");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num3:
                        InText.setText(InText.getText()+"3");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num4:
                        InText.setText(InText.getText()+"4");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num5:
                        InText.setText(InText.getText()+"5");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num6:
                        InText.setText(InText.getText()+"6");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num7:
                        InText.setText(InText.getText()+"7");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num8:
                        InText.setText(InText.getText()+"8");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num9:
                        InText.setText(InText.getText()+"9");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.num0:
                        InText.setText(InText.getText()+"0");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.but4:
                        InText.setText(InText.getText()+"+");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.but3:
                        InText.setText(InText.getText()+"-");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.but2:
                        InText.setText(InText.getText()+"/");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.but1:
                        InText.setText(InText.getText()+"*");
                        InText.setSelection(InText.getText().length());
                        break;
                    case R.id.res:

                        try {
                            if (!InText.getText().toString().equals("")) {
                                Expression expression = new Expression(InText.getText().toString());
                                BigDecimal result = expression. eval(false); // 1.333333
                                OutText.setText(result.toString());
                            }
                        }
                        catch (ArithmeticException e ){
                            OutText.setText("на ноль не делиться");
                        }
                        catch (Expression.ExpressionException e ){
                            OutText.setText("Ошибка в знаках");
                        }
                        catch (NumberFormatException e ){
                            OutText.setText("Много точек");
                         }
                        break;

                    case R.id.but5:
                        if(InText.getText().length() !=0) {
                            s = InText.getText().toString().substring(0,InText.getText().length() - 1);
                        InText.setText(s);
                        }
                        InText.setSelection(InText.getText().length());
                        break;

                   case R.id.butCos:
                       InText.setText(InText.getText()+"cos(");
                       break;
                   case R.id.butSin:
                       InText.setText(InText.getText()+"sin(");
                       InText.setSelection(InText.getText().length());
                       break;
                   case R.id.butTg:
                      InText.setText(InText.getText()+"tan(");
                       break;
                   case R.id.butCtg:
                       InText.setText(InText.getText()+"ctg(");
                       InText.setSelection(InText.getText().length());
                       break;
                   case R.id.butC1:
                       InText.setText(InText.getText()+")");
                       break;
                   case R.id.butC2:
                       InText.setText(InText.getText()+"(");
                       InText.setSelection(InText.getText().length());
                       break;
                          case R.id.butKor:
                       InText.setText(InText.getText()+"sqrt(");
                       break;
                   case R.id.butX:
                      InText.setText(InText.getText()+"^");
                       InText.setSelection(InText.getText().length());
                       break;

                }
    }

                }













