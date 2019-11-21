package com.salesforce;

public class CustomFile {

  private String name;
  private String extension;
  private double size;
  private String content;
  private Dir folder;


  public CustomFile() {

  }
  public CustomFile(String name) {
    this.name = name;
  }
  public CustomFile(String name, Dir folder) {
    this.name = name;
    this.folder = folder;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
