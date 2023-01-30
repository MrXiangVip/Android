/*
frameworks/base/core/java/android/content/res/ResourcesImpl.java
 */
package com.wave.res;

public class ResourcesImpl {

    private final Configuration mConfiguration = new Configuration();

    public ResourcesImpl( Configuration config ) {

        mConfiguration.setToDefaults();
    }

    Configuration getConfiguration() {
        return mConfiguration;
    }

    XmlResourceParser loadXmlResourceParser( String file,  int id, String type){

        Parser parser = new Parser();
        return parser;
    }

}


