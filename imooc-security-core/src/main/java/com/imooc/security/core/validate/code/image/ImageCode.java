package com.imooc.security.core.validate.code.image;

import com.imooc.security.core.validate.code.ValidateCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.image.BufferedImage;

/**
 * @author Shinelon
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ImageCode extends ValidateCode {


    private BufferedImage image;

    ImageCode(BufferedImage image, String code, int expireIn) {
        super(code,expireIn);
        this.image = image;
    }


}
