package com.github.encrypt.text

import org.apache.commons.codec.digest.DigestUtils

class Sha1EncryptAction extends AbstractTextEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("SHA1", DigestUtils.sha1Hex(bytes))
}
