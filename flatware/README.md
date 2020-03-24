# XML parser


In code structure used MVC pattern, Command pattern.

This app parse xml files that describes flatware such as knife, fork and spoon.

* Parsing flatware xml to pojo is occurs by means of Jackson library.
* Custom annotations check if pojo parameters valid to required (length, width, quantity, volume)
* lambdas are used for commands (Command is a Functional interface)
* Commands are used in controller
[Main app class](./src/main/java/ua/flatware/FlatwareXML.java)

Task:
v0.1 использовать анотации для валидации полей
v0.2 использовать ламбда. паттерн Команда
