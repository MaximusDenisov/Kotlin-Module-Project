class Program {

    companion object {
        var listOfArchive = mutableListOf<Archive>()
        fun start() {
            val archiveMenu = ArchiveMenu()
            println("Добро пожаловать в приложение \"Заметки\"!")
            archiveMenu.showArchiveOptions(listOfArchive)
        }
    }
}