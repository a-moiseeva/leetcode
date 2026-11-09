package livecoding1

// Бежим по массиву. Если попадается 0 - увеличиваем counterFreeSeats.
//Сравниваем counterFreeSeats и maxDist
// Для начала нужна текущая дистанция, если это 1,
//то возвращаем счетчик, иначе (counterFreeSeats + 1) / 2 ( +1 чтобы округлить в большую сторону)
// Для конца сравниваем counterFreeSeats и maxDist. Если counterFreeSeats больше,
//значит последний был 0, и в counterFreeSeats маx значение уже есть

// Временная сложность: (O(N)) массив считывается ровно один раз
// Пространственная сложность: (O(1)) — используется фиксированное количество памяти под переменные-счетчики.

class Solution20 {
    fun maxDistToClosest(seats: IntArray): Int {
        var maxDist = 0
        var counterFreeSeats = 0
        var isStart = true // Флаг для левого края

        for (i in seats.indices) {
            if (seats[i] == 0) {
                counterFreeSeats++
            } else {
                // Встретили человека — считаем расстояние для пройденного участка
                val dist = if (isStart) counterFreeSeats else (counterFreeSeats + 1) / 2
                if (maxDist < dist) maxDist = dist

                counterFreeSeats = 0
                isStart = false // Левый край закончился
            }
        }

        // Правый край (после цикла)
        if (maxDist < counterFreeSeats) maxDist = counterFreeSeats

        return maxDist
    }
}
