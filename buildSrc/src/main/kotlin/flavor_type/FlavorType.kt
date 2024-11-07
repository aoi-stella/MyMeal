package flavor_type

/**
 * フレーバータイプに関連する抽象化クラス
 */
interface FlavorType {
    val flavorName: String
    val dimension: String
    val applicationIdSuffix: String
    val versionNameSuffix: String
}