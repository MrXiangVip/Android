/*

frameworks/base/core/java/android/content/res/XmlBlock.java   final class Parser
 */
package com.wave.res;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

final class Parser implements XmlResourceParser{

    public void close() {

    }

    @Override
    public void setFeature(String s, boolean b) throws XmlPullParserException {

    }

    @Override
    public boolean getFeature(String s) {
        return false;
    }

    @Override
    public void setProperty(String s, Object o) throws XmlPullParserException {

    }

    @Override
    public Object getProperty(String s) {
        return null;
    }

    @Override
    public void setInput(Reader reader) throws XmlPullParserException {

    }

    @Override
    public void setInput(InputStream inputStream, String s) throws XmlPullParserException {

    }

    @Override
    public String getInputEncoding() {
        return null;
    }

    @Override
    public void defineEntityReplacementText(String s, String s1) throws XmlPullParserException {

    }

    @Override
    public int getNamespaceCount(int i) throws XmlPullParserException {
        return 0;
    }

    @Override
    public String getNamespacePrefix(int i) throws XmlPullParserException {
        return null;
    }

    @Override
    public String getNamespaceUri(int i) throws XmlPullParserException {
        return null;
    }

    @Override
    public String getNamespace(String s) {
        return null;
    }

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public String getPositionDescription() {
        return null;
    }

    @Override
    public int getLineNumber() {
        return 0;
    }

    @Override
    public int getColumnNumber() {
        return 0;
    }

    @Override
    public boolean isWhitespace() throws XmlPullParserException {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public char[] getTextCharacters(int[] ints) {
        return new char[0];
    }

    @Override
    public String getNamespace() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPrefix() {
        return null;
    }

    @Override
    public boolean isEmptyElementTag() throws XmlPullParserException {
        return false;
    }

    @Override
    public int getAttributeCount() {
        return 0;
    }

    @Override
    public String getAttributeNamespace(int i) {
        return null;
    }

    @Override
    public String getAttributeName(int i) {
        return null;
    }

    @Override
    public String getAttributePrefix(int i) {
        return null;
    }

    @Override
    public String getAttributeType(int i) {
        return null;
    }

    @Override
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override
    public String getAttributeValue(int i) {
        return null;
    }

    @Override
    public String getAttributeValue(String s, String s1) {
        return null;
    }

    @Override
    public int getEventType() throws XmlPullParserException {
        return 0;
    }

    @Override
    public int next() throws XmlPullParserException, IOException {
        return 0;
    }

    @Override
    public int nextToken() throws XmlPullParserException, IOException {
        return 0;
    }

    @Override
    public void require(int i, String s, String s1) throws XmlPullParserException, IOException {

    }

    @Override
    public String nextText() throws XmlPullParserException, IOException {
        return null;
    }

    public int nextTag() {
            int eventType=0;
            return eventType;
        }
}

