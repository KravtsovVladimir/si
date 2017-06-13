# si
Spring Integration

1) Используя SI мувнуть csv файл с локальной дириктории c:/si/source у которого, имя соответсвует некому регекспу, в папку c:/si/processing. (используется файл инбаунд  + фильтр)
2) Если файл соответсвует регекспу то его содержимое должно послаться в шенел (используется transformer).
3) Содержимое в этом шенеле должно быть преобразовано в следующий вид: айдишка + имя файла (service-activator).
4) Записать результирующий файл в папку c:/si/completed (outbound-channel-adapter).
5) Если произошла где либо ошибка мувнуть файл в c:/si/error (use errorChannel http://docs.spring.io/spring-integration/reference/html/configuration.html#namespace-errorhandler). А в лог или консоль выкинуть ошибку и имя файла в котором она произошла.
