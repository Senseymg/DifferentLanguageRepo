const val SERVICE_NAME = "PRODUCT"
const val SERVICE_TOKEN = "tok_prod_abcdef12345xyz67890!"


class ServiceAuth {
    fun isValidToken(input: String): Boolean {
        return input == SERVICE_TOKEN
    }
}