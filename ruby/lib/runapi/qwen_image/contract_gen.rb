# frozen_string_literal: true

module RunApi
  module QwenImage
    CONTRACT = {
      "edit-image" => {
        "models" => ["qwen-image-edit-image"],
        "fields_by_model" => {
          "qwen-image-edit-image" => {
            "aspect_ratio" => {
              "enum" => ["1:1", "3:4", "9:16", "4:3", "16:9"]
            },
            "model" => {
              "required" => true
            },
            "output_format" => {
              "enum" => ["png", "jpeg"]
            },
            "prompt" => {
              "required" => true,
              "min" => 1,
              "max" => 2000,
              "length" => true
            },
            "seed" => {
              "type" => "integer"
            },
            "source_image_url" => {
              "required" => true
            }
          }
        }
      },
      "remix-image" => {
        "models" => ["qwen-image-remix-image"],
        "fields_by_model" => {
          "qwen-image-remix-image" => {
            "model" => {
              "required" => true
            },
            "output_format" => {
              "enum" => ["png", "jpeg"]
            },
            "prompt" => {
              "required" => true,
              "min" => 1,
              "max" => 5000,
              "length" => true
            },
            "seed" => {
              "type" => "integer"
            },
            "source_image_url" => {
              "required" => true
            },
            "strength" => {
              "min" => 0,
              "max" => 1
            }
          }
        }
      },
      "text-to-image" => {
        "models" => ["qwen-image-text-to-image"],
        "fields_by_model" => {
          "qwen-image-text-to-image" => {
            "aspect_ratio" => {
              "enum" => ["1:1", "3:4", "9:16", "4:3", "16:9"]
            },
            "model" => {
              "required" => true
            },
            "output_format" => {
              "enum" => ["png", "jpeg"]
            },
            "prompt" => {
              "required" => true,
              "min" => 1,
              "max" => 5000,
              "length" => true
            },
            "seed" => {
              "type" => "integer"
            }
          }
        }
      }
    }.freeze
  end
end
