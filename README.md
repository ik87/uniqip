#  Подсчет уникальных IP

### Версии
 * [1.1] - 03-12-2020 считает ip у которых нет повтора
 * [1.0] - 21-11-2020 считает ip у которых есть повторы

## Использованные средства
* [Open JDK 11.02](https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_windows-x64_bin.zip.sha256) - компилятор\интерпритатор
* [Maven](http://maven.apache.org/index.html) сборка и управление проектом

## Компиляция
- Во избежание проблем установите JDK не ниже 11.02 скчать можно [тут](https://jdk.java.net/archive/),
- Так же необходимо установить Maven, скачать можно [тут](http://maven.apache.org/download.cgi#files)

```sh
$ cd uniqip
$ mvn package
```
Появится папка **target**, a в ней файл **uniqip.jar** 


## Запуск
```sh
$ java -jar uniq.jar ip_addresses
```

## Скорость работы (v1.1)
[файл](https://ecwid-vgv-storage.s3.eu-central-1.amazonaws.com/ip_addresses.zip) размером в ~110 гб
на железе i3-4170 3.7GHz 16gb дал такие результаты:
```sh
total ip: 8000000000
unique ip: 11
elapsed time:  40 M  7 S
```
