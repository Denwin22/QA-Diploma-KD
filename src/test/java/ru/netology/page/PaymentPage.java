package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {

    private final SelenideElement heading = $(byText("Оплата по карте"));
    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement expirationMonthField = $("[placeholder='08']");
    private final SelenideElement expirationYearField = $("[placeholder='22']");
    private final SelenideElement cardHolderField = fields.get(3);
    private final SelenideElement cvsField = $("[placeholder='999']");
    private final SelenideElement continueButton = $(withText("Продолжить"));

    private final SelenideElement successNotification = $(withText("Успешно"));
    private final SelenideElement errorNotification = $(withText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement invalidFormat = $(withText("Неверный формат"));
    private final SelenideElement requiredField = $(withText("Поле обязательно для заполнения"));
    private final SelenideElement expiredYearError = $(withText("Истёк срок действия карты"));
    private final SelenideElement invalidDateError = $(withText("Неверно указан срок действия карты"));

    public PaymentPage() {
        heading.shouldBe(visible);
    }

    public void enterCardData(DataHelper.CardInformation cardInformation) {
        cardNumberField.setValue(cardInformation.getCardNumber());
        expirationMonthField.setValue(cardInformation.getMonth());
        expirationYearField.setValue(cardInformation.getYear());
        cardHolderField.setValue(cardInformation.getHolder());
        cvsField.setValue(cardInformation.getCVV());
        continueButton.click();
    }

    public void verifySuccessNotificationCard() {
        successNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void verifyErrorNotificationCard() {
        errorNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void verifyInvalidFormatCard() {
        invalidFormat.shouldBe(visible);
    }

    public void verifyRequiredFieldCard() {
        requiredField.shouldBe(visible);
    }

    public void expiredCardYear() {
        expiredYearError.shouldBe(visible);
    }

    public void verifyInvalidDateCard() {
        invalidDateError.shouldBe(visible);
    }
}
