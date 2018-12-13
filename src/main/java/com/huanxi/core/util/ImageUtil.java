package com.huanxi.core.util;

import com.huanxi.core.hxgame.HXGame;

import javax.swing.*;
import java.awt.*;

public class ImageUtil {
    /**
     * 获取图片资源
     * @param resource
     * @return
     */
    public  static Image getImage(String resource){

      return new ImageIcon(HXGame.class.getClassLoader().getResource(resource).getPath()).getImage();
    }
}
