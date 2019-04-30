package app.axross.ciccc.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    private Calculator calculator;
    private EditText operandOneEditText;
    private EditText operandTwoEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();

        resultTextView = findViewById(R.id.operation_result_text_view);
        operandOneEditText = findViewById(R.id.operand_one_edit_text);
        operandTwoEditText = findViewById(R.id.operand_two_edit_text);

        findViewById(R.id.operation_add_btn).setOnClickListener((View view) -> compute(Calculator.Operator.ADD));
        findViewById(R.id.operation_sub_btn).setOnClickListener((View view) -> compute(Calculator.Operator.SUB));
        findViewById(R.id.operation_div_btn).setOnClickListener((View view) -> compute(Calculator.Operator.DIV));
        findViewById(R.id.operation_mul_btn).setOnClickListener((View view) -> compute(Calculator.Operator.MUL));
    }

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;

        try {
            operandOne = getOperand(operandOneEditText);
            operandTwo = getOperand(operandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);

            resultTextView.setText(getString(R.string.computation_error));

            return;
        }

        try {
            double result = calculator.calculate(operandOne, operandTwo, operator);

            resultTextView.setText(String.valueOf(result));
        } catch (Calculator.CalculationException exception) {
            resultTextView.setText("Calculation Error");
        }

    }

    private static Double getOperand(EditText operandEditText) {
        String operandText = operandEditText.getText().toString();

        return operandText.length() == 0 ? 0d :Double.valueOf(operandText);
    }
}
