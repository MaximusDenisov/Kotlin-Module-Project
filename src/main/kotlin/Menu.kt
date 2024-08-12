import java.util.Scanner

open class Menu {

    protected fun showOptions(
        nameList: String,
        createOption: String,
        list: List<String>,
    ): MutableList<String> {
        val showList = mutableListOf(createOption)
        list.forEach { showList.add(it) }
        showList.add("Выход")
        println(nameList)

        for ((index, option) in showList.withIndex()) {
            println("$index. $option")
        }
        return showList
    }

    protected fun showErrorWithRange(range: Int) {
        println("\n*Вы ввели значение, которого нет в диапазоне доступных значений - 0-$range!*")
    }

    protected fun inputChoice(): Int {
        print("\nВведите значение: ")
        try {
            return inputString().toInt()
        } catch (exc: NumberFormatException) {
            println("\n*Недопустимое значение!*")
        }
        return -1
    }

    fun inputString(): String {
        return Scanner(System.`in`).nextLine()
    }
}