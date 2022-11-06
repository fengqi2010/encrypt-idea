package com.github.encrypt

import com.intellij.codeInsight.editorActions.TextBlockTransferable
import com.intellij.notification.{EventLog, Notification, NotificationType, Notifications}
import com.intellij.openapi.actionSystem.{AnAction, AnActionEvent}
import com.intellij.openapi.ide.CopyPasteManager

import java.util.Collections

object Constant {

  val groupId = "com.github.encrypt"

  val title = "Encrypt"

  def copyToClipBoard(context: String): Unit = {
    var notification: Notification = null
    if (context.length > 64) {
      notification = new Notification(
        Constant.groupId,
        Constant.title,
        context.substring(0, 65) + "...",
        NotificationType.INFORMATION
      )
    } else {
      notification = new Notification(Constant.groupId, Constant.title, context, NotificationType.INFORMATION)
    }
    notification.addAction(new AnAction("Copy to ClipBoard") {
      override def actionPerformed(e: AnActionEvent): Unit = {
        CopyPasteManager.getInstance.setContents(new TextBlockTransferable(context, Collections.emptyList, null))
        EventLog.toggleLog(
          e.getProject,
          new Notification(Constant.groupId, Constant.title, "Copied", NotificationType.INFORMATION)
        )
        notification.expire()
      }
    })
    Notifications.Bus.notify(notification)
  }
}
