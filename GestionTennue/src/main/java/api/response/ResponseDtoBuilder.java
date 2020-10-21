package api.response;


import api.dto.ResponseDto;

public class ResponseDtoBuilder {

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private ResponseDto responseDtoInstance = new ResponseDto();

		private Builder() {
		}

		public Builder withStatus(String status) {
			responseDtoInstance.setStatus(status);
			return this;
		}

		public Builder withPayload(Object payloadObject) {
			responseDtoInstance.setPayload(payloadObject);
			return this;
		}

		public Builder withMessage(String message) {
			responseDtoInstance.setMessage(message);
			return this;

		}

		public ResponseDto getResponseDto(){
			return responseDtoInstance;
		}

	}
}
