package com.github.encrypt.file

import org.apache.commons.codec.digest.DigestUtils

class Md5EncryptAction extends AbstractFileEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("MD5", DigestUtils.md5Hex(bytes))
}
