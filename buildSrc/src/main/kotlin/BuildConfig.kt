/**
 * ビルドコンフィグ情報を定義する
 */
object BuildConfig {
    /**
     * ビルドタイプを定義
     */
    object BuildTypes {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    /**
     * フレーバーを定義
     */
    object Flavor {
        /**
         * フレーバータイプを定義
         */
        object FlavorTypes {
            const val DEVELOP = "develop"
            const val STAGING = "staging"
            const val PRODUCTION = "production"
        }

        /**
         * フレーバーディメンションを定義
         */
        object FlavorDimensions {
            const val ENVIRONMENT = "environment"
            /**
             * フレーバーディメンションのリストを返却
             */
            fun getListOfFlavorDimensions(): List<String> {
                return listOf(
                    ENVIRONMENT
                )
            }
        }
    }

    /**
     * アプリケーションidの末尾辞
     */
    object ApplicationIdSuffix {
        const val DEBUG = ".debug"
        const val DEVELOP = ".develop"
        const val STAGING = ".staging"
    }

    /**
     * バージョンネームの末尾辞
     */
    object VersionNameSuffix {
        const val DEVELOP = "-debug"
        const val STAGING = "-staging"
    }
}