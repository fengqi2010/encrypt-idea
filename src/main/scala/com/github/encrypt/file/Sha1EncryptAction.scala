package com.github.encrypt.file

import org.apache.commons.codec.digest.DigestUtils

class Sha1EncryptAction extends AbstractFileEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("SHA1", DigestUtils.sha1Hex(bytes))
}
