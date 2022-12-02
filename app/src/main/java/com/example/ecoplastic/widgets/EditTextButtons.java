package com.example.ecoplastic.widgets;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.ecoplastic.R;

public class EditTextButtons extends LinearLayout {

    private EditText editText;
    private ImageView imageButtonPlus;
    private ImageView imageButtonMinus;
    private final float scale = this.getResources().getDisplayMetrics().density;

    public EditTextButtons (Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        this.addView(imageButtonMinus);
        this.addView(editText);
        this.addView(imageButtonPlus);
    }

    protected void init(Context context, AttributeSet attrs) {
        editText = new EditText(context);
        imageButtonMinus = new ImageView(context);
        imageButtonPlus = new ImageView(context);

        // set witdth and height
        editText.setLayoutParams(new LayoutParams((int) (100.0f * scale), (int) (40.0f * scale)));
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setBackgroundResource(R.drawable.setshape);
        editText.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        editText.setTextColor(getResources().getColor(R.color.green_normal));
        editText.setText("0");
        editText.setEms(10);


        imageButtonPlus.setLayoutParams(new LayoutParams((int) (40.0f * scale), (int) (40.0f * scale)));
        imageButtonMinus.setLayoutParams(new LayoutParams((int) (40.0f * scale), (int) (40.0f * scale)));
        imageButtonMinus.setImageResource(R.drawable.ic_minus);
        imageButtonPlus.setImageResource(R.drawable.ic_plus);

        imageButtonMinus.setOnClickListener(minusButton);
        imageButtonPlus.setOnClickListener(plusButton);
    }

    /**
     * Methods
     */
    public Integer getValue() {
        return Integer.parseInt(editText.getText().toString());
    }

    /**
     * Button events
     */
    private OnClickListener plusButton = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer value = Integer.parseUnsignedInt(editText.getText().toString());
            value++;
            editText.setText(value.toString());
        }
    };

    private OnClickListener minusButton = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer value = Integer.parseUnsignedInt(editText.getText().toString());
            if ( value > 0 ) {
                value--;
                editText.setText(value.toString());
            }
        }
    };
}
