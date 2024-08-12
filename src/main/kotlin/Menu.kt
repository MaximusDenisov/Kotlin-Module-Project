import java.util.Scanner

open class Menu {

    companion object {
        fun showOptions(
            nameList: String,
            createOption: String,
            list: MutableList<String>,
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

        fun inputChoice(): Int {
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
}