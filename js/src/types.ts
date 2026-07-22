import type { AsyncTaskStatus } from '@runapi.ai/core';

/** All Qwen Image model variants, each dedicated to a single operation type. */
export type QwenImageModel = 'qwen-image-edit-image' | 'qwen-image-text-to-image' | 'qwen-image-remix-image';

/** Public Qwen Image aspect ratios. Default: 1:1. */
export type ImageAspectRatio = '1:1' | '3:4' | '9:16' | '4:3' | '16:9';
export type EditImageAspectRatio = ImageAspectRatio;
export type TextToImageAspectRatio = ImageAspectRatio;
/** Output image encoding format. */
export type OutputFormat = 'jpeg' | 'png';

/** Parameters for text-to-image generation. Prompt up to 5000 characters. */
export interface TextToImageParams {
  model: 'qwen-image-text-to-image';
  /** Image description (up to 5000 chars). */
  prompt: string;
  aspect_ratio?: TextToImageAspectRatio;
  /** Integer seed for reproducible results. */
  seed?: number;
  output_format?: OutputFormat;
  /** Webhook URL for async completion notifications. */
  callback_url?: string;
}

/**
 * Parameters for remix-image. Creates a prompt-guided variation of a source image.
 * `strength` controls deviation from the source: 0 = faithful reproduction,
 * 1 = maximum creative freedom (default: 0.8).
 */
export interface RemixImageParams {
  model: 'qwen-image-remix-image';
  /** Variation description (up to 5000 chars). */
  prompt: string;
  /** Source image URL (JPEG/PNG/WebP, up to 10 MB). */
  source_image_url: string;
  /** How much the output deviates from the source. 0 = faithful, 1 = creative (default: 0.8). */
  strength?: number;
  output_format?: OutputFormat;
  /** Integer seed for reproducible results. */
  seed?: number;
  /** Webhook URL for async completion notifications. */
  callback_url?: string;
}

/** Parameters for edit-image. Applies prompt-described changes to a source image. */
export interface EditImageParams {
  model: 'qwen-image-edit-image';
  /** Edit instruction (1-2000 chars). */
  prompt: string;
  /** Source image URL (JPEG/PNG/WebP, up to 10 MB). */
  source_image_url: string;
  aspect_ratio?: EditImageAspectRatio;
  output_format?: OutputFormat;
  /** Integer seed for reproducible results. */
  seed?: number;
  /** Webhook URL for async completion notifications. */
  callback_url?: string;
}

export interface TaskCreateResponse {
  id: string;
}

/** A single generated image result. */
export interface Image {
  /** CDN-delivered image URL. */
  url: string;
}

/** Shared task result for all Qwen Image image operations. */
export interface ImageTaskResponse {
  id: string;
  status: AsyncTaskStatus;
  /** Output images, populated once the task completes successfully. */
  images?: Image[];
  /** Error message when the task has failed. */
  error?: string;
  [key: string]: unknown;
}

export type TextToImageResponse = ImageTaskResponse;
export type RemixImageResponse = ImageTaskResponse;
export type EditImageResponse = ImageTaskResponse;

/**
 * Resolved responses returned by the `run()` methods after polling sees
 * `status: 'completed'`. Narrows the base response so `images` is
 * guaranteed non-optional in user code.
 */
export type CompletedTextToImageResponse = TextToImageResponse & {
  status: 'completed';
  images: Image[];
};

export type CompletedRemixImageResponse = RemixImageResponse & {
  status: 'completed';
  images: Image[];
};

export type CompletedEditImageResponse = EditImageResponse & {
  status: 'completed';
  images: Image[];
};
