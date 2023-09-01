package projects.test_builder;

import com.codeborne.selenide.SelenideElement;

public class TypeCommand implements TestCommand {
	private final SelenideElement element;
	private final String value;

	public TypeCommand(SelenideElement element, String value) {
		this.element = element;
		this.value = value;
	}

	@Override
	public void execute() {
		element.setValue(value).pressEnter();
	}
}
