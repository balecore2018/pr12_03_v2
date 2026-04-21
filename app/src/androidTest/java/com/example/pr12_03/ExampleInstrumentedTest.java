package com.example.pr12_03;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.network.datas.users.UserCreate;
import com.example.network.datas.users.UserGet;
import com.example.network.datas.users.UserLogin;
import com.example.network.datas.users.UserLogout;
import com.example.network.datas.users.UserSend;
import com.example.network.datas.users.UserUpdate;
import com.example.network.domains.callbacks.MyResponseCallback;
import com.example.network.domains.common.Settings;
import com.example.network.domains.models.User;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void UserLogin() throws InterruptedException {
        final Boolean[] Success = {false};
        CountDownLatch Latch = new CountDownLatch(1);
        User User = new User("milka@gmail.com", "123123");
        new UserLogin(
                User,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER LOGIN", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {

                        Log.e("USER LOGIN", error);
                        Latch.countDown();

                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);
        assertTrue(Success[0]);
    }


    @Test
    public void UserCreate() throws InterruptedException {
        final Boolean[] Success = {false};
        CountDownLatch Latch = new CountDownLatch(1);
        User User = new User("milkatest143@mail.ru", "123123", "Тестовый", "Пользователь", "Системы",0);
        new UserCreate(
                User,
                Settings.DEMO_TOKEN, new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER CREATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {

                        Log.e("USER CREATE", error);
                        Latch.countDown();

                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);
        assertTrue(Success[0]);
    }

    @Test
    public void UserUpdate() throws InterruptedException {
        final Boolean[] Success = {false};
        CountDownLatch Latch = new CountDownLatch(1);
        User User = new User("milkatest0@mail.ru", "123123","Тестовый","Пользователь","Cистемы",0);
        new UserUpdate(
                User,
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER UPDATE", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {

                        Log.e("USER UPDATE", error);
                        Latch.countDown();

                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);
        assertTrue(Success[0]);
    }

    @Test
    public void UserGet() throws InterruptedException {
        final Boolean[] Success = {false};
        CountDownLatch Latch = new CountDownLatch(1);
        new UserGet(
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER GET", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {

                        Log.e("USER GET", error);
                        Latch.countDown();

                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);
        assertTrue(Success[0]);
    }

    @Test
    public void UserSend() throws InterruptedException {
        final Boolean[] Success = {false};
        CountDownLatch Latch = new CountDownLatch(1);
        new UserSend(
                "balecored@gmail.com",
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER SEND", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {

                        Log.e("USER SEND", error);
                        Latch.countDown();

                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);
        assertTrue(Success[0]);
    }

    @Test
    public void UserLogout() throws InterruptedException {
        final Boolean[] Success = {false};
        CountDownLatch Latch = new CountDownLatch(1);
        new UserLogout(
                Settings.DEMO_TOKEN,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result) {
                        Log.d("USER LOGOUT", result);
                        Success[0] = true;
                        Latch.countDown();
                    }

                    @Override
                    public void onError(String error) {

                        Log.e("USER LOGOUT", error);
                        Latch.countDown();

                    }
                }
        ).execute();
        Boolean Completed = Latch.await(60, TimeUnit.SECONDS);
        assertTrue(Success[0]);
    }
}