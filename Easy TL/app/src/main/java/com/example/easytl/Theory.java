package com.example.easytl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Theory extends AppCompatActivity {

    int topicNumber;

    String [] topicName = new String[] {
            "Начало движения и изменение его направления",
            "Обгон",
            "Остановка и стоянка",
            "Проезд перекрестков",
            "Проезд пешеходных переходов и остановок транспортных средств",
            "Движение через железнодорожные переезды"
    };

    String [] content = new String[] {
            "Всегда делай это:\n" +
                    "\n\u25cf убедись, что твои действия будут безопасны и не создадут препятствий или опасности другим участникам движения (вообще всегда, не только в вождении)!\n" +
                    "\n\u25cf не будь глупцом, уступи дорогу пешеходам и транспортным средствам при выезде из жилой зоны, дворов, мест стоянки!\n" +
                    "\n\u25cf съезжая же с дороги уступи дорогу велосипедистам и пешеходам, направление движения которых ты пересекаешь!\n" +
                    "\n\u25cf если из пункта 2 и 3 не понятно, то знай - придется уступать дорогу, и при перестроении тем машинам, что движутся в попутном направлении по той полосе, на которую ты намерен перестроиться - тоже:)\n" +
                    "\n\u25cf поворачиваешь? даже если это “поворот не туда” - заблаговременно займи соответствующее крайнее положение на проезжей части, предназначенной для движения в этом направлении!\n" +
                    "\n\u25cf дорогой друг, поворачивай так, чтобы при выезде с пересечения проезжих частей твоя машина не оказалась на встречке :) выезд с перекрестка, где организованно круговое движение можешь осуществлять с любой полосы, если направление движения не определено дорожными знаками или разметкой\n" +
                    "\n" +
                    "\n" +
                    "Никогда не делай этого:\n" +
                    "\n\u25cf не разворачивайся на:\n" +
                    "\n  \u25ce на железнодорожных переездах;\n" +
                    "\n  \u25ce на мостах, путепроводах, эстакадах и под ними;\n" +
                    "\n  \u25ce в тоннелях, там же места нет;\n" +
                    "\n\u25cf не видишь дороги - не разворачивайся;\n" +
                    "\n\u25cf пощади пешеходов, не разворачивайся на пешеходных переходах и ближе 10м от них с обеих сторон, кроме случая разрешенного разворота на перекрестке;\n" +
                    "\n\u25cf на автомагистралях.\n" +
                    "\n\u25cf не едь задним ходом на: автомагистралях, дорогах для автомобилей, железнодорожных переездах, пешеходных переходах, перекрестках, мостах, путепроводах, эстакадах, в тоннелях, на въездах и выездах из них (ты всё ещё это читаешь?), а также на участках дорог с ограниченной обзорностью или недостаточной видимостью. Просто говоря, ВЕЗДЕ, где ты можешь создать аварийную ситуацию.\n",
            "",
            "",
            "",
            "",
            ""
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        topicNumber = getIntent().getIntExtra("topicNum", 0);

        TextView topicNameTV =  (TextView) findViewById(R.id.topicNameTextView);
        TextView contentTV =  (TextView) findViewById(R.id.contentTextView);

        topicNameTV.setText(topicName[topicNumber]);
        contentTV.setText(content[topicNumber]);
    }

    public void backBut(View view){
        Intent intent = new Intent(view.getContext(), PickTheory.class);
        startActivity(intent);
    }

    public void nextBut (View view) {
        int questionNumber = 0;
        Intent intent = new Intent(view.getContext(), TheoryQuestion.class);
        intent.putExtra("topicNum", topicNumber);
        intent.putExtra("questionNum", questionNumber);
        startActivity(intent);
    }
}
