# Дипломный проект по профессии «Тестировщик»

Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

[План автоматизации](reports/plan.md)

[Отчет по итогам тестирования](reports/report.md)

[Отчет по итогам автоматизации](reports/results.md)

## Инструкция по запуску

1. Склонировать репозиторий с GitHub для запуска на локальном ПК:
   git clone git@github.com:Denwin22/QA-Diploma-KD.git

2. Открыть папку QA-Diploma-KD с помощью программы IntelliJ IDEA.

3. Работа с базой данных MySQl.
   1) Запуск контейнера docker:  
      docker-compose up -d
   2) Запуск приложения:  
      java '-Dspring.datasource.url=jdbc:mysql://localhost:3306/app' -jar ./artifacts/aqa-shop.jar
   3) Запуск тестов:  
      ./gradlew clean test '-Ddb.url=jdbc:mysql://localhost:3306/app'
   4) Сформировать отчет:  
      ./gradlew allureReport
   5) Открыть отчет в браузере командой:  
      ./gradlew allureServe
   6) Остановить контейнер:
      docker compose down

4. Работа с базой данных Postgres.
    1) Запуск контейнера docker:  
       docker-compose up
    2) Запуск приложения:  
       java '-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app' -jar ./artifacts/aqa-shop.jar
    3) Запуск тестов:  
       ./gradlew clean test '-Ddb.url=jdbc:postgresql://localhost:5432/app'
    4) Сформировать отчет:  
       ./gradlew allureReport
    5) Открыть отчет в браузере командой:  
       ./gradlew allureServe
