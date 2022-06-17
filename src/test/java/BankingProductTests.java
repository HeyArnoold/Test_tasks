
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

class BankingProductTests extends TestData {



    @DisplayName("Проверяем пополнение баланса и списание средств с баланса дебетовой карты")
    @Test
    void debitCardTest() {
        step("Пополняем аккаунт на 100", () -> {
            debitCard.accountRefill(100);
        });

        step("Проверяем, что аккаунт пополнен на 100", () -> {
            assertEquals(100, debitCard.getBalance());
        });

        step("Списываем с аккаунта 20", () -> {
            debitCard.cancellation(20);
        });

        step("Проверяем, что на аккаунте осталось 80", () -> {
            assertEquals(80, debitCard.getBalance());
        });
    }

    @DisplayName("Проверяем установку процентной ставки и сумму задолжности")
    @Test
    void creditCardTest() {
        creditCard.setInterestRate(10);
        assertEquals(10, creditCard.getInterestRate());

        creditCard.setDebt(20);
        assertEquals(20, creditCard.getDebt());
    }

    @DisplayName("Проверяем закрытие депозита и невозожность пополнения")
    @Test
    void depositTest() {
        deposit.closingTheDeposit();
        assertTrue(deposit.isDepositClosed());

        deposit.accountRefill(100);
        assertEquals(0, deposit.getBalance());
    }
}