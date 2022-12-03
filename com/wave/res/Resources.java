/*
 frameworks/base/core/java/android/content/res/Resources.java
 */
package com.wave.res;


public class Resources {



   public Resources getResources() {
        return Resources.this;
   }

    public XmlResourceParser getLayout( int id)  {
        return loadXmlResourceParser(id, "layout");
    }

    XmlResourceParser loadXmlResourceParser( int id,  String type) {
        Parser  parser = new Parser();
        return parser;
    }
}