### План авто-зации тестирования сценария покупки тура кредит. и дебет. картами.
>*_Валидные данные:_*
>* _номер карты - 16 цифр;_
>* _срок действия карты (мес/год) - дата должна быть больше текущей даты;_
>* _владелец (имя фамилия на латинском);_
>* _cvv код - 3 цифры._
#### Перечень автоматизируемых сценариев:

**1. Оплата по одобренной карте, обычная покупка, введение валидных данных:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидные данные одобренной карты;
- нажать кнопку "Продолжить".

*Ожидаемый результат:* В БД появляются данные карты (номер карты, владелец, срок действия карты) с указанием статуса, что покупка совершена успешно. Пользователь видит сообщение "Покупка совершена успешно". Данные карты не сохраняются.

**2. Оплата по отклоненной карте, обычная покупка, введение валидных данных:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидные данные отклоненной карты;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: В БД появляются данные карты (номер карты, владелец, срок действия карты) с указанием статуса, что покупка отклонена. Пользователь видит сообщение "Операция отклонена. Проверьте данные карты".

**3. Оплата по неизвестной карте, обычная покупка, введение валидных данных:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидные данные неизвестной карты;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Операция отклонена. Проверьте данные карты".

**4. Оплата по карте c невалидным номером карты (ввод 15 цифр), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести невалидный номер карты (ввести 15 цифр);
- ввести валидные данные в поле "Владелец";
- ввести валидный срок действия карты;
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**5. Оплата по карте c невалидным номером карты (ввод букв на кириллице), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести невалидный номер карты (ввести буквы на кириллице);
- ввести валидные данные в поле "Владелец";
- ввести валидный срок действия карты;
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**6. Оплата по карте c невалидным номером карты (ввод букв на латинице), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести невалидный номер карты (ввести буквы на латинице);
- ввести валидные данные в поле "Владелец";
- ввести валидный срок действия карты;
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**7. Оплата по карте c невалидным сроком действия карты (ввод 13-ого месяца), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- ввести валидные данные в поле "Владелец";
- ввести невалидный срок действия карты (пусть текущая дата будет 10/23, ввести 13 месяц - 13/23);
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверные данные". Запрос в БД не уходит.

**8. Оплата по карте c невалидным сроком действия карты (ввод даты меньше текущей), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- ввести валидные данные в поле "Владелец";
- ввести невалидный срок действия карты (пусть текущая дата будет 10/23, ввести дату меньше текущей - 09/23);
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверные данные". Запрос в БД не уходит.

**9. Оплата по карте c невалидным сроком действия карты (ввод букв на кириллице), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- ввести валидные данные в поле "Владелец";
- ввести невалидный срок действия карты (пусть текущая дата будет 10/23, ввести буквы на кириллице);
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**10. Оплата по карте c невалидным сроком действия карты (ввод букв на латинице), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- ввести валидные данные в поле "Владелец";
- ввести невалидный срок действия карты (пусть текущая дата будет 10/23, ввести буквы на латинице);
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**11. Оплата по карте c невалидным полем владелец (ввод данных на кириллице), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- в поле "Владелец" ввести невалидный данные (ввести данные на кириллице);
- ввести валидный срок действия карты;
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**12. Оплата по карте c невалидным полем владелец (ввод цифр), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- в поле "Владелец" ввести невалидный данные (ввести цифры);
- ввести валидный срок действия карты;
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**13. Оплата по карте c невалидным полем владелец (ввод спецсимволов), обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- в поле "Владелец" ввести невалидный данные (ввести спецсимволы);
- ввести валидный срок действия карты;
- ввести валидный номер CVV;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**14. Оплата по карте c невалидным полем CVV (ввод 2-ух цифр), обычная покупка**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- в поле "Владелец" ввести валидные данные;
- ввести валидный срок действия карты;
- в поле "CVV" ввести невалидный данные (ввести 2 цифры);
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**15. Оплата по карте c невалидным полем CVV (ввод букв), обычная покупка**
- на странице сервиса нажать кнопку "Купить";
- ввести валидный номер карты;
- в поле "Владелец" ввести валидные данные;
- ввести валидный срок действия карты;
- в поле "CVV" ввести невалидный данные (ввести буквы);
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Неверный формат". Запрос в БД не уходит.

**16. Оплата по карте c пустым номером карты, обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- оставить пустым поле "Номер карты", остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Поле обязательно для заполнения". Запрос в БД не уходит.

**17. Оплата по карте c пустым полем "Срок действия карты", обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- оставить пустым поле "Срок действия карты", остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Поле обязательно для заполнения". Запрос в БД не уходит.

**18. Оплата по карте c пустым полем "Владелец", обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- оставить пустым поле "Владелец", остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Поле обязательно для заполнения". Запрос в БД не уходит.

**19. Оплата по карте c пустым полем CVV, обычная покупка:**
- на странице сервиса нажать кнопку "Купить";
- оставить пустым поле "CVV", остальные поля заполнить валидными данными;
- нажать кнопку "Продолжить".

*Ожидаемый результат*: Покупка не совершается. Пользователь видит сообщение "Поле обязательно для заполнения". Запрос в БД не уходит.

**При оплате тура в кредит сделать аналогичные тесты.**

### Перечень используемых инструментов с обоснованием выбора:

* IntelliJ IDEA - интегрированная среда разработки (IDE) для создания, тестирования и анализа ПО.
* JUnit5 - фреймворк для языка программирования Java, предназначенный для автоматического тестирования программ.
* Gradle - система управления зависимостями, система автоматический сборки, которую используют для упрощения работы с Java.
* Selenide - это библиотека для написания лаконичных и стабильных UI тестов с открытым исходным кодом.
* Docker -платформа для разработки, доставки и запуска контейнерных приложений.
* Allure - фреймворк, предназначенный для создания подробных отчетов о выполнении тестов.
* Github - это онлайн-платформа для хранения, управления и совместной работы над проектами с открытым исходным кодом.

### Перечень и описание возможных рисков при автоматизаци:

* Риск появления проблем с настройкой приложения и необходимых БД.
* Риск появления проблем с правильной идентификацией полей ввода.

### Интервальная оценка с учетом риска в часах:

* Написание плана тестирования - 10 часов.
* Написание автотестов, тестирование и отладка автотестов - 64 часа.
* Формирование и анализ отчетов - 10 часов.

### План сдачи работ:

* с 15.07. по 23.07. - настройка окружения, написание плана тестирования.
* с 24.07. по 10.08. - написание автотестов, тестирование.
* с 11.08. по 14.08 - подготовка отчетных документов.