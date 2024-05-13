package br.facens.helpcity.utils;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import br.facens.helpcity.R;

public class AppFunction {
    private static AppFunction instance;

    public AppFunction() { }

    public static synchronized AppFunction getInstance(){
        if(instance == null) {
            instance = new AppFunction();
        }
        return instance;
    }

    public void replaceFragment(FragmentManager fragmentManager, Fragment fragment, Bundle bundle, int frameLayout, String animation) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (animation.equals("DE")) {
            fragmentTransaction.setCustomAnimations(
                    R.anim.enter_right_to_left,
                    R.anim.exit_right_to_left,
                    R.anim.enter_left_to_right,
                    R.anim.exit_left_to_right);
        }
        if (animation.equals("ED")) {
            fragmentTransaction.setCustomAnimations(
                    R.anim.enter_left_to_right,
                    R.anim.exit_left_to_right,
                    R.anim.enter_right_to_left,
                    R.anim.exit_right_to_left);
        } else animation = "NA";
        fragment.setArguments(bundle);
        fragmentTransaction.replace(frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
