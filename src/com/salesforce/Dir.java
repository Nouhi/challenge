package com.salesforce;

import java.util.ArrayList;
import java.util.List;

public class Dir {

  private List<Dir> subDir = new ArrayList();
  private List<Dir> parents = new ArrayList();
  private List <CustomFile>files = new ArrayList();
  private String name;
  private String location;


  public Dir() {

  }
  public Dir(String name) {
    this.name = name;
  }

  public Dir(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public List<Dir> getSubDir() {
    return subDir;
  }
  public void addSubDir(Dir subdirectory) {
    this.subDir.add(subdirectory);
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public List<CustomFile>getFiles() {
    return files;
  }
  public void setSubDir(List<Dir> subDir) {
    this.subDir = subDir;
  }
  public List<Dir> getParents() {
    return parents;
  }
  public void setParents(Dir parent) {
    this.parents.add(parent);
  }
  public void setFiles(List<CustomFile> files) {
    this.files = files;
  }
  public void addFile(CustomFile file) {
    files.add(file);
  }
  public CustomFile getFile(CustomFile file) {
    CustomFile result;
    if (files.contains(file))
      return file;
    else
      return null;
  }

}
