package com.github.encrypt.text

import org.apache.commons.codec.digest.DigestUtils

class Sha512EncryptAction extends AbstractTextEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("SHA256", DigestUtils.sha512Hex(bytes))
}
