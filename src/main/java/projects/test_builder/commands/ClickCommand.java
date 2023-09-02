package projects.test_builder.commands;

import com.codeborne.selenide.SelenideElement;

public class ClickCommand implements TestCommand {
	private final  SelenideElement element;

	public ClickCommand(SelenideElement element) {
		this.element = element;
	}

	@Override
	public void execute() {
		element.click();
	}

}
