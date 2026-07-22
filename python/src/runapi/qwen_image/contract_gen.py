CONTRACT = {
    "edit-image": {
        "models": ["qwen-image-edit-image"],
        "fields_by_model": {
            "qwen-image-edit-image": {
                "aspect_ratio": {
                    "enum": ["1:1", "3:4", "9:16", "4:3", "16:9"]
                },
                "model": {
                    "required": True
                },
                "output_format": {
                    "enum": ["png", "jpeg"]
                },
                "prompt": {
                    "required": True,
                    "min": 1,
                    "max": 2000,
                    "length": True
                },
                "seed": {
                    "type": "integer"
                },
                "source_image_url": {
                    "required": True
                }
            }
        }
    },
    "remix-image": {
        "models": ["qwen-image-remix-image"],
        "fields_by_model": {
            "qwen-image-remix-image": {
                "model": {
                    "required": True
                },
                "output_format": {
                    "enum": ["png", "jpeg"]
                },
                "prompt": {
                    "required": True,
                    "min": 1,
                    "max": 5000,
                    "length": True
                },
                "seed": {
                    "type": "integer"
                },
                "source_image_url": {
                    "required": True
                },
                "strength": {
                    "min": 0,
                    "max": 1
                }
            }
        }
    },
    "text-to-image": {
        "models": ["qwen-image-text-to-image"],
        "fields_by_model": {
            "qwen-image-text-to-image": {
                "aspect_ratio": {
                    "enum": ["1:1", "3:4", "9:16", "4:3", "16:9"]
                },
                "model": {
                    "required": True
                },
                "output_format": {
                    "enum": ["png", "jpeg"]
                },
                "prompt": {
                    "required": True,
                    "min": 1,
                    "max": 5000,
                    "length": True
                },
                "seed": {
                    "type": "integer"
                }
            }
        }
    }
}
