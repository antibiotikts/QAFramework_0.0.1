package demoqa.tests_params;
import com.google.gson.annotations.SerializedName;

public class TestConfig {
	@SerializedName("browserSize")
	private String browserSize;

	@SerializedName("timeout")
	private int timeout;

	@SerializedName("browser")
	private String browser;

	public String getBrowserSize() {
		return browserSize;
	}

	public int getTimeout() {
		return timeout;
	}

	public String getBrowser() {
		return browser;
	}
}
