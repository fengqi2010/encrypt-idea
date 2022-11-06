package com.github.encrypt.file

import java.util.Base64

class Base64EncryptAction extends AbstractFileEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("BASE64", Base64.getEncoder.encodeToString(bytes))
}
