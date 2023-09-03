package projects.test_builder;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonReader {
	private static final Logger logger = LoggerFactory.getLogger(JsonReader.class);

	public static JSONArray getJsonArray(Path path) {
		try {
			String jsonContent = new String(Files.readAllBytes(path));
			try {
				JSONArray jsonArray = new JSONArray(jsonContent);
				logger.info("build JSON array successfully");
				return jsonArray;
			} catch (JSONException e) {
				logger.error("JSON array do not building", e);
				e.printStackTrace();
				return null;
			}
		} catch (IOException e) {
			logger.error("File do not read", e);
			e.printStackTrace();
			return null;
		}
	}
}
