class Path {
    private var fileName: String = ""
    private var filePath: String = ""
    private var file: String = ""
    private var isExtensionComplete: Boolean = false
    private var isFileNameComplete: Boolean = false
    private var isFileComplete: Boolean = false


    fun fileExtensionSeparator(FilePath : String): String {
        var fileExtension: String = ""
        loop@ for (char in FilePath.reversed()) {
            if (char != '.' && !isExtensionComplete) {
                    fileExtension+=char
            } else {
                isExtensionComplete = true
                break@loop
            }
        }
        fileExtension = fileExtension.reversed()
        return fileExtension
    }

    fun fileNameSeparator(FilePath : String): String {
        loop@ for (char in FilePath.reversed().replace("\\", "/")) {
            if (char != '/' && !isFileNameComplete) {
                fileName+=char
            } else {
                isFileNameComplete = true
                break@loop
            }
        }
        fileName = fileName.reversed().dropLastWhile { it != '.' }.replace(".", "")
        return fileName
    }

    fun filePathSeparator(FilePath : String): String {
        filePath = FilePath.replace("\\", "/")
        filePath = filePath.dropLastWhile { it != '/' }
        return filePath
    }

    fun fileSeparator(FilePath : String): String {
            loop@ for (char in FilePath.reversed().replace("\\", "/")) {
                if (char != '/' && !isFileComplete) {
                    file+=char
                } else {
                    isFileComplete = true
                    break@loop
                }
            }
        file = file.reversed()
        return file
    }



}