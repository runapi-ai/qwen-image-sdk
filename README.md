<p align="center">
  <a href="https://runapi.ai"><img src="https://runapi.ai/icon.svg" height="56" alt="RunAPI"></a>
</p>

<h3 align="center">
  <a href="https://github.com/runapi-ai/qwen-image-sdk">Qwen Image API SDK for RunAPI</a>
</h3>

<p align="center">
  Qwen Image API SDKs for JavaScript, Python, Ruby, Go, Java, and PHP on RunAPI.
</p>

<div align="center">

[![npm](https://img.shields.io/npm/v/@runapi.ai/qwen-image)](https://www.npmjs.com/package/@runapi.ai/qwen-image)
[![PyPI](https://img.shields.io/pypi/v/runapi-qwen-image)](https://pypi.org/project/runapi-qwen-image/)
[![RubyGems](https://img.shields.io/gem/v/runapi-qwen-image)](https://rubygems.org/gems/runapi-qwen-image)
[![Go Reference](https://pkg.go.dev/badge/github.com/runapi-ai/qwen-image-sdk/go.svg)](https://pkg.go.dev/github.com/runapi-ai/qwen-image-sdk/go)
[![Maven Central](https://img.shields.io/maven-central/v/ai.runapi/runapi-qwen-image)](https://central.sonatype.com/artifact/ai.runapi/runapi-qwen-image)
[![License](https://img.shields.io/github/license/runapi-ai/qwen-image-sdk)](https://github.com/runapi-ai/qwen-image-sdk/blob/main/LICENSE)

</div>
<br/>

The Qwen Image API SDK packages JavaScript, Python, Ruby, Go, Java, and PHP clients for Qwen Image on RunAPI. Use it for text-to-image, remix-image, and edit-image workflows when your app needs typed request builders, predictable task polling, file upload helpers, account helpers, and consistent RunAPI errors.

Qwen Image is listed in the RunAPI model catalog at https://runapi.ai/models/qwen-image. Variant pages below carry pricing, rate-limit, and commercial-usage details. The public `qwen-image-sdk` repository groups the non-PHP language packages, examples, CI, and release tags for this model. The PHP package is released from a split Composer repository.

## Install

```bash
npm install @runapi.ai/qwen-image
pip install runapi-qwen-image
gem install runapi-qwen-image
go get github.com/runapi-ai/qwen-image-sdk/go@latest
```

Gradle:

```kotlin
dependencies {
  implementation("ai.runapi:runapi-qwen-image:0.1.0")
}
```

Maven:

```xml
<dependency>
  <groupId>ai.runapi</groupId>
  <artifactId>runapi-qwen-image</artifactId>
  <version>0.1.0</version>
</dependency>
```

Use the Java BOM when installing multiple RunAPI Java modules:

```kotlin
dependencies {
  implementation(platform("ai.runapi:runapi-bom:0.2.4"))
  implementation("ai.runapi:runapi-qwen-image")
}
```

The PHP package is published from the split Composer repository as `runapi-ai/qwen-image`; see https://github.com/runapi-ai/qwen-image-php for PHP install and examples.

## What you can build

- Build apps, agent workflows, batch jobs, and production services around Qwen Image requests.
- Install only the language package your app needs while keeping one model-specific repository for docs and releases.
- Use `create` for submit-only jobs, `get` for status lookup, and `run` for submit-and-poll scripts.
- Upload local files, URL files, or base64 files through shared RunAPI file helpers.
- Handle validation, authentication, rate limits, insufficient credits, task failures, and polling timeouts through RunAPI SDK errors.

## Java quick start

```java
import ai.runapi.qwenimage.QwenImageClient;
import ai.runapi.qwenimage.types.TextToImageParams;
import ai.runapi.qwenimage.types.CompletedTextToImageResponse;
import ai.runapi.qwenimage.types.TextToImageModel;

QwenImageClient client = QwenImageClient.builder()
    .apiKey(System.getenv("RUNAPI_API_KEY"))
    .build();

CompletedTextToImageResponse result = client.textToImage().run(
    TextToImageParams.builder()
        .model(TextToImageModel.QWEN_IMAGE_TEXT_TO_IMAGE)
        .prompt("A minimal app icon for a media API")
        .aspectRatio("1:1")
        .build()
);
```

Java packages target Java 8 bytecode and are tested on Java 8, 11, 17, and 21. Each model artifact depends on `ai.runapi:runapi-core`, so application code normally installs only `ai.runapi:runapi-qwen-image`.

## Task lifecycle

Most media endpoints are asynchronous. `create()` submits a task and returns its id, `get(id)` fetches the latest task state, and `run(params)` creates the task and polls until it reaches a terminal state. In web request handlers, prefer `create()` plus webhook or later `get()` polling so the server does not hold a worker open.

## Repository layout

- `js/` publishes `@runapi.ai/qwen-image`.
- `python/` publishes `runapi-qwen-image`.
- `ruby/` publishes `runapi-qwen-image`.
- `go/` publishes `github.com/runapi-ai/qwen-image-sdk/go` and depends on `github.com/runapi-ai/core-sdk/go`.
- `java/` publishes `ai.runapi:runapi-qwen-image` and depends on `ai.runapi:runapi-core`.

## Public links

- Model page: https://runapi.ai/models/qwen-image
- SDK docs: https://runapi.ai/docs#sdk-qwen-image
- Product docs: https://runapi.ai/docs#qwen-image
- SDK repository: https://github.com/runapi-ai/qwen-image-sdk
- PHP package repository: https://github.com/runapi-ai/qwen-image-php
- Skill repository: https://github.com/runapi-ai/qwen-image
- Provider comparison: https://runapi.ai/providers/alibaba
- Full catalog: https://runapi.ai/models

## Pricing and variants

Use the most specific Qwen Image variant page for pricing, rate limits, and commercial usage:
- [Text to image](https://runapi.ai/models/qwen-image/text-to-image)
- [Image remix](https://runapi.ai/models/qwen-image/remix-image)
- [Image edit](https://runapi.ai/models/qwen-image/edit-image)

Default pricing link for the Qwen Image SDK: https://runapi.ai/models/qwen-image/text-to-image

## File storage

RunAPI-generated file URLs are temporary. Download and store generated images in your own durable storage within 24 hours; do not treat returned URLs as long-term assets.

## FAQ

### Which package should I install for Qwen Image work?

Install the model package for your language: `@runapi.ai/qwen-image` on npm, `runapi-qwen-image` on PyPI, `runapi-qwen-image` on RubyGems, `github.com/runapi-ai/qwen-image-sdk/go`, `ai.runapi:runapi-qwen-image` on Maven Central, or `runapi-ai/qwen-image` on Packagist. Install core SDK packages only when you are building shared SDK infrastructure.

### Where should public links point?

Primary Qwen Image links point to https://runapi.ai/models/qwen-image. Pricing and usage-policy links point to variant pages such as https://runapi.ai/models/qwen-image/text-to-image. Provider comparisons point to https://runapi.ai/providers/alibaba, and broad browsing points to https://runapi.ai/models.

## License

Licensed under the Apache License, Version 2.0.
