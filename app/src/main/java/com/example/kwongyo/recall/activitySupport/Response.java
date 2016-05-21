package com.example.kwongyo.recall.activitySupport;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

/**
 * Created by kwongyo on 2016-05-20.
 */
@Default
@Root(name="response")
public class Response implements Serializable {
    public Data getData(){return data;}
    public void setData(Data data) { this.data=data;}
    @Element(name="data")
    Data data;
}
