package com.marvel.characters.infra.api.env

object Parameter {

    /**
     * a md5 digest of the ts parameter, your private key and your public key
     * (e.g. md5(ts+privateKey+publicKey)
     */
    const val hash: String = "hash"

    /**
     * a timestamp (or other long string which can change on a request-by-request basis)
     */
    const val ts: String = "ts"

    /**
     * a public key encryption
     */
    const val apiKey: String = "apikey"

}