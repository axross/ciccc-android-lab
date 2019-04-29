package app.axross.ciccc.twoactivities;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShoppingMainActivity extends AppCompatActivity {
    private LinearLayout productList;

    private TextView totalPriceTextView;

    private int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_main);

        productList = findViewById(R.id.product_list);
        totalPriceTextView = findViewById(R.id.total_price);

        String[] productNames = getResources().getStringArray(R.array.product_names);
        int[] productPrices = getResources().getIntArray(R.array.product_prices);

        for (int i = 0; i < productNames.length; ++i) {
            ConstraintLayout item = new ConstraintLayout(this);
            productList.addView(item);
            item.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            TextView productNameTextView = new TextView(this);
            item.addView(productNameTextView);
            ConstraintLayout.LayoutParams productNameLayoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            productNameLayoutParams.topMargin = 16;
            productNameLayoutParams.bottomMargin = 16;
            productNameLayoutParams.leftMargin = 16;
            productNameLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            productNameLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            productNameLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
            productNameTextView.setLayoutParams(productNameLayoutParams);
            productNameTextView.setText(productNames[i]);

            Button addCartButton = new Button(this);
            item.addView(addCartButton);
            ConstraintLayout.LayoutParams buttonLayoutParams = new ConstraintLayout.LayoutParams((int) (100 * getResources().getDisplayMetrics().density + 0.5f), ConstraintLayout.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.topMargin = 16;
            buttonLayoutParams.bottomMargin = 16;
            buttonLayoutParams.leftMargin = 16;
            buttonLayoutParams.rightMargin = 16;
            buttonLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
            buttonLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
            buttonLayoutParams.leftToRight = productNameTextView.getId();
            buttonLayoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
            addCartButton.setLayoutParams(buttonLayoutParams);
            addCartButton.setText("Add to Cart");
            addCartButton.setOnClickListener(new AddCardButtonOnClickListener(productPrices[i]));
        }
    }

    private void updatePrice() {
        totalPriceTextView.setText(String.format("Total: %d", totalPrice));
    }

    private class AddCardButtonOnClickListener implements View.OnClickListener {
        AddCardButtonOnClickListener(int price) {
            this.price = price;
        }

        private int price;

        @Override
        public void onClick(View v) {
            totalPrice += price;

            updatePrice();
        }
    }
}
