package io.bankify.emojicompat;

import android.text.Layout;
import android.text.Spannable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.text.*;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Concrete class for {@link ReactTextAnchorViewManager} which represents view managers of anchor
 * {@code <Text>} nodes.
 */
@ReactModule(name = RNEmojiCompatTextViewManager.REACT_CLASS)
public class RNEmojiCompatTextViewManager
    extends ReactTextAnchorViewManager<RNEmojiCompatTextView, ReactTextShadowNode> {

  @VisibleForTesting
  public static final String REACT_CLASS = "RNEmojiCompatText";

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public RNEmojiCompatTextView createViewInstance(ThemedReactContext context) {
    return new RNEmojiCompatTextView(context);
  }

  @Override
  public void updateExtraData(RNEmojiCompatTextView view, Object extraData) {
    ReactTextUpdate update = (ReactTextUpdate) extraData;
    if (update.containsImages()) {
      Spannable spannable = update.getText();
      TextInlineImageSpan.possiblyUpdateInlineImageSpans(spannable, view);
    }
    view.setText(update);
  }

  @Override
  public ReactTextShadowNode createShadowNodeInstance() {
    return new ReactTextShadowNode();
  }

  @Override
  public Class<ReactTextShadowNode> getShadowNodeClass() {
    return ReactTextShadowNode.class;
  }

  @Override
  protected void onAfterUpdateTransaction(RNEmojiCompatTextView view) {
    super.onAfterUpdateTransaction(view);
    view.updateView();
  }

  @Override
  public @Nullable Map getExportedCustomDirectEventTypeConstants() {
    return MapBuilder.of("topTextLayout", MapBuilder.of("registrationName", "onTextLayout"));
  }
}