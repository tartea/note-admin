package org.tartea.note.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.tartea.note.common.Result;
import org.tartea.note.vo.ImageVO;

/**
 * 图片操作
 *
 * @author jiawenhao
 * @date 2022-06-21 17:47
 */
@RestController
public class ImageUploadController {

    @RequestMapping("uploadImage")
    public Result uploadImage(@RequestParam("image") MultipartFile multipartFile){

        ImageVO imageVO = new ImageVO();
        imageVO.setTitle("测试");
        imageVO.setUrl("https://images-1258301517.cos.ap-nanjing.myqcloud.com/images/202202101658880.png");
        return new Result().success(imageVO);
    }
}
