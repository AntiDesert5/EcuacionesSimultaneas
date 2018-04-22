package com.example.axelyray.ecuacionessimultaneas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.Integer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Datosx1,Datosx2,Datosx3,Datosx4;
    Spinner datos;
    EditText datox1,datox2,datox3,totalx1,total1;
    EditText datox1_1,datox2_1,datox3_1,totalx2;
    EditText datox1_2,datox2_2,datox3_2,totalx3;
    String container;
    Button resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.datos, android.R.layout.simple_spinner_item);
        datos.setAdapter(adapter);

        resultado = (Button) findViewById(R.id.resultadotext);
        resultado.setOnClickListener(this);
    }

        public void onClick(View control_pulsado) {
            datox1=(EditText)findViewById(R.id.valorx1);
            datox2=(EditText)findViewById(R.id.valorx2);
            datox3=(EditText)findViewById(R.id.valorx3);
            totalx1=(EditText)findViewById(R.id.tx1);

            datox1_1=(EditText)findViewById(R.id.valorx1_1);
            datox2_1=(EditText)findViewById(R.id.valorx2_1);
            datox3_1=(EditText)findViewById(R.id.valorx3_1);
            totalx2=(EditText)findViewById(R.id.tx2);

            datox1_2=(EditText)findViewById(R.id.valorx1_2);
            datox2_2=(EditText)findViewById(R.id.valorx2_2);
            datox3_2=(EditText)findViewById(R.id.valorx3_2);
            totalx3=(EditText)findViewById(R.id.tx3);

            Datosx1=(TextView)findViewById(R.id.total);
            Datosx2=(TextView)findViewById(R.id.totalt1);
            Datosx3=(TextView)findViewById(R.id.totalt2);
            Datosx4=(TextView)findViewById(R.id.totalt3);

            String auxdatosx1=datox1.getText().toString();
            String auxdatosx2=datox2.getText().toString();
            String auxdatosx3=datox3.getText().toString();
            String auxtotalx1=totalx1.getText().toString();


            String auxdatosx1_1=datox1_1.getText().toString();
            String auxdatosx2_1=datox2_1.getText().toString();
            String auxdatosx3_1=datox3_1.getText().toString();
            String auxtotalx2=totalx2.getText().toString();

            String auxdatosx1_2=datox1_2.getText().toString();
            String auxdatosx2_2=datox2_2.getText().toString();
            String auxdatosx3_2=datox3_2.getText().toString();
            String auxtotalx3=totalx3.getText().toString();

            int numEnterox1  =Integer.parseInt(auxdatosx1);
            int numEnterox2 = Integer.parseInt(auxdatosx2);
            int numEnterox3 = Integer.parseInt(auxdatosx3);
            int numTotalx1 = Integer.parseInt(auxtotalx1);

            int numEnterox1_1 = Integer.parseInt(auxdatosx1_1);
            int numEnterox2_1 = Integer.parseInt(auxdatosx2_1);
            int numEnterox3_1 = Integer.parseInt(auxdatosx3_1);
            int numTotalx2 = Integer.parseInt(auxtotalx2);


            int numEnterox1_2 = Integer.parseInt(auxdatosx1_2);
            int numEnterox2_2 = Integer.parseInt(auxdatosx2_2);
            int numEnterox3_2 = Integer.parseInt(auxdatosx3_2);
            int numTotalx3 = Integer.parseInt(auxtotalx3);

            //operaciones
            //comienzo de determinante general
            int DA = numEnterox1*((numEnterox2_1*numEnterox3_2)-(numEnterox2_2*numEnterox3_1));
            int DA2=numEnterox2*((numEnterox1_1*numEnterox3_2)-(numEnterox1_2*numEnterox3_1));
            int DA3=numEnterox3*((numEnterox1_1*numEnterox2_2)-(numEnterox1_2*numEnterox3_1));
            int totDet=DA-DA2+DA3;//determinante general
            String numCadena= Integer.toString(totDet);

            //datox2.setText(auxdatosx1);
            //comienzo determinante con t1
            int Detx1=numTotalx1*((numEnterox2_1*numEnterox3_2)-(numEnterox2_2*numEnterox3_1));
            int Detx2=numEnterox2*((numTotalx2*numEnterox3_2)-(numTotalx3*numEnterox3_1));
            int Detx3=numEnterox3*((numTotalx2*numEnterox2_2)-(numTotalx3*numEnterox2_1));
            int totDet1=Detx1-Detx2+Detx3;//determinante de t1
            String numCadenat1 = Integer.toString(totDet1);

            //comienzo determinante con t2
            int Detx1_1=numEnterox1*((numTotalx2*numEnterox3_2)-(numTotalx3*numEnterox3_1));
            int Detx2_1=numTotalx1*((numEnterox1_1*numEnterox3_2)-(numEnterox1_2*numEnterox3_1));
            int Detx3_1=numEnterox3*((numEnterox1_1*numTotalx3)-(numEnterox1_2*numTotalx2));
            int totaDet2=Detx1_1-Detx2_1+Detx3_1;//Determinante de t2
            String numCadenat2 = Integer.toString(totaDet2);

            //comienzo determinante con t3
            int x1_2=numEnterox1*((numEnterox2_1*numTotalx3)-(numEnterox2_2*numTotalx2));
            int x2_2=numEnterox2*((numEnterox1_1*numTotalx3)-(numEnterox1_2*numTotalx2));
            int x3_2=numTotalx1*((numEnterox1_1*numEnterox2_2)-(numEnterox1_2*numEnterox2_1));
            int totalDet3=x1_2-x2_2+x3_2;//Determinante en t3
            String numCadenat3=Integer.toString(totalDet3);

            //operacion de determinante general
            int Total = totDet1/totDet;
            int Total2 = totaDet2/totDet;
            int Total3= totalDet3/totDet;
            String T1 = Integer.toString(Total);
            String T2 = Integer.toString(Total2);
            String T3 = Integer.toString(Total3);

            Datosx1.setText(numCadena);
            Datosx2.setText(numCadenat1);
            Datosx3.setText(numCadenat2);
            Datosx4.setText(numCadenat3);
    }
}










