@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.numberRevert
import lesson1.task1.sqr
import kotlin.math.*


/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var num = abs(n)
    var count = 0
    do {
        num /= 10
        count++
    } while (num > 0)
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    //if (n < 3) return 1
    //var num = fib(n - 1) + fib(n - 2)
    //return num
    var num1 = 1
    var num2 = 1
    if (n < 3) return 1
    for (i in 3..n) {
        num1 += num2
        num2 = num1 - num2
    }
    return num1
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var minNumber = m * n
    for (i in max(m, n)..m * n step max(m, n)) {
        if ((i % m == 0) && (i % n == 0) && (i < minNumber)) minNumber = i
    }
    return minNumber
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var minNumber = n
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0 && minNumber > i) {
            minNumber = i
            break
        }
    }
    return minNumber
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = TODO()
//for (i in 2..min(m, n)) {
//   if (isPrime(i)) {
//     if (m % i == 0 && n % i == 0) return false
//}
//}
// return true
//}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean = TODO()

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var num = x
    var count = 0
    while (num != 1) {
        if (num % 2 == 0) num /= 2
        else num = 3 * num + 1
        count++
    }
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var x1 = x
    var p = 1
    var result = 0.0
    var sign = 1
    if (x % (2.0 * PI) != 0.0) x1 = x % (2 * PI)
    while (x1.pow(p) / factorial(p) >= eps) {
        result += sign * x1.pow(p) / factorial(p)
        p += 2
        sign *= -1
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var x1 = x
    var p = 0
    var result = 0.0
    var sign = 1
    if (x % (2.0 * PI) != 0.0) x1 = x % (2 * PI)
    while (x1.pow(p) / factorial(p) >= eps) {
        result += sign * x1.pow(p) / factorial(p)
        p += 2
        sign *= -1
    }
    return result
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var num = n
    var result = 0
    while (num > 0) {
        result = result * 10 + (num % 10)
        num /= 10
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    return if (n >= Int.MAX_VALUE) false
    else return revert(n) == n

}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var num = n / 10
    val q = n % 10
    while (num > 0) {
        if (num % 10 == q) num /= 10
        else return true
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144169196...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var result: Long = 0
    var p = 1
    var count = 0
    var overFlow = 0

    for (i in 1..n) {
        if (sqr(i) >= 10.0.pow(p)) p++
        result = (result * 10.0.pow(p) + sqr(i)).toLong()
        count += p
        if ((count + overFlow) > n) break
        if (count >= 10) {
            result = 0
            overFlow += count
            count = 0

        }
    }
    return (result / 10.0.pow(overFlow + count - n) % 10).toInt()
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var result: Long = 11
    var p = 1
    var count = 2
    var overFlow = 0
    if (n == 1 || n == 2) return 1
    for (i in 3..n) {
        if (fib(i) >= 10.0.pow(p)) p++
        result = (result * 10.0.pow(p) + fib(i)).toLong()
        count += p
        if ((count + overFlow) > n) break
        if (count >= 11) {
            result = 0
            overFlow += count
            count = 0

        }

    }
    return (result / 10.0.pow(overFlow + count - n) % 10).toInt()
}

/**fun square13(n: Int): Int {
var counter = 0
var currentRes = 0
var currentPow = 1

while (counter < n) {
currentRes = sqr(currentPow)
counter += digitNumber(currentRes)
currentPow++
}

return getSequenceRes(n, counter, currentRes)
}
fun getSequenceRes(n: Int, counter: Int, currentRes: Int): Int {
val power10 = 10.0.pow(counter - n).toInt()

return if (counter == n) {
currentRes % 10
} else (currentRes / power10) % 10
}
 **/
