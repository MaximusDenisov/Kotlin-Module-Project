class ArchiveMenu : Menu() {

    fun showArchiveOptions(list: MutableList<Archive>) {
        while (true) {
            val noteMenu = NoteMenu()
            val listNameOfArchive = list.map { it.name }

            val showList = showOptions(
                "\nСписок архивов:",
                "Создать архив",
                listNameOfArchive
            )

            when (val choice = inputChoice()) {
                0 -> Archive.createArchive()
                in 1 until showList.size - 1 -> {

                    noteMenu.showNoteMenuOptions(Program.listOfArchive[choice - 1])
                }
                showList.lastIndex -> {
                    println("\nВыходим из приложения, до свидания!")
                    return
                }

                else -> showErrorWithRange(showList.lastIndex)
            }
        }
    }
}

class Archive(val name: String, val listOfNotes: MutableList<Note>) {

    companion object {
        fun createArchive() : Archive {
            val menu = Menu()
            while (true) {
                print("\nВведите название для архива: ")
                val nameOfArchive = menu.inputString()
                if (nameOfArchive.isBlank()) {
                    println("\n*Название архива не может быть пустым!*")
                } else {
                    val archive = Archive(nameOfArchive, mutableListOf())
                    Program.listOfArchive.add(archive)
                    return archive
                }
            }
        }
    }
}