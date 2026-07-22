package ai.runapi.qwenimage.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/** Model slug for text to image operations. */
public final class TextToImageModel extends QwenimageValue {
  /** qwen-image-text-to-image model slug. */
  public static final TextToImageModel QWEN_IMAGE_TEXT_TO_IMAGE = new TextToImageModel("qwen-image-text-to-image");

  /** Creates a model value from a literal model slug. */
  @JsonCreator
  public TextToImageModel(String value) {
    super(value);
  }
}
