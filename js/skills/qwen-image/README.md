<p align="center">
  <a href="https://github.com/runapi-ai/qwen-image">
    <h3 align="center">Qwen Image API Skill for RunAPI</h3>
  </a>
</p>

<p align="center">
  Install this agent skill, inspect Qwen Image fields, then run jobs through the RunAPI CLI.
</p>

<p align="center">
  <a href="https://runapi.ai/models/qwen-image"><strong>Model Reference</strong></a> · <a href="https://github.com/runapi-ai/cli"><strong>CLI</strong></a> · <a href="https://github.com/runapi-ai/qwen-image-sdk"><strong>SDK</strong></a>
</p>

<div align="center">

[![skills.sh](https://www.skills.sh/b/runapi-ai/qwen-image)](https://www.skills.sh/runapi-ai/qwen-image/qwen-image)
[![ClawHub](https://img.shields.io/badge/ClawHub-runapi--qwen--image-111827)](https://clawhub.ai/runapi-ai/runapi-qwen-image)
[![License](https://img.shields.io/github/license/runapi-ai/qwen-image)](https://github.com/runapi-ai/qwen-image/blob/main/LICENSE)

</div>
<br/>

Generate, remix, and edit images with Qwen Image text-to-image, image remix, and image editing. This skill helps Claude Code, Codex, Gemini CLI, Cursor, and 50+ agents integrate Qwen Image through RunAPI.

The canonical agent file is `skills/qwen-image/SKILL.md`.

## Install

```bash
npx skills add runapi-ai/qwen-image -g
```

Or paste this prompt to your AI agent:

```text
Install the qwen-image skill for me:

1. Clone https://github.com/runapi-ai/qwen-image
2. Copy the skills/qwen-image/ directory into your
   user-level skills directory (e.g. ~/.claude/skills/
   for Claude Code, ~/.codex/skills/ for Codex).
3. Verify that SKILL.md is present.
4. Confirm the install path when done.
```

## Quick example

```typescript
import { QwenImageClient } from '@runapi.ai/qwen-image';

const client = new QwenImageClient();
const result = await client.textToImage.run({
  model: 'qwen-image-text-to-image',
  prompt: 'A serene Japanese garden in autumn',
});
```

## Routing

- Model page: https://runapi.ai/models/qwen-image
- Product docs: https://runapi.ai/docs#qwen-image
- SDK docs: https://runapi.ai/docs#sdk-qwen-image
- SDK repository: https://github.com/runapi-ai/qwen-image-sdk
- Pricing and rate limits: https://runapi.ai/models/qwen-image/text-to-image
- Provider comparison: https://runapi.ai/providers/alibaba
- Browse all RunAPI models and skills: https://runapi.ai/models

## Variants

- [Text to image](https://runapi.ai/models/qwen-image/text-to-image)
- [Image remix](https://runapi.ai/models/qwen-image/remix-image)
- [Image edit](https://runapi.ai/models/qwen-image/edit-image)

## Agent rules

- Integration work uses the target language SDK; one-off generation, manual smoke tests, debugging, or user-requested CLI runs use the RunAPI CLI skill: https://github.com/runapi-ai/cli-skill
- RunAPI-generated file URLs are temporary. Download and store generated images in your own durable storage within 24 hours; do not treat returned URLs as long-term assets.
- Keep API keys in `RUNAPI_API_KEY` or RunAPI CLI config; never commit secrets.
- Prefer `create`, `get`, and `run` JSON passthrough patterns instead of inventing flags for every model parameter.
- For pricing, rate-limit, and commercial-usage answers, link to the variant page rather than the repository README.

## License

Licensed under the Apache License, Version 2.0.
