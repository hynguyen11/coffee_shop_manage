package com.cafeshopmanage.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import ru.soknight.imgbb.ImgbbUploadClient;
import ru.soknight.imgbb.parameter.UploadParameters;
import ru.soknight.imgbb.response.OptionalResponse;

public class ImageUtils {
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public static String upload(MultipartFile partFile) {
        try {

            File file = new File("ImageTemp/" + partFile.getOriginalFilename());
            copyInputStreamToFile(partFile.getInputStream(), file);
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            UploadParameters parameters = new UploadParameters.Builder().apiKey(Config.get("common.imgbb.apiKey"))
                    .imageBase64(encodedString).imageName(null).build();

            OptionalResponse response = ImgbbUploadClient.upload(parameters);
            System.out.println(response.statusCode());
            System.out.println(response.statusMessage());
            System.out.println(response.get().getResponseData().getDisplayUrl());
            return response.get().getResponseData().getDisplayUrl();
        } catch (IOException e) {
            return null;
        }
    }

    private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {

        // append = false
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }
}
