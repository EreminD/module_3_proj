package ru.inno.selenium.pageobject.sampleapp;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.lang.annotation.Annotation;
import java.util.Optional;

public class TgWatcher implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (context.getTestMethod().get().isAnnotationPresent(Severity.class)){
            if (context.getTestMethod().get().getAnnotation(Severity.class).value().equals(SeverityLevel.BLOCKER)){
                System.out.println("БЛОКЕР!!!!");
//                как уведомить в ТГ?
//                HTTP API -> token
            }
        }
        TestWatcher.super.testFailed(context, cause);
    }
}
