# Тестирование ресурса opensource-demo.orangehrmlive.com
```
Реализация тестов с использованием: Gradle, JUnit5, Selenide, Log4j, Allure
```
# Автор
[Andrei Kuturmazov](https://github.com/andrei-kuturmazov)

# Тестовые сценарии
```
1. Логин пользователем с ролью администратор.
2. Добавление пользователя с проверкой формы.
3. Добавление и последующее удаление Job title.
4. Добавление кандидата без проверки формы.
5. Добавление Assign Leave с проверкой формы.
6. Проверка элементов Dashboard.
7. Проверка формы с деталями любого sales.
8. Логаут из приложения
```
# Версия JDK/Версия Java
```
1.8/Java8
```
# Версия Gradle
```
6.2.2
```
# Запуск тестов
```
gradlew clean test
```

# Генерация и просмотр Allure report
```
gradlew allureReport
gradlew allureServe
```