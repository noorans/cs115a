package com.example.sugaranalysis;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener
{

    public static String PREFERENCE_NAME = "userName";
    public static String PREFERENCE_AGE = "userAge";
    public static String PREFERENCE_HEIGHT = "userHeight";
    public static String PREFERENCE_WEIGHT = "userWeight";
    public static String PREFERENCE_SEX = "userSex";
    public static String PREFERENCE_DNAME = "userDoctName";
    public static String PREFERENCE_DNUM = "userDoctNum";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        // Access the default shared prefs
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        setPrefSummaryName(sharedPrefs);
        setPrefSummaryAge(sharedPrefs);
        setPrefSummaryHeight(sharedPrefs);
        setPrefSummaryWeight(sharedPrefs);
        setPrefSummarySex(sharedPrefs);
        setPrefSummaryDoctorName(sharedPrefs);
        setPrefSummaryDoctorNum(sharedPrefs);
    }


    public void setPrefSummaryName(SharedPreferences sharedPrefs)
    {
        String name = sharedPrefs.getString(PREFERENCE_NAME, PersonalInformation.myName);
        Preference namePref = findPreference(PREFERENCE_NAME);
        namePref.setSummary(name);
    }
    public void setPrefSummaryAge(SharedPreferences sharedPrefs)
    {
        String age = sharedPrefs.getString(PREFERENCE_AGE, PersonalInformation.myAge);
        Preference agePref = findPreference(PREFERENCE_AGE);
        agePref.setSummary(age);
    }
    public void setPrefSummaryHeight(SharedPreferences sharedPrefs)
    {
        String height = sharedPrefs.getString(PREFERENCE_HEIGHT, PersonalInformation.myHeight);
        Preference heightPref = findPreference(PREFERENCE_HEIGHT);
        heightPref.setSummary(height);
    }
    public void setPrefSummaryWeight(SharedPreferences sharedPrefs)
    {
        String weight = sharedPrefs.getString(PREFERENCE_WEIGHT,  PersonalInformation.myWeight);
        Preference weightPref = findPreference(PREFERENCE_WEIGHT);
        weightPref.setSummary(weight);
    }
    public void setPrefSummaryDoctorName(SharedPreferences sharedPrefs)
    {
        String DoctorName = sharedPrefs.getString(PREFERENCE_DNAME, PersonalInformation.myDocName);
        Preference DoctorNamePref = findPreference(PREFERENCE_DNAME);
        DoctorNamePref.setSummary(DoctorName);
    }
    public void setPrefSummaryDoctorNum(SharedPreferences sharedPrefs)
    {
        String DoctorNum = sharedPrefs.getString(PREFERENCE_DNUM, PersonalInformation.myDocNum);
        Preference DoctorNumPref = findPreference(PREFERENCE_DNUM);
        DoctorNumPref.setSummary(DoctorNum);
    }
    public void setPrefSummarySex(SharedPreferences sharedPrefs)
    {
        String sex = sharedPrefs.getString(PREFERENCE_SEX, "1");
        String[] sexList = getResources().getStringArray(R.array.pref_sex);
        Preference sexPref = findPreference(PREFERENCE_SEX);
        sexPref.setSummary(sexList[Integer.parseInt(sex)]);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(PREFERENCE_NAME)) {
            setPrefSummaryName(sharedPreferences);
        }
        else if (key.equals(PREFERENCE_AGE)) {
            setPrefSummaryAge(sharedPreferences);
        }
        else if (key.equals(PREFERENCE_HEIGHT)) {
            setPrefSummaryHeight(sharedPreferences);
        }
        else if (key.equals(PREFERENCE_WEIGHT)) {
            setPrefSummaryWeight(sharedPreferences);
        }
        else if (key.equals(PREFERENCE_DNAME)) {
            setPrefSummaryDoctorName(sharedPreferences);
        }
        else if (key.equals(PREFERENCE_DNUM)) {
            setPrefSummaryDoctorNum(sharedPreferences);
        }
        else if (key.equals(PREFERENCE_SEX)) {
            setPrefSummarySex(sharedPreferences);
        }
    }



}