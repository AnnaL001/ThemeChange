package com.anna.themechange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.ViewGroup;

import com.anna.themechange.databinding.ActivityMainBinding;
import com.anna.themechange.dialog.ThemeDialogFragment;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.themeButton.setOnClickListener(view -> {
      // Initialize fragment manager that's responsible for adding, replacing, removing fragments dynamically
      FragmentManager fragmentManager = getSupportFragmentManager();
      // Initialize the theme selection fragment
      ThemeDialogFragment themeDialogFragment = new ThemeDialogFragment();
      // Display the theme selection fragment
      themeDialogFragment.show(fragmentManager, "Theme Selection Fragment");
    });
  }
}