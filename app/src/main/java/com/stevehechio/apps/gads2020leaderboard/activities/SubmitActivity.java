package com.stevehechio.apps.gads2020leaderboard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.stevehechio.apps.gads2020leaderboard.R;
import com.stevehechio.apps.gads2020leaderboard.http.LeadersAPI;
import com.stevehechio.apps.gads2020leaderboard.http.RetrofitClient;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubmitActivity extends AppCompatActivity {
    private EditText editTextFirstName,editTextLastName,editTextEmail, editTextLink;
    private LeadersAPI leadersAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        collectIds();
        Retrofit retrofit = RetrofitClient.getClient();
        leadersAPI = retrofit.create(LeadersAPI.class);
    }

    private void collectIds() {
        editTextFirstName = findViewById(R.id.et_first_name);
        editTextLastName = findViewById(R.id.et_last_name);
        editTextEmail = findViewById(R.id.et_email);
        editTextLink = findViewById(R.id.et_link);
    }

    public void back(View view) {
        finish();
    }

    public void onSubmitProject(View view) {
    String firstName = editTextFirstName.getText().toString().trim();
    String lastName = editTextLastName.getText().toString().trim();
    String email = editTextEmail.getText().toString().trim();
    String link = editTextLink.getText().toString().trim();
    if (TextUtils.isEmpty(firstName)){
        editTextFirstName.setError("Please enter first name");
    }else if (TextUtils.isEmpty(lastName)){
        editTextLastName.setError("Please enter your last name");
    }else if (TextUtils.isEmpty(email)){
        editTextEmail.setError("Please enter email address");
    }else if (TextUtils.isEmpty(link)){
        editTextLink.setError("Please enter the GitHub project");
    }else {
        showDialog(firstName,lastName,email,link);
    }
    }
    public void showDialog(String firstName,String lastName,String email, String link){
        final Dialog dialog = new Dialog(this);
        Window window = dialog.getWindow();
        assert window != null;
        window.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_response);

        LinearLayout linearLayoutSubmit = dialog.findViewById(R.id.ll_submit);
        LinearLayout linearLayoutSuccess = dialog.findViewById(R.id.ll_success);
        LinearLayout linearLayoutFail = dialog.findViewById(R.id.ll_failed);

        Button dialogButton = dialog.findViewById(R.id.btn_submit);
        dialogButton.setOnClickListener(v -> {
           Call<ResponseBody> call = leadersAPI.submitProject(firstName, lastName, email, link);
           call.enqueue(new Callback<ResponseBody>() {
               @Override
               public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   linearLayoutSuccess.setVisibility(View.VISIBLE);
                   linearLayoutSubmit.setVisibility(View.GONE);
                   linearLayoutFail.setVisibility(View.GONE);
               }

               @Override
               public void onFailure(Call<ResponseBody> call, Throwable t) {
                   linearLayoutSuccess.setVisibility(View.GONE);
                   linearLayoutSubmit.setVisibility(View.GONE);
                   linearLayoutFail.setVisibility(View.VISIBLE);
               }
           });

        });
        ImageView imageView = dialog.findViewById(R.id.iv_clear);
        imageView.setOnClickListener(v -> dialog.dismiss());
        dialog.show();

    }

}