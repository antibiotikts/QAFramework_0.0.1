package projects.test_builder.commands;

import org.json.JSONObject;

public abstract class BaseCommand implements TestCommand {
	protected final JSONObject jsonObject;

	public BaseCommand(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
}
