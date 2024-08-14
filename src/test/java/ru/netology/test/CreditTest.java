package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class CreditTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @DisplayName("Approved credit card transaction")
    @Test
    public void shouldVerifyCreditApproval() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var approvedCardInformation = DataHelper.getValidCard();
        buyCredit.enterCreditCardData(approvedCardInformation);
        buyCredit.verifySuccessNotificationCreditCard();

        var statusPayment = SQLHelper.getStatusCredit();
        Assertions.assertEquals("APPROVED", statusPayment.getStatus());
    }

    @DisplayName("Successful credit transaction with current month and year")
    @Test
    public void shouldVerifyCreditWithCurrentDate() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var validCardInformation = DataHelper.getCurrentMonthAndYear();
        buyCredit.enterCreditCardData(validCardInformation);
        buyCredit.verifySuccessNotificationCreditCard();

        var statusPayment = SQLHelper.getStatusCredit();
        Assertions.assertEquals("APPROVED", statusPayment.getStatus());
    }

    @DisplayName("Credit - Declined card")
    @Test
    public void shouldHandleDeclinedCreditCard() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var declinedCard = DataHelper.getDeclinedCard();
        buyCredit.enterCreditCardData(declinedCard);
        buyCredit.verifyErrorNotificationCreditCard();

        var statusPayment = SQLHelper.getStatusCredit();
        Assertions.assertEquals("DECLINED", statusPayment.getStatus());
    }

    @DisplayName("Credit - Empty fields")
    @Test
    public void shouldNotProcessEmptyCreditForm() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var emptyCardInformation = DataHelper.getAllFieldsEmpty();
        buyCredit.enterCreditCardData(emptyCardInformation);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Card number field empty")
    @Test
    public void shouldNotProcessWithoutCardNumber() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var fieldCardEmpty = DataHelper.getCardNumberEmpty();
        buyCredit.enterCreditCardData(fieldCardEmpty);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Month field empty")
    @Test
    public void shouldNotProcessWithoutMonth() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var fieldMonthEmpty = DataHelper.getMonthEmpty();
        buyCredit.enterCreditCardData(fieldMonthEmpty);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Year field empty")
    @Test
    public void shouldNotProcessWithoutYear() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var fieldYearEmpty = DataHelper.getYearEmpty();
        buyCredit.enterCreditCardData(fieldYearEmpty);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Holder field empty")
    @Test
    public void shouldNotProcessWithoutHolderName() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var fieldHolderEmpty = DataHelper.getHolderEmpty();
        buyCredit.enterCreditCardData(fieldHolderEmpty);
        buyCredit.verifyRequiredFieldCreditCard();
    }

    @DisplayName("Credit - CVV field empty")
    @Test
    public void shouldNotProcessWithoutCvv() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var fieldCvvEmpty = DataHelper.getCVVEmpty();
        buyCredit.enterCreditCardData(fieldCvvEmpty);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Invalid card number")
    @Test
    public void shouldNotProcessInvalidCardNumber() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidNumber();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Invalid month")
    @Test
    public void shouldNotProcessInvalidMonth() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidMonth();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidDateCreditCard();
    }

    @DisplayName("Credit - Invalid year")
    @Test
    public void shouldNotProcessInvalidYear() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getWrongYear();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidDateCreditCard();
    }

    @DisplayName("Credit - Numeric cardholder name")
    @Test
    public void shouldNotProcessNumericCardHolderName() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getNumericName();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Invalid CVV")
    @Test
    public void shouldNotProcessInvalidCvv() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getInvalidCVV();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Expired month")
    @Test
    public void shouldNotProcessExpiredMonth() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getExpiredMonth();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidDateCreditCard();
    }

    @DisplayName("Credit - Expired year")
    @Test
    public void shouldNotProcessExpiredYear() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getExpiredYear();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.expiredCreditCardYear();
    }

    @DisplayName("Credit - Card number filled with zeros")
    @Test
    public void shouldNotProcessZeroCardNumber() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getZeroCard();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidFormatCreditCard();
    }

    @DisplayName("Credit - Month filled with zeros")
    @Test
    public void shouldNotProcessZeroMonth() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getZeroMonth();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidDateCreditCard();
    }

    @DisplayName("Credit - CVV filled with zeros")
    @Test
    public void shouldNotProcessZeroCvv() {
        var startPage = new StartPage();
        var buyCredit = startPage.openBuyCredit();
        var invalidCard = DataHelper.getZeroCVV();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.verifyInvalidFormatCreditCard();
    }
}
