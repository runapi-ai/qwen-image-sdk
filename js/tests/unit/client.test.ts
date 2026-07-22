import { describe, it, expect, beforeEach, afterAll } from 'vitest';
import { AuthenticationError } from '@runapi.ai/core';
import { QwenImageClient } from '../../src';

const originalEnv = process.env.RUNAPI_API_KEY;

describe('QwenImageClient', () => {
  beforeEach(() => {
    delete process.env.RUNAPI_API_KEY;
  });

  afterAll(() => {
    if (originalEnv === undefined) {
      delete process.env.RUNAPI_API_KEY;
    } else {
      process.env.RUNAPI_API_KEY = originalEnv;
    }
  });

  it('initializes with an API key', () => {
    const client = new QwenImageClient({ apiKey: 'test-key' });
    expect(client.editImage).toBeDefined();
  });

  it('throws when apiKey missing and env unset', () => {
    expect(() => new QwenImageClient()).toThrow(AuthenticationError);
    expect(() => new QwenImageClient({ apiKey: '' })).toThrow(AuthenticationError);
  });

  it('reads apiKey from RUNAPI_API_KEY env var', () => {
    process.env.RUNAPI_API_KEY = 'env-key';
    const client = new QwenImageClient();
    expect(client.editImage).toBeDefined();
  });

  it('exposes editImage resource', () => {
    const client = new QwenImageClient({ apiKey: 'test-key' });
    expect(client.remixImage).toBeDefined();
    expect(client.editImage).toBeDefined();
    expect(typeof client.editImage.run).toBe('function');
    expect(typeof client.editImage.create).toBe('function');
    expect(typeof client.editImage.get).toBe('function');
  });
});
