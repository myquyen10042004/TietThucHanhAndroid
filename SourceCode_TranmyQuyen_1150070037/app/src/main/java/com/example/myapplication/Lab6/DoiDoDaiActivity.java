package com.example.myapplication.Lab6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class DoiDoDaiActivity extends AppCompatActivity {

    private EditText txtNumber;
    private Spinner spnUnit;
    private TextView[] lblResults;

    // Danh sách đơn vị
    private final String[] units = {
            "Hải lý", "Dặm", "Km", "Lý", "Met",
            "Yard", "Foot", "Inch"
    };

    // Ma trận quy đổi
    private final double[][] ratio = {
            {1.0,        1.15077945, 1.852000,   20.2537183, 1852.0,   2025.37183, 6076.11549, 72913.38583},
            {0.86897624, 1.0,        1.6093440,  17.600000,  1609.3440,1760.0,     5280.0,     63360.0},
            {0.53995680, 0.62137119, 1.0,        10.9361330, 1000.0,   1093.61330, 3280.83990, 39370.07874},
            {0.04937365, 0.05681818, 0.0914400,  1.0,        91.440,   100.0,      300.0,      3600.0},
            {0.00053996, 0.00062137, 0.001000,   0.0109361,  1.0,      1.09361,    3.28084,    39.37008},
            {0.00049374, 0.00056818, 0.0009144,  0.0100000,  0.9144,   1.0,        3.0,        36.0},
            {0.00016458, 0.00018939, 0.0003048,  0.0033333,  0.3048,   0.333333,   1.0,        12.0},
            {0.00001371, 0.00001578, 0.0000254,  0.0002778,  0.0254,   0.02778,    0.08333,    1.0}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doi_do_dai);

        // Ánh xạ View
        txtNumber = findViewById(R.id.txtNumber);
        spnUnit = findViewById(R.id.spnUnit);

        lblResults = new TextView[]{
                findViewById(R.id.lblHaiLy),
                findViewById(R.id.lblDam),
                findViewById(R.id.lblKilomet),
                findViewById(R.id.lblLy),
                findViewById(R.id.lblMet),
                findViewById(R.id.lblYard),
                findViewById(R.id.lblFoot),
                findViewById(R.id.lblInch)
        };

        //nút quay lại trang
        findViewById(R.id.imgBack).setOnClickListener(v -> finish());

        // Spinner Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                units
        );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnUnit.setAdapter(adapter);


        spnUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                convertLength();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Xử lý chuyển đổi
        txtNumber.addTextChangedListener(new TextWatcher() {
            @Override public void onTextChanged(CharSequence s, int i, int i1, int i2) { convertLength(); }
            @Override public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        convertLength();
    }

    // Hàm đổi đơn vị
    private void convertLength() {
        int row = spnUnit.getSelectedItemPosition();
        if (row < 0) row = 0;

        String input = txtNumber.getText().toString();
        if (input.isEmpty()) input = "0";

        double value = Double.parseDouble(input);

        for (int i = 0; i < lblResults.length; i++) {
            double result = value * ratio[row][i];
            lblResults[i].setText(String.format("%.6f", result));
        }
    }
}
