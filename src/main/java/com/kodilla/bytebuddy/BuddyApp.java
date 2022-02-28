package com.kodilla.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;

public class BuddyApp {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> dynamicUser = new ByteBuddy()
                .subclass(User.class)
                .method(ElementMatchers.named("doSomething"))
                .intercept(FixedValue.value("Hello changed text"))
                .make()
                .load(User.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Class[] parameterTypes = { String.class, String.class};

        User test = (User)dynamicUser.getDeclaredConstructor(parameterTypes)
                .newInstance("user", "user");
        test.doSomething();
    }
}
