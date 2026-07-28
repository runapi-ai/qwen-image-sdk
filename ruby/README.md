# Qwen Image API Ruby SDK for RunAPI

The Qwen Image Ruby SDK is the language-specific package for Qwen Image on RunAPI. Use this package for image generation, image editing, and creative production workflows when your application needs request bodies, task status lookup, and consistent RunAPI errors in Ruby.

This README is the Ruby package guide inside the public `qwen-image-sdk` repository. For the repository overview, start at `../README.md`; for model details, use https://runapi.ai/models/qwen-image; for API reference, use https://runapi.ai/docs/api/qwen-image/text-to-image; for SDK docs, use https://runapi.ai/docs/resources/sdks.

## Install

```bash
gem install runapi-qwen-image
```

## Quick start

```ruby
require "runapi/qwen_image"

client = RunApi::QwenImage::Client.new
task = client.text_to_image.create(
  model: "qwen-image-text-to-image",
  prompt: "A serene mountain lake at dawn",
  aspect_ratio: "1:1"
)
status = client.text_to_image.get(task.id)
```

Use `create` when you want to submit a task and return quickly, `get` when you need the latest task state, and `run` when a script should create and poll until completion. In web request handlers, prefer `create` plus webhook or later `get` polling so a worker is not held open.

RunAPI-generated file URLs are temporary. Download and store generated images in your own durable storage within 24 hours; do not treat returned URLs as long-term assets.

## Language notes

Use Ruby keyword arguments and the `RunApi::QwenImage` error classes when building image jobs, Rails workers, or scripts. The available resources are `text_to_image`, `remix_image`, and `edit_image`. Keep `RUNAPI_API_KEY` in the environment or your secret manager; never commit API keys or callback secrets.

## Links

- Model page: https://runapi.ai/models/qwen-image
- SDK docs: https://runapi.ai/docs/resources/sdks
- Product docs: https://runapi.ai/docs/api/qwen-image/text-to-image
- Pricing and rate limits: https://runapi.ai/models/qwen-image/text-to-image
- Provider comparison: https://runapi.ai/providers/alibaba
- Full catalog: https://runapi.ai/models
- Repository: https://github.com/runapi-ai/qwen-image-sdk

## License

Licensed under the Apache License, Version 2.0.
