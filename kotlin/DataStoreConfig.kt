class DataStoreConfig {
    private val credentials = mapOf(
        "username" to "dbadmin",
        "password" to "P@ssw0rd_Secure2025!"
    )

    fun buildUrl(): String {
        return "jdbc:mysql://localhost:3306/appdb?" +
                "user=${credentials["username"]}&" +
                "password=${credentials["password"]}"
    }
}