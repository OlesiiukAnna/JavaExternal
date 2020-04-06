# Multithreading with synchronization Port

v0.1. Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число
контейнеров, находящихся в текущий момент в порту и на корабле, должно
быть неотрицательным и превышающим заданную грузоподъемность суд-
на и вместимость порта. В порту работает несколько причалов. У одного
причала может стоять один корабль. Корабль может загружаться у причала,
разгружаться или выполнять оба действия
[Main java class](.src/main/java/ua/port/v1/Main1.java)

v0.2 Порт с помощью Synchronizers
[Main java class](.src/main/java/ua/port/v2/Main1.java)

v0.3 Порт с помощью Executor(ThreadPool) with stream
[Main java class](.src/main/java/ua/port/v3/Main1.java)

v0.4 Порт с помощью RWlock with Condition
[Main java class](.src/main/java/ua/port/v4/Main1.java)
