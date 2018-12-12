package io.bankify.emojicompat;

import android.app.Application;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.uimanager.ViewManager;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class RNEmojiCompatTextPackage implements ReactPackage {

    public RNEmojiCompatTextPackage(Application application) {
        EmojiCompat.Config config = new BundledEmojiCompatConfig(application);
        EmojiCompat.init(config);
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext context) {
        return Collections.singletonList((ViewManager) new RNEmojiCompatTextViewManager());
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        return modules;
    }
}