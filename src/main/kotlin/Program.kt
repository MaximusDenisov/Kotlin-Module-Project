class Program {

    companion object {
        var listOfArchive = mutableListOf<Archive>()
        fun start() {
            println("Добро пожаловать в приложение \"Заметки\"!")
            ArchiveMenu.showArchiveOptions(listOfArchive)
        }
    }
}