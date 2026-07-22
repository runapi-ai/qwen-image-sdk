package ai.runapi.qwenimage.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/** Model slug for remix image operations. */
public final class RemixImageModel extends QwenimageValue {
  /** qwen-image-remix-image model slug. */
  public static final RemixImageModel QWEN_IMAGE_REMIX_IMAGE = new RemixImageModel("qwen-image-remix-image");

  /** Creates a model value from a literal model slug. */
  @JsonCreator
  public RemixImageModel(String value) {
    super(value);
  }
}
