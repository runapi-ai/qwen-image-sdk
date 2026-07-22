package ai.runapi.qwenimage.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Parameters for text to image operations. */
public final class TextToImageParams {
  private final String model;
  private final String prompt;
  private final String aspectRatio;
  private final Integer seed;
  private final String outputFormat;
  private final String callbackUrl;

  private TextToImageParams(Builder builder) {
    this.model = builder.model;
    this.prompt = QwenimageParamUtils.requireNonBlank(builder.prompt, "prompt");
    this.aspectRatio = builder.aspectRatio;
    this.seed = builder.seed;
    this.outputFormat = builder.outputFormat;
    this.callbackUrl = builder.callbackUrl;
  }

  /** Creates a new TextToImageParams builder. */
  public static Builder builder() {
    return new Builder();
  }

  /** Returns the RunAPI action key for this request. */
  public String action() {
    return "qwen-image/text-to-image";
  }

  /** Converts these parameters to the JSON request body shape. */
  public Map<String, Object> toMap() {
    Map<String, Object> raw = new LinkedHashMap<String, Object>();
    raw.put("model", QwenimageParamUtils.wireValue(model));
    raw.put("prompt", QwenimageParamUtils.wireValue(prompt));
    raw.put("aspect_ratio", QwenimageParamUtils.wireValue(aspectRatio));
    raw.put("seed", QwenimageParamUtils.wireValue(seed));
    raw.put("output_format", QwenimageParamUtils.wireValue(outputFormat));
    raw.put("callback_url", QwenimageParamUtils.wireValue(callbackUrl));
    return QwenimageParamUtils.compact(raw);
  }



  /** Builder for {@link TextToImageParams}. */
  public static final class Builder {
    private String model;
    private String prompt;
    private String aspectRatio;
    private Integer seed;
    private String outputFormat;
    private String callbackUrl;

    private Builder() {}

    /** Sets the model slug using a typed model value. */
    public Builder model(TextToImageModel value) {
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

    /** Sets the output aspect ratio. */
    public Builder aspectRatio(String value) {
      this.aspectRatio = QwenimageParamUtils.requireNonBlank(value, "aspectRatio");
      return this;
    }

    /** Sets the random seed. */
    public Builder seed(int value) {
      this.seed = value;
      return this;
    }

    /** Sets the output format. */
    public Builder outputFormat(String value) {
      this.outputFormat = QwenimageParamUtils.requireNonBlank(value, "outputFormat");
      return this;
    }

    /** Sets the webhook URL for task completion notifications. */
    public Builder callbackUrl(String value) {
      this.callbackUrl = QwenimageParamUtils.requireNonBlank(value, "callbackUrl");
      return this;
    }

    /** Builds immutable text to image parameters. */
    public TextToImageParams build() {
      return new TextToImageParams(this);
    }
  }
}
