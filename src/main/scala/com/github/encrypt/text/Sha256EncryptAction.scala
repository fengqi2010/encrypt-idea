package com.github.encrypt.text

import org.apache.commons.codec.digest.DigestUtils

class Sha256EncryptAction extends AbstractTextEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("SHA256", DigestUtils.sha256Hex(bytes))
}
