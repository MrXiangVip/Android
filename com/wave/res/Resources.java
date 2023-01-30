/*
 frameworks/base/core/java/android/content/res/Resources.java
 */
package com.wave.res;

import com.wave.res.Configuration;

public class Resources {


   private ResourcesImpl mResourcesImpl;

   private Resources() {
        final Configuration config = new Configuration();

        mResourcesImpl = new ResourcesImpl(  config );
   }
   public Resources getResources() {
        return Resources.this;
   }

    public XmlResourceParser getLayout( int id)  {
        return loadXmlResourceParser(id, "layout");
    }

    XmlResourceParser loadXmlResourceParser( int id,  String type) {
        final String value="";
        try {

            final ResourcesImpl impl = mResourcesImpl;
            return loadXmlResourceParser(value, id, type);
        } finally {

        }
    }

    XmlResourceParser loadXmlResourceParser(String file, int id,String type)  {
        return mResourcesImpl.loadXmlResourceParser(file, id, type);
    }

}