package com.anna.themechange.dialog;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.DialogFragment;

import com.anna.themechange.R;
import com.anna.themechange.databinding.FragmentThemeDialogBinding;

public class ThemeDialogFragment extends DialogFragment {
  private FragmentThemeDialogBinding binding;
  private static final String TAG = ThemeDialogFragment.class.getSimpleName();

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentThemeDialogBinding.inflate(inflater, container,false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    binding.btnSubmit.setOnClickListener(submitButton -> {
      int selectedId = binding.themeRadioGroup.getCheckedRadioButtonId(); // Get selected radio button ID
      final RadioButton selectedRadioButton = (RadioButton) binding.getRoot().findViewById(selectedId);
      Log.i(TAG, String.format("Selected theme: %s", selectedRadioButton.getText().toString()));

      if(selectedRadioButton.getText().toString().equals(getString(R.string.light_theme))){
        // Switch to light theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
      } else if (selectedRadioButton.getText().toString().equals(getString(R.string.dark_theme))){
        // Switch to dark theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
      } else {
        // Switch to device theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
      }
      dismiss();
    });

    binding.btnCancel.setOnClickListener(cancelButton -> {
      dismiss();
    });
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
