package bishe.utils;

import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by sjh on 16/5/18.
 */
public class FileUploadOrDownload {
    public static void fileUpload(MultipartFile uploadfile, Environment env, String filename, String absolutePath, String directorctName) {
        BufferedOutputStream stream;
        try {
            new File(Paths.get(env.getProperty(absolutePath)) + "//"
                    + directorctName).mkdir();
            stream = new BufferedOutputStream(new FileOutputStream(new File(
                    Paths.get(
                            env.getProperty(absolutePath) + "//"
                                    + directorctName, filename).toString())));
            stream.write(uploadfile.getBytes());
            stream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fileDownload(Environment env, String filename) {
    }


    public static void deleteFile(Environment env, String filename,
                                  String absolutePath, String directoryName) {
        File files = new File(Paths.get(
                env.getProperty(absolutePath) + "\\" + directoryName)
                .toString());
        if (files.isDirectory()) {
            String[] children = files.list();

            for (int i = 0; i < children.length; i++) {

                (new File(files.toPath() + "\\" + children[i])).delete();
            }
            files.delete();
            System.out.println("文件删除成功！");
        }
    }
}

