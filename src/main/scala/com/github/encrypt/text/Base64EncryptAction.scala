package com.github.encrypt.text

import java.util.Base64

class Base64EncryptAction extends AbstractTextEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("BASE64", Base64.getEncoder.encodeToString(bytes))
}
