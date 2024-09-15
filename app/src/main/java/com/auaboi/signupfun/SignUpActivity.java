package com.auaboi.signupfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class SignUpActivity extends AppCompatActivity {
    EditText nameField;
    EditText emailField;
    EditText dateField;
    EditText cityField;
    EditText countryField;
    EditText passwordField;
    EditText passwordConfirmField;
    CheckBox tcCheckbox;
    RadioGroup genderGroup;
    RadioGroup skillGroup;
    CheckBox sportsACheckbox;
    CheckBox sportsBCheckbox;
    CheckBox sportsCCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameField = (EditText) findViewById(R.id.editTextTextName);
        emailField = (EditText) findViewById(R.id.editTextTextEmailAddress);
        dateField = (EditText) findViewById(R.id.editTextDate);
        cityField = (EditText) findViewById(R.id.editTextTextCity);
        countryField = (EditText) findViewById(R.id.editTextTextCountry);
        passwordField = (EditText) findViewById(R.id.editTextTextPassword);
        passwordConfirmField = (EditText) findViewById(R.id.editTextTextPasswordConfirm);
        tcCheckbox = (CheckBox) findViewById(R.id.checkBoxTC);
        genderGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        skillGroup = (RadioGroup) findViewById(R.id.skillRadioGroup);

        sportsACheckbox = (CheckBox) findViewById(R.id.checkBoxSportsA);
        sportsBCheckbox = (CheckBox) findViewById(R.id.checkBoxSportsB);
        sportsCCheckbox = (CheckBox) findViewById(R.id.checkBoxSportsC);

    }

    public void verifyDetails(View view)
    {
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String date = dateField.getText().toString();
        String city = cityField.getText().toString();
        String country = countryField.getText().toString();
        String sports = "";
        String gender = "";
        String skill = "";

        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        int selectedSkillId = skillGroup.getCheckedRadioButtonId();
        if(selectedSkillId != -1){
            RadioButton skillRadio = (RadioButton) findViewById(selectedSkillId);
            skill = skillRadio.getText().toString();
        }

        if(selectedGenderId != -1) {
            RadioButton genderRadio = (RadioButton) findViewById(selectedGenderId);
            gender = genderRadio.getText().toString();
        }


        if(sportsACheckbox.isChecked()) {
            sports += sportsACheckbox.getText().toString();
        }
        if(sportsBCheckbox.isChecked()) {
            sports += sportsBCheckbox.getText().toString();
        }
        if(sportsCCheckbox.isChecked()) {
            sports += sportsCCheckbox.getText().toString();
        }


        if(!passwordField.getText().toString().equals(passwordConfirmField.getText().toString())){
            CharSequence text = "Password doesn't match password confirm!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            return;
        }

        if(!tcCheckbox.isChecked()) {
            CharSequence text = "Terms & Conditions needs to be agreed!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            return;
        }

        String message = "Name: " + name + "\n" + "Email: " + email + "\n" + "Gender: " + gender
                + "\n" + "Born on: " + date + "\n" + "City and Country: " + city + ", " + country
                + "\n" + "Sports: " + sports + "\n" + "Skill: " + skill;


        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.layoutMain), message, Snackbar.LENGTH_LONG);

        View snackbarView = snackbar.getView();
        TextView textView = (TextView) snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setMaxLines(10);  // show multiple line

        snackbar.show();
    }

    public void clearAll(View view) {
        nameField.getText().clear();
        emailField.getText().clear();
        dateField.getText().clear();
        cityField.getText().clear();
        countryField.getText().clear();
        passwordField.getText().clear();
        passwordConfirmField.getText().clear();

        genderGroup.clearCheck();
        skillGroup.clearCheck();

        sportsACheckbox.setChecked(false);
        sportsBCheckbox.setChecked(false);
        sportsCCheckbox.setChecked(false);

        tcCheckbox.setChecked(false);
    }
}