package org.tartea.note.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.tartea.note.common.Result;
import org.tartea.note.cos.AbstractCos;
import org.tartea.note.cos.factory.CosFactory;
import org.tartea.note.vo.ImageVO;

import java.io.File;
import java.io.IOException;

/**
 * 图片操作
 *
 * @author jiawenhao
 * @date 2022-06-21 17:47
 */
@RestController
public class ImageUploadController {

    @Value("${location.tempDir:/note/file}")
    private String tempDir;

    private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);
    @Autowired
    private CosFactory cosFactory;

    @RequestMapping("uploadImage")
    public Result uploadImage(@RequestParam("image") MultipartFile multipartFile) {

        try {
            if (multipartFile.isEmpty()) {
                return new Result().fail(-1, "文件不存在");
            }
            //获取上传文件名,包含后缀
            String originalFilename = multipartFile.getOriginalFilename();
            File file = new File(tempDir, originalFilename);
            multipartFile.transferTo(file);
            AbstractCos cos = cosFactory.getCos();
            String savePath = cos.upload(file.getPath());

            ImageVO imageVO = new ImageVO();
            imageVO.setTitle("测试");
            imageVO.setUrl(savePath);
            return new Result().success(imageVO);
        } catch (IOException e) {
            logger.error("上传图片失败", e);
        }
        return new Result().fail();
    }

}
