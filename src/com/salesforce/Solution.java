package com.salesforce;

import java.util.Arrays;
import java.util.List;


public class Solution {

  public static final int DIR_MAX_DEPTH = 2;


  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    String[] commands = {"Quit", "pwd", "ls", "cd", "touch", "mkdir"};
    List<String> list = Arrays.asList(args);
    List<String> commandList = Arrays.asList(commands);
    Dir currentDir= init();
    Boolean valid = true;
    int i=0, j =0;
    String command="";


    while (valid) {
      // if no args exit
      if (args.length == 0) {
        System.exit(0);
      // else process the args
      } else {
        while (j<args.length){
          if(args[j].startsWith("cd")){
            i=commandList.indexOf("cd");
            command = args[j];
          }
          else if(args[j].startsWith("ls")){
            i=commandList.indexOf("ls");
            command = args[j];
          }
          else if(args[j].startsWith("touch")){
            i=commandList.indexOf("touch");
            command = args[j];
          }
          else if(args[j].startsWith("mkdir")){
            i=commandList.indexOf("mkdir");
            command = args[j];
          }
          else {
            i = commandList.indexOf(args[j]);
            command = args[j];
          }
          j++;
          break;
        }
      }

      switch (i) {
        //Quit
        case 0:
          System.out.println("-------------------------inside Quit case 0--------------------");
          valid = false;
          break;
          //pwd
        case 1:
          System.out.println("-------------------------inside pwd case 1--------------------");
          System.out.println(currentDir.getLocation());
          break;

          //ls
        case 2:
          System.out.println("-------------------------inside ls case 2--------------------");
          if(command.substring(3).equals("-r")){
            listDirs(currentDir.getSubDir());
            //listFiles(currentDir);
          }else {
            currentDir.getSubDir().forEach(item -> System.out.print(item.getName() + " "));
            System.out.println();
            currentDir.getFiles().forEach(file -> System.out.println(file.getName() + " "));
          }
          break;
          //cd
        case 3:
          System.out.println("-------------------------inside cd case 3--------------------");
          String dirDestination = command.substring(3);
          Dir tempDir;
          List<Dir> subDirs =currentDir.getSubDir();
          List<Dir> parents =currentDir.getParents();
          for (Dir sub : subDirs){
            if(sub.getName().contains(dirDestination)){
              tempDir=sub;
              currentDir=tempDir;
            }
          }
          for (Dir parent : parents) {
            if (parent.getName().contains(dirDestination)) {
              tempDir = parent;
              currentDir = tempDir;
            }
          }
          System.out.println(currentDir.getLocation());
          break;

          //touch
        case 4:
          System.out.println("-------------------------inside touch case 4--------------------");
          String fileName = command.substring(6);
          CustomFile tempFile = new CustomFile(fileName,currentDir);
          currentDir.addFile(tempFile);
          System.out.println("file "+fileName+" created");
          break;
          //mkdir
        case 5:
          System.out.println("-------------------------inside mkdir case 5--------------------");
          String dirName = command.substring(6);
          Dir newDir= new Dir(dirName,currentDir.getLocation()+"/"+dirName);
          currentDir.addSubDir(newDir);
          newDir.setParents(currentDir);
          currentDir=newDir;
          System.out.println("folder "+dirName+" created");
          break;
        default:
          System.out.println("-------------------------inside unknown default--------------------");
          System.out.println("unknown command");
          break;
      }
    }
  }

  private static Dir init() {
    Dir root = new Dir("root", "/root");
    Dir currentDir= root;
    return currentDir;
  }

  //passing the subDir List of the current dir
  private static void listDirs(List<Dir> myList) {
      for (Dir dir : myList) {
        System.out.println(dir.getName());
        dir.getFiles().stream().forEach(
          file -> System.out.println(file.getName()));
        listDirs(dir.getSubDir());
      }
  }
  //list files recursively
  private static void listFiles(Dir currentDir) {
    currentDir.getFiles().stream().forEach(
      file -> System.out.println(file.getName()));
      for (Dir dir : currentDir.getSubDir()) {
        listFiles(dir);
      }

  }

}

