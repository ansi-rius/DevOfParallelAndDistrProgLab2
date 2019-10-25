//в)  в.разрабатываем map функцию для каждого из набора данных, которая
//генерирует WritableComparable ключа и Writable данных
// для списка аэропортов эта функция в качестве value отправляет имя аэропорта.
//для списка рейсов в качестве value эта функция отправляет время задержки (в
//виде строки)
import org.apache.hadoop.io.WritableComparable;

public class AirportKey implements WritableComparable<AirportKey> {
    
}
