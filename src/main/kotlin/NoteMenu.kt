class NoteMenu : Menu() {

    fun showNoteMenuOptions(archive: Archive) {
        while (true) {
            val listOfNotes = archive.listOfNotes.map {it.name}

            val showList = showOptions(
                "Список заметок архива \"${archive.name}\":",
                "Создать заметку",
                listOfNotes
            )
            when (val choice = inputChoice()) {
                0 -> Note.createNote(archive)
                in 1 until showList.size - 1 -> showNoteOptions(archive.listOfNotes[choice - 1])
                showList.lastIndex -> {
                    println("\nВыходим из меню заметок архива \"${archive.name}\"..")
                    return
                }

                else -> showErrorWithRange(showList.lastIndex)
            }
        }
    }

    private fun showNoteOptions(note: Note) {
        while (true) {
            val listOfNotes = mutableListOf<String>()
            val showList = showOptions(
                "\nМеню заметки - \"${note.name}\"",
                "Прочитать заметку",
                listOfNotes
            )
            val choice = inputChoice()
            when (choice) {
                0 -> println("\nСодержание заметки - \"${note.name}\": " + note.content)
                showList.lastIndex -> {
                    println("\nВыходим из заметки \"${note.name}\"..\n")
                    return
                }

                else -> showErrorWithRange(showList.lastIndex)
            }
        }
    }
}

class Note(val name: String, val content: String) {
    companion object {
        fun createNote(archive: Archive): Note {
            val menu = Menu()
            var nameOfNote: String
            while (true) {
                print("\nВведите название новой заметки: ")
                nameOfNote = menu.inputString()
                if (nameOfNote.isBlank()) {
                    println("\n*Название заметки не может быть пустым!*")
                } else break
            }
            while (true) {
                print("\nВведите содержимое новой заметки: ")
                val contentForNote = menu.inputString()
                if (contentForNote.isBlank()) {
                    println("\n*Содержимое заметки не может быть пустым!*")
                } else {
                    val note = Note(nameOfNote, contentForNote)
                    archive.listOfNotes.add(note)
                    return note
                }
            }
        }
    }
}
