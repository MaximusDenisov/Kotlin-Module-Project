open class ArchiveMenu : Menu() {

    companion object {

        fun showArchiveOptions(list: MutableList<Archive>) {
            while (true) {
                val listNameOfArchive = mutableListOf<String>()
                list.forEach { listNameOfArchive.add(it.name) }

                val showList = showOptions(
                    "\nСписок архивов:",
                    "Создать архив",
                    listNameOfArchive
                )

                when (val choice = inputChoice()) {
                    0 -> Archive.createArchive()
                    in 1 until showList.size - 1 -> NoteMenu.showNoteMenuOptions(Program.listOfArchive[choice - 1])
                    showList.lastIndex -> {
                        println("\nВыходим из приложения, до свидания!")
                        return
                    }

                    else -> println("\n*Вы ввели значение, которого нет в диапазоне доступных значений - 0-${showList.lastIndex}!*")
                }
            }
        }
    }
}

class Archive(val name: String, val listOfNotes: MutableList<Note>) : ArchiveMenu() {

    companion object {
        fun createArchive() {
            while (true) {
                print("\nВведите название для архива: ")
                val nameOfArchive = inputString()
                if (nameOfArchive == "") {
                    println("\n*Название архива не может быть пустым!*")
                } else {
                    Program.listOfArchive.add(Archive(nameOfArchive, mutableListOf()))
                    break
                }
            }
        }
    }
}