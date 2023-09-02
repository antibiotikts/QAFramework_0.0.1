package projects.test_builder;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import projects.test_builder.commands.TestCommand;

public class CommandExecutor {

	public static void executeCommand(String action, String selector, String value) throws IllegalAccessException, InstantiationException {

		Class<? extends TestCommand> commandClass = RegistrarOfCommands.getCommandMap().get(action.toLowerCase());

		if (commandClass != null) {
			try {
				SelenideElement element = Selenide.$(By.xpath(selector));
				TestCommand command = commandClass.getConstructor(SelenideElement.class, String.class).newInstance(element, value);
				command.execute();
			} catch (ReflectiveOperationException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Unknown action: " + action);
		}
	}
}
