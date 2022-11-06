package com.github.encrypt.file

import org.apache.commons.codec.digest.DigestUtils

class Sha256EncryptAction extends AbstractFileEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("SHA256", DigestUtils.sha256Hex(bytes))
}
