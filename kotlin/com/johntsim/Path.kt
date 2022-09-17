package com.johntsim

class Path() {
    fun fileExtensionSeparator(FilePath : String): String {
        var fileExtension = ""
        loop@ for (char in FilePath.reversed()) {
            if (char != '.') {
                fileExtension+=char
            } else {
                break@loop
            }
        }
        fileExtension = fileExtension.reversed()
        return fileExtension
    }

    fun fileNameSeparator(FilePath : String): String {
        var file = ""
        var fileName = ""
        loop@ for (char in FilePath.reversed().replace("\\", "/")) {
            if (char != '/') {
                file += char
            } else {
                break@loop
            }
        }

        loop@ for (char in file.reversed()) {
            if (char != '.') fileName+=char else break@loop
        }
        return fileName
    }

    fun filePathSeparator(FilePath : String): String {
        var filePath:String = FilePath.replace("\\", "/")
        filePath = filePath.dropLastWhile { it != '/' }
        return filePath
    }

    fun fileSeparator(FilePath : String): String {
        var file = ""
        loop@ for (char in FilePath.reversed().replace("\\", "/")) {
            if (char != '/') {
                file+=char
            } else {
                break@loop
            }
        }
        file = file.reversed()
        return file
    }
}