package com.andrewreitz.demo.sharedpreferences;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.content.Context;
import android.content.SharedPreferences;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Andrew
 */
public class DefaultSharedPreferenceServiceTest {

    @Mock
    Context mContext;

    @Mock
    SharedPreferences mSharedPreferences;

    @Mock
    SharedPreferences.Editor mEditor;

    SharedPreferenceService mSharedPreferenceService;

    @Before
    public void setup() {
        initMocks(this);
        when(mSharedPreferences.edit()).thenReturn(mEditor);

        mSharedPreferenceService = new DefaultSharedPreferenceService(mSharedPreferences);
    }

    @Test
    public void shouldSaveInt() {
        //Arrange
        String key = "test";
        int value = 10;

        //Act
        mSharedPreferenceService.saveInt(key, value);

        //Assert
        verify(mEditor, times(1)).putInt(key, value);
    }

    @Test
    public void shouldRetrieveInt() {
        //Arrange
        String key = "test";
        int defaultValue = 5;
        when(mSharedPreferences.getInt(key, defaultValue)).thenReturn(defaultValue);

        //Act
        mSharedPreferenceService.getInt(key, defaultValue);

        //Assert
        verify(mSharedPreferences, times(1)).getInt(key, defaultValue);
    }

    @Test
    public void shouldSaveBoolean() {
        //Arrange
        String key = "test";
        boolean value = false;

        //Act
        mSharedPreferenceService.saveBoolean(key, value);

        //Assert
        verify(mEditor, times(1)).putBoolean(key, value);
    }

    @Test
    public void shouldRetrieveBoolean() {
        //Arrange
        String key = "test";
        boolean defaultValue = true;

        //Act
        mSharedPreferenceService.getBoolean(key, defaultValue);

        //Assert
        verify(mSharedPreferences, times(1)).getBoolean(key, defaultValue);
    }

    @Test
    public void shouldSaveFloat() {
        //Arrange
        String key = "test";
        float value = 200f;

        //Act
        mSharedPreferenceService.saveFloat(key, value);

        //Assert
        verify(mEditor, times(1)).putFloat(key, value);
    }

    @Test
    public void shouldRetrieveFloat() {
        //Arrange
        String key = "test";
        float defaultValue = 400.05f;

        //Act
        mSharedPreferenceService.getFloat(key, defaultValue);

        //Assert
        verify(mSharedPreferences, times(1)).getFloat(key, defaultValue);
    }

    @Test
    public void shouldSaveString() {
        //Arrange
        String key = "test";
        String value = "Hello World!";

        //Act
        mSharedPreferenceService.saveString(key, value);

        //Assert
        verify(mEditor, times(1)).putString(key, value);
    }

    @Test
    public void shouldRetrieveString() {
        //Arrange
        String key = "test";
        String defaultValue = "Hello World!";

        //Act
        mSharedPreferenceService.getString(key, defaultValue);

        //Assert
        verify(mSharedPreferences, times(1)).getString(key, defaultValue);
    }
}
