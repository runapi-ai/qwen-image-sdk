package ai.runapi.qwenimage.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Parameters for edit image operations. */
public final class EditImageParams {
  private final String model;
  private final String prompt;
  private final String sourceImageUrl;
  private final String aspectRatio;
  private final String outputFormat;
  private final Integer seed;
  private final String callbackUrl;

  private EditImageParams(Builder builder) {
    this.model = builder.model;
    this.prompt = QwenimageParamUtils.requireNonBlank(builder.prompt, "prompt");
    this.sourceImageUrl = QwenimageParamUtils.requireNonBlank(builder.sourceImageUrl, "sourceImageUrl");
    this.aspectRatio = builder.aspectRatio;
    this.outputFormat = builder.outputFormat;
    this.seed = builder.seed;
    this.callbackUrl = builder.callbackUrl;
  }

  /** Creates a new EditImageParams builder. */
  public static Builder builder() {
    return new Builder();
  }

  /** Returns the RunAPI action key for this request. */
  public String action() {
    return "qwen-image/edit-image";
  }

  /** Converts these parameters to the JSON request body shape. */
  public Map<String, Object> toMap() {
    Map<String, Object> raw = new LinkedHashMap<String, Object>();
    raw.put("model", QwenimageParamUtils.wireValue(model));
    raw.put("prompt", QwenimageParamUtils.wireValue(prompt));
    raw.put("source_image_url", QwenimageParamUtils.wireValue(sourceImageUrl));
    raw.put("aspect_ratio", QwenimageParamUtils.wireValue(aspectRatio));
    raw.put("output_format", QwenimageParamUtils.wireValue(outputFormat));
    raw.put("seed", QwenimageParamUtils.wireValue(seed));
    raw.put("callback_url", QwenimageParamUtils.wireValue(callbackUrl));
    return QwenimageParamUtils.compact(raw);
  }



  /** Builder for {@link EditImageParams}. */
  public static final class Builder {
    private String model;
    private String prompt;
    private String sourceImageUrl;
    private String aspectRatio;
    private String outputFormat;
    private Integer seed;
    private String callbackUrl;

    private Builder() {}

    /** Sets the model slug using a typed model value. */
    public Builder model(EditImageModel value) {
      this.model = java.util.Objects.requireNonNull(value, "model").value();
      return this;
    }

    /** Sets the model slug using a string value. */
    public Builder model(String value) {
      this.model = QwenimageParamUtils.requireNonBlankTrim(value, "model");
      return this;
    }


    /** Sets the text prompt. */
    public Builder prompt(String value) {
      this.prompt = QwenimageParamUtils.requireNonBlank(value, "prompt");
      return this;
    }

    /** Sets the source image URL. */
    public Builder sourceImageUrl(String value) {
      this.sourceImageUrl = QwenimageParamUtils.requireNonBlank(value, "sourceImageUrl");
      return this;
    }

    /** Sets the output aspect ratio. */
    public Builder aspectRatio(String value) {
      this.aspectRatio = QwenimageParamUtils.requireNonBlank(value, "aspectRatio");
      return this;
    }

    /** Sets the output format. */
    public Builder outputFormat(String value) {
      this.outputFormat = QwenimageParamUtils.requireNonBlank(value, "outputFormat");
      return this;
    }

    /** Sets the random seed. */
    public Builder seed(int value) {
      this.seed = value;
      return this;
    }

    /** Sets the webhook URL for task completion notifications. */
    public Builder callbackUrl(String value) {
      this.callbackUrl = QwenimageParamUtils.requireNonBlank(value, "callbackUrl");
      return this;
    }

    /** Builds immutable edit image parameters. */
    public EditImageParams build() {
      return new EditImageParams(this);
    }
  }
}
