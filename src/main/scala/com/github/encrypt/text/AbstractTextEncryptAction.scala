package com.github.encrypt.text

import com.github.encrypt.Constant
import com.intellij.notification.{Notification, NotificationType, Notifications}
import com.intellij.openapi.actionSystem.{AnAction, AnActionEvent, CommonDataKeys}
import org.apache.commons.lang3.StringUtils

abstract class AbstractTextEncryptAction extends AnAction {
  final override def actionPerformed(e: AnActionEvent): Unit = {
    val editor = e.getData(CommonDataKeys.EDITOR)
    if (editor == null || StringUtils.isEmpty(editor.getSelectionModel.getSelectedText)) {
      Notifications.Bus.notify(
        new Notification(Constant.groupId, Constant.title, "Please select a text", NotificationType.WARNING)
      )
      return
    }
    val text = editor.getSelectionModel.getSelectedText
    val res = encrypt(text.getBytes)
    val context = "%s = %s".format(res._1, res._2)
    Constant.copyToClipBoard(context)
  }

  def encrypt(bytes: Array[Byte]): (String, String)
}
