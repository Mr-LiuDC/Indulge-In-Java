package springboot.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * FileUploadService
 *
 * @author LiuDeCai
 * @date 2018/04/08
 */
public interface FileUploadService {

    String getFileExtension(String fileName);

    boolean isValidExtension(String fileName);

    String uploadOneFile(MultipartFile file);

    String[] uploadMultipartFile(MultipartFile[] files);
}
