package projects.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BasePage {
	private final ElementsCollection cards = $$("div.card-body");

	private final String[] cardsName = {"Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions"};

	public String[] getCardsName() {
		return cardsName;
	}

	public void openCard (String cardName) {
		cards.findBy(Condition.exactText(cardName)).scrollTo().click();
	}
 }
