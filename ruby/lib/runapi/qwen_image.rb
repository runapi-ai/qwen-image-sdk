# frozen_string_literal: true

require "runapi/core"
require_relative "qwen_image/types"
require_relative "qwen_image/contract_gen"
require_relative "qwen_image/resources/text_to_image"
require_relative "qwen_image/resources/remix_image"
require_relative "qwen_image/resources/edit_image"
require_relative "qwen_image/client"

module RunApi
  module QwenImage
    AuthenticationError = RunApi::Core::AuthenticationError
    RateLimitError = RunApi::Core::RateLimitError
    InsufficientCreditsError = RunApi::Core::InsufficientCreditsError
    NotFoundError = RunApi::Core::NotFoundError
    ValidationError = RunApi::Core::ValidationError
    TaskFailedError = RunApi::Core::TaskFailedError
    TaskTimeoutError = RunApi::Core::TaskTimeoutError
  end
end
