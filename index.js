import React from "react";
import { requireNativeComponent, Text, Platform } from "react-native";

const RNEmojiCompatText = requireNativeComponent("RNEmojiCompatText");
function EmojiCompatTextAndroid(props) {
  return (
    <RNEmojiCompatText {...props}>
      <Text {...props} />
    </RNEmojiCompatText>
  );
}

export default Platform.select({
  ios: Text,
  android: EmojiCompatTextAndroid
});
