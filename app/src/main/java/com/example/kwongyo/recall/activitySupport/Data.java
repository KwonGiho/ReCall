package com.example.kwongyo.recall.activitySupport;

import org.simpleframework.xml.ElementList;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kwongyo on 2016-05-20.
 */
public class Data implements Serializable{
    @ElementList(name="images")
    List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images=images;
    }
}
