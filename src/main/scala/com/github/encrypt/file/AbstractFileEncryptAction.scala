package com.github.encrypt.file

import com.github.encrypt.Constant
import com.intellij.notification.{Notification, NotificationType, Notifications}
import com.intellij.openapi.actionSystem.{AnAction, AnActionEvent, CommonDataKeys}
import org.apache.commons.io.FileUtils

import java.io.File

abstract class AbstractFileEncryptAction extends AnAction {
  final override def actionPerformed(e: AnActionEvent): Unit = {
    val virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE)
    if (virtualFile == null || virtualFile.isDirectory) {
      Notifications.Bus.notify(
        new Notification(Constant.groupId, Constant.title, "Please select a file", NotificationType.WARNING)
      )
      return
    }
    val path = virtualFile.getPath
    val bytes = FileUtils.readFileToByteArray(new File(path))
    val res = encrypt(bytes)
    val format = "%s (" + path.substring(path.lastIndexOf("/") + 1) + ") = %s"
    Constant.copyToClipBoard(format, res)
  }

  def encrypt(bytes: Array[Byte]): (String, String)
}
