package com.github.encrypt.text

import org.apache.commons.codec.digest.DigestUtils

class Md5EncryptAction extends AbstractTextEncryptAction {

  override def encrypt(bytes: Array[Byte]): (String, String) =
    ("MD5", DigestUtils.md5Hex(bytes))
}
