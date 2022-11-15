package com.example.javafxemailclient;

import com.example.javafxemailclient.controller.services.FetchFolderService;
import com.example.javafxemailclient.controller.services.FolderUpdaterService;
import com.example.javafxemailclient.model.EmailAccount;
import com.example.javafxemailclient.model.EmailTreeItem;
import javafx.scene.control.TreeItem;

import javax.mail.Folder;
import java.util.ArrayList;
import java.util.List;

public class EmailManager {

    private FolderUpdaterService folderUpdaterService;

    //Folder handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    private List<Folder> folderList = new ArrayList<Folder>();
    public List<Folder> getFolderList(){
        return this.folderList;
    }

    public EmailManager(){
        folderUpdaterService = new FolderUpdaterService(folderList);
        folderUpdaterService.start();
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(), treeItem, folderList);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
