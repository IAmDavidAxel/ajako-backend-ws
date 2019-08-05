package domain.user;

public enum AccessLevel {

	CLIENT("CLIENT"), DRIVER("DRIVER"), MANAGER("MANAGER");

	private String accessLevel;

	private AccessLevel(final String role) {
		this.accessLevel = role;
	}

	public String toString() {
		return accessLevel;
	}
}
