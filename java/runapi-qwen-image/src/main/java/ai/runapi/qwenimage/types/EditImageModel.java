package ai.runapi.qwenimage.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/** Model slug for edit image operations. */
public final class EditImageModel extends QwenimageValue {
  /** qwen-image-edit-image model slug. */
  public static final EditImageModel QWEN_IMAGE_EDIT_IMAGE = new EditImageModel("qwen-image-edit-image");

  /** Creates a model value from a literal model slug. */
  @JsonCreator
  public EditImageModel(String value) {
    super(value);
  }
}
