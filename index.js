import { requireNativeComponent, Text, Platform } from "react-native";

const RNEmojiCompatText = requireNativeComponent("RNEmojiCompatText");
function EmojiCompatTextAndroid(props) {
  return (
    <RNEmojiCompatText>
      <Text {...props} />
    </RNEmojiCompatText>
  );
}

export default Platform.select({
  ios: Text,
  android: EmojiCompatTextAndroid
});
