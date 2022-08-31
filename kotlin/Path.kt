class Path {
    private var fileName: String = ""
    private var filePath: String = ""
    private var file: String = ""
    private var isExtensionComplete: Boolean = false
    private var isFileNameComplete: Boolean = false
    private var isFileComplete: Boolean = false

    //  separates the file's path extension from the path and save it to a new string
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
    
    
    //  separates the file's path name from the path and save it to a new string
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
    
    //  separates the path from the file's path and save it to a new string
    fun filePathSeparator(FilePath : String): String {
        filePath = FilePath.replace("\\", "/")
        filePath = filePath.dropLastWhile { it != '/' }
        return filePath
    }
    
    //  separates the the file+extension from the file's path and save it to a new string
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
