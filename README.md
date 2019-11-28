# pastafarianismAndroidApp
Hackathon 02.11.2019

### Что это такое?
Прототип приложения для распределения пивных вулканов по пастафарианам.
### Установка
Для работы приложения требуется склонировать и запустить [проект](https://github.com/Seri4/pastafarianismRestServer).

В файле network\App.java поменять ip на свой.
```java
 private static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://{ip}:8181/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```
### Скриншоты
![](https://github.com/A-l-i-s-a/pastafarianismAndroidApp/blob/master/imag.png)


