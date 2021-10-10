package com.aptech.helpers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class MediaFiles {
    public static List<File> getMediaFiles(File path) {
        File file = new File(path + "/");
        List<File> files = (List<File>) FileUtils.listFiles(
                file,
                new RegexFileFilter("^(.*?)"),
                DirectoryFileFilter.DIRECTORY
        );
        return files;
    }

    public static void processUploadedFile(FileItem item, File root) {
        String fileName = item.getName();
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();
        File path = new File(root + "/uploads");
        if (!path.exists()) {
            path.mkdirs();
        }
        File uploadedFile = new File(path + "/" + fileName);
        try {
            System.out.println("File Uploaded to :" + uploadedFile.getAbsolutePath());
            item.write(uploadedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
